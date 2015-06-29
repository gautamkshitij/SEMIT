package uic.semit.Project.SourceCode.Downloading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

public class Read_SourceCode_WebHooks
{
	/*
	 * menu_consume_git menu_consume_mercurial menu_consume_svn menu_consume_cvs
	 * menu_consume_code menu_consume_hg
	 */

	static ArrayList<String> menuConstants = new ArrayList<String>(
			Arrays.asList("git", "mercurial", "svn", "cvs", "code", "hg"));

	static Document projectHomePage;
	static List<String> webHookURLsProject = new ArrayList<String>();

	public static void main(String[] args)
	{

		try (BufferedReader br = new BufferedReader(new FileReader(
				"./DATA/projectNames/Java_Project_Names.txt")))
		{
			ProjectStructure projectStructure;
			for (String project; (project = br.readLine()) != null;)
			{
				projectStructure = new ProjectStructure();

				projectStructure.setProjectName(project);

				projectStructure = getProjectStructure(project,
						projectStructure);
				new Downloading(projectStructure);
				System.out.println(project);

			}

			Path out = Paths.get("commandScripts.txt");

			Files.write(out, webHookURLsProject, Charset.defaultCharset());

		}
		/*
		 * executorservice executorservice = executors.newfixedthreadpool(3);
		 * 
		 * for (int i = 0; i < projects.size(); i++) { runnable
		 * projectdownloader = new myrunnable(projects.get(i), i);
		 * executorservice.execute(projectdownloader); }
		 * 
		 * executorservice.shutdown();
		 * 
		 * while (!executorservice.isterminated()) {
		 * 
		 * } system.out.println("finished all thread");
		 */

		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}

	public static ProjectStructure getProjectStructure(String project,
			ProjectStructure projectStructure)
	{
		List<String> internalFolders = new ArrayList<String>();
		Map<String, List<String>> folderStructure = new HashMap<String, List<String>>();
		Map<String, String> internFolder_with_URL = new HashMap<String, String>();

		try
		{
			projectHomePage = Jsoup.connect(
					"http://sourceforge.net/projects/" + project).get();

			Elements menuElements = projectHomePage
					.select("li[id^=menu_consume");

			for (String menuType : menuConstants)
			{
				Elements codeMenuElements = menuElements
						.select("li[id^=menu_consume_" + menuType);

				if (codeMenuElements.size() != 0)
				{
					Elements ulElement = codeMenuElements.select("ul");
					if (ulElement.size() > 0)
					{
						Elements liElements = ulElement.select("li");
						/*
						 * get href from <a> -> extract clone link extract text
						 * node from li element -> make folder->
						 * projectName/menuConstant/cloneHere
						 */

						for (Element e : liElements)
						{
							Elements anchorTag = e.getElementsByTag("a");
							String acnhorText = anchorTag.text();
							String achorLink = anchorTag.attr("href");
							/*
							 * calling getReadonlyURL for all internal urls
							 */
							if (acnhorText.length() != 0
									&& achorLink.length() != 0)
							{
								internalFolders.add(acnhorText);

								internFolder_with_URL.put(acnhorText,
										getReadOnlyURL(achorLink, project));

								// it does have internal projects, so true
							}
						}
						if (internalFolders.size() != 0)
						{
							// System.out.println(menuType+""+internalFolders);
							folderStructure.put(menuType, internalFolders);

						}
					}
					else
					{

						/*
						 * get href -> extract clone link get span text node,
						 * make it as folder inside
						 * /projectName/menuType/clone_here
						 */
						for (Element e : codeMenuElements)
						{
							Elements anchorTag = e.getElementsByTag("a");
							Elements spanTag = e.getElementsByTag("span");
							String achorLink = anchorTag.attr("href");
							String spanText = spanTag.text();
							/*
							 * calling getReadonlyURL for all internal urls
							 */
							if (achorLink.length() != 0
									&& spanText.length() != 0)
							{

								internFolder_with_URL.put(menuType,
										getReadOnlyURL(achorLink, project));
								folderStructure.put(menuType, null);
							}
						}

					}
					projectStructure.setFolderStructure(folderStructure);
					projectStructure
							.setInternFolder_with_URL(internFolder_with_URL);
				}

			}

		}
		catch (Exception e)
		{
		}
		return projectStructure;

	}

	public static String getReadOnlyURL(String url, String project)
	{
		String readOnlyUrl = "";

		Document projectInternalPage;
		try
		{
			projectInternalPage = Jsoup.connect("http://sourceforge.net" + url)
					.get();

			Element access_urls = projectInternalPage
					.getElementById("access_urls");
			if (access_urls != null)
			{
				Elements anchorTags = access_urls.getElementsByTag("a");

				for (Element e : anchorTags)
				{
					if (e.text().equalsIgnoreCase("RO"))
					{

						readOnlyUrl = e.attr("data-url");
					}
				}

			}
			else
			{
				/*
				 * no access url
				 */
				Elements code = projectInternalPage.select("code");
				for (Node child : code.get(0).childNodes())
				{
					if (child instanceof TextNode)
					{
						if (((TextNode) child).text().length() != 0)
						{
							if (child.toString().trim().length() != 0)
							{
								readOnlyUrl = child.toString() + project;
							}
						}
					}
				}
			}

		}
		catch (Exception e)
		{
			System.err.println(e.toString());
		}

		return readOnlyUrl.trim();

	}

	// public static class MyRunnable implements Runnable
	// {
	// private final String projectName;
	// private final int projNumber;
	//
	// MyRunnable(String name, int projNumber)
	// {
	// this.projectName = name;
	// this.projNumber = projNumber;
	// }
	//
	// @Override
	// public void run()
	// {
	// ProjectStructure projectStructure = new ProjectStructure();
	//
	// projectStructure.setProjectName(this.projectName);
	//
	// projectStructure = getProjectStructure(this.projectName,
	// projectStructure);
	//
	// try
	// {
	// new Downloading(projectStructure);
	// }
	// catch (Exception e)
	// {
	// // TODO Auto-generated catch block
	// System.err.println(e.toString() + "Error: " + this.projectName);
	// }
	// System.out.println(this.projNumber + " - " + this.projectName);
	//
	// }
	// }

}
