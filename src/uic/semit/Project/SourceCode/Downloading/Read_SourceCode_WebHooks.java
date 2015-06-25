package uic.semit.Project.SourceCode.Downloading;

import java.io.BufferedReader;
import java.io.FileReader;
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

	static ArrayList<String> menuConstants = new ArrayList<String>(
			Arrays.asList("git", "mercurial", "svn", "cvs", "code", "hg"));
	static Document projectHomePage;

	/*
	 * menu_consume_git menu_consume_mercurial menu_consume_svn menu_consume_cvs
	 * menu_consume_code menu_consume_hg
	 */
	public static void main(String[] args)
	{
		ProjectStructure projectStructure;
		try (BufferedReader br = new BufferedReader(new FileReader(
				"./DATA/projectNames/Java_Project_Names.txt")))
		{
			for (String project; (project = br.readLine()) != null;)
			{
				projectStructure = new ProjectStructure();

				projectStructure.setProjectName("jibx");

				getWebHookURL("jibx", projectStructure);
				System.out.println(projectStructure);
				break;
			}
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}

	public static void getWebHookURL(String project,
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

								// getReadOnlyURL(anchorTag.attr("href"),
								// project,
								// menuType, anchorTag.text(), true);
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
				// System.out.println("no access url");
				Elements code = projectInternalPage.select("code");

				for (Node child : code.get(0).childNodes())
				{
					if (child instanceof TextNode)
					{
						// System.out.println(((TextNode) child).text());
						if (((TextNode) child).text().length() != 0)
						{
							// readOnlyUrl = ((TextNode)
							// child).text().toString();
							// readOnlyUrl = readOnlyUrl + project;
							// ((TextNode) child).text().toString();

							// System.out.println(child.toString());
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
}
