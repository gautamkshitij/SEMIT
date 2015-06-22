package uic.semit.Project.SourceCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Read_SourceCode_WebHooks
{
	static ArrayList<Elements> menuElementsList = new ArrayList<Elements>();
	static ArrayList<String> menuConstants = new ArrayList<String>(
			Arrays.asList("git", "mercurial", "svn", "cvs", "code", "hg"));
	/*
	 * url: projectDownloadURL projectFolderName: Project Name will be
	 * projectFolderName internalFolderName: Inside projectFolderName, folder
	 * name of menuType will be created as "internalFolderName". menuType: git,
	 * hg, svn, code
	 */
	static Document projectHomePage;
	static String url, projectFolderName, menuType, internalFolderName;

	/*
	 * menu_consume_git menu_consume_mercurial menu_consume_svn menu_consume_cvs
	 * menu_consume_code menu_consume_hg
	 */
	public static void main(String[] args)
	{

		try (BufferedReader br = new BufferedReader(new FileReader(
				"./DATA/projectNames/Java_Project_Names.txt")))
		{
			for (String project; (project = br.readLine()) != null;)
			{
				// System.out.println(project);
				// getWebHookURL(project);
				getReadOnlyURL("", "", "", "", false);
				break;
			}
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}

	public static void getWebHookURL(String project)
	{

		try
		{
			projectHomePage = Jsoup.connect(
					"http://sourceforge.net/projects/jibx/").get();

			Elements menuElements = projectHomePage
					.select("li[id^=menu_consume");

			for (String menuType : menuConstants)
			{
				Elements elements = menuElements.select("li[id^=menu_consume_"
						+ menuType);

				if (elements.size() != 0)
				{
					Elements ulElement = elements.select("ul");
					if (ulElement.size() > 0)
					{

						// System.out.println("it has UL");
						Elements liElements = ulElement.select("li");
						/*
						 * get href from <a> -> extract clone link extract text
						 * node from li element -> make folder->
						 * projectName/menuConstant/cloneHere
						 */
						for (Element e : liElements)
						{
							Elements anchorTag = e.getElementsByTag("a");

							/*
							 * calling getReadonlyURL for all internal urls
							 */

							getReadOnlyURL(anchorTag.attr("href"), project,
									menuType, anchorTag.text(), true);
							// it does have internal projects, so true
						}
					}
					else
					{

						/*
						 * get href -> extract clone link get span text node,
						 * make it as folder inside
						 * /projectName/menuType/clone_here
						 */
						for (Element e : elements)
						{
							Elements anchorTag = e.getElementsByTag("a");
							Elements spanTag = e.getElementsByTag("span");

							/*
							 * calling getReadonlyURL for all internal urls
							 */

							getReadOnlyURL(anchorTag.attr("href"), project,
									menuType, spanTag.text(), false);
							// it doesnot have internal projects,so sfalse

						}
					}

				}

			}

		}
		catch (Exception e)
		{
		}

	}

	public static void getReadOnlyURL(String url, String projectFolderName,
			String menuType, String internalFolderName,
			boolean hasInternalProjects)
	{
		Document projectInternalPage;
		try
		{
			projectInternalPage = Jsoup.connect("http://sourceforge.net" + url)
					.get();

			Element access_urls = projectInternalPage
					.getElementById("access_urls");
			Elements anchorTags = access_urls.getElementsByTag("a");

			for (Element e : anchorTags)
			{
				if (e.text().equalsIgnoreCase("RO"))
				{
					System.out.println(e.attr("data-url"));
				}
			}

			// System.out.println(projectInternalPage.toString());
		}
		catch (Exception e)
		{
			System.err.println(e.toString());
		}
		// System.out.println("url: " + url + " folder: " + projectFolderName
		// + " menu: " + menuType + " internalFolder: "
		// + internalFolderName);

	}
}
