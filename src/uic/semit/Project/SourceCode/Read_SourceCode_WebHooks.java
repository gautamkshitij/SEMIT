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

	static String url, projectFolderName, externalFolderName,
			internalFolderName;

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

				getWebHookURL(project);
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
		Document doc;
		try
		{
			doc = Jsoup.connect("http://sourceforge.net/projects/jibx/").get();
			// System.out.println(doc.toString());

			Elements menuElements = doc.select("li[id^=menu_consume");

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
							System.out.println(anchorTag.text());
							System.out.println(anchorTag.attr("href"));

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

							System.out.println(anchorTag.attr("href"));
							System.out.println(spanTag.text());

						}
					}

				}

			}

		}
		catch (Exception e)
		{
		}

	}

	public void extractURLfromElement(Element liElement)
	{
	}

}
