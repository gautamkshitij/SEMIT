package uic.semit.Project.ProjectData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import uic.semit.Project.SourceCode.CodeFile;
import uic.semit.Project.SourceCode.DownloadFiles;
import uic.semit.Project.UserProfile.jsonTOuserProfile;

public class JsonProjectParser
{

	public Project initiliazeProject(String ProjectName) throws Exception

	{
		Project p = new Project(ProjectName);
		JSONParser projectParser = new JSONParser();

		try
		{
			String json_string = ReadJSONfromURL
					.getJson("http://sourceforge.net/rest/p/" + ProjectName);
			if (json_string.length() != 0)
			{

				JSONObject project = (JSONObject) projectParser
						.parse(json_string);

				String id = (String) project.get("_id");
				p.setId(id);

				String createDate = (String) project.get("creation_date");
				p.setCreationDate(createDate);

				String externalHomepage = (String) project
						.get("external_homepage");
				p.setExternalHomepage(externalHomepage);

				String iconUrl = (String) project.get("icon_url");
				p.setIconUrl(iconUrl);

				String movedURL = (String) project.get("moved_to_url");
				p.withMovedToUrl(movedURL);

				String name = (String) project.get("name");
				p.setName(name);

				String preferredSupportTool = (String) project
						.get("preferred_support_tool");
				p.setPreferredSupportTool(preferredSupportTool);

				String preferredSupportURL = (String) project
						.get("preferred_support_url");
				p.setPreferredSupportUrl(preferredSupportURL);

				String shortDescription = (String) project
						.get("short_description");
				p.setShortDescription(shortDescription);

				String shortname = (String) project.get("shortname");
				p.setShortname(shortname);

				String status = (String) project.get("status");
				p.setStatus(status);

				String summary = (String) project.get("summary");
				p.setSummary(summary);

				String url = (String) project.get("url");
				p.setUrl(url);

				String videoURL = (String) project.get("video_url");
				p.setVideoUrl(videoURL);

				Boolean _private = (Boolean) project.get("private");
				p.setPrivate(_private);

				List<CodeFile> codes = new ArrayList<>();
				codes.add(new CodeFile("Testing", ".java"));
				codes.add(new CodeFile("make", ".java"));
				p.setCodeFiles(codes);

				JSONArray labels = (JSONArray) project.get("labels");
				List<String> labelList = new ArrayList<String>();
				for (int i = 0; i < labels.size(); i++)
				{
					labelList.add((String) labels.get(i));
				}
				p.setLabels(labelList);

				Iterator i = null;

				JSONArray developers = (JSONArray) project.get("developers");
				List<Developer> developerList = new ArrayList<Developer>();
				if (developers.size() != 0)
				{

					i = developers.iterator();
					while (i.hasNext())
					{

						JSONObject devInnerObj = (JSONObject) i.next();

						developerList.add(new Developer((String) devInnerObj
								.get("name"), (String) devInnerObj.get("url"),
								(String) devInnerObj.get("username"),
								jsonTOuserProfile
										.getUserProfile((String) devInnerObj
												.get("username"))));
					}

					p.setDevelopers(developerList);
				}
				else
				{
					developerList.add(new Developer(null, null, null, null));
				}

				JSONArray screenshots = (JSONArray) project.get("screenshots");
				List<Screenshot> screenshotList = new ArrayList<Screenshot>();

				if (screenshots.size() != 0)
				{

					i = screenshots.iterator();
					while (i.hasNext())
					{

						JSONObject screenInnerObj = (JSONObject) i.next();

						screenshotList.add(new Screenshot(
								(String) screenInnerObj.get("caption"),
								(String) screenInnerObj.get("thumbnail_url"),
								(String) screenInnerObj.get("url")));
					}

					p.setScreenshots(screenshotList);
				}
				else
				{
					screenshotList.add(new Screenshot(null, null, null));
				}

				JSONArray socialnetworks = (JSONArray) project
						.get("socialnetworks");

				List<Socialnetwork> socialnetworkList = new ArrayList<Socialnetwork>();

				if (socialnetworks.size() != 0)
				{

					i = socialnetworks.iterator();
					while (i.hasNext())
					{

						JSONObject socialInnerObj = (JSONObject) i.next();

						socialnetworkList.add(new Socialnetwork(
								(String) socialInnerObj.get("accounturl"),
								(String) socialInnerObj.get("socialnetwork")));
					}

					p.setSocialnetworks(socialnetworkList);
				}
				else
				{
					socialnetworkList.add(new Socialnetwork(null, null));
				}

				JSONArray tools = (JSONArray) project.get("tools");

				List<Tool> toolList = new ArrayList<Tool>();
				JSONObject mount_point_parser = null;
				List<String> mountList = new ArrayList<String>();
				if (tools.size() != 0)
				{

					i = tools.iterator();
					while (i.hasNext())
					{

						JSONObject toolsInnerObj = (JSONObject) i.next();
						String mountpointtemp = (String) toolsInnerObj
								.get("mount_point");
						if (mountpointtemp.equalsIgnoreCase("git")
								|| mountpointtemp.equalsIgnoreCase("svn")
								|| mountpointtemp.equalsIgnoreCase("hg")
								|| mountpointtemp.equalsIgnoreCase("mercurial")
								|| mountpointtemp.equalsIgnoreCase("files"))
						{
							mountList.add(mountpointtemp);
						}
						String json_string_mount = ReadJSONfromURL
								.getJson("http://sourceforge.net/rest/p/"
										+ ProjectName + "/" + mountpointtemp);
						if (json_string_mount.length() != 0)
						{
							mount_point_parser = (JSONObject) projectParser
									.parse(json_string_mount);
						}

						if (!toolsInnerObj.containsKey("sourceforge_group_id"))
						{
							toolList.add(new Tool((String) toolsInnerObj
									.get("label"), mountpointtemp,
									(String) toolsInnerObj.get("name"), -1,
									mount_point_parser));
						}
						else
						{
							toolList.add(new Tool((String) toolsInnerObj
									.get("label"), mountpointtemp,
									(String) toolsInnerObj.get("name"),
									(long) toolsInnerObj
											.get("sourceforge_group_id"),
									mount_point_parser));

						}
					}

					p.setTools(toolList);
					ObjectToJSON.writeToFile(new DownloadFiles(ProjectName,
							mountList));
					// ObjectToJSON.projectFiles.add(new DownloadFiles(
					// ProjectName, mountList));
				}
				else
				{
					toolList.add(new Tool(null, null, null, -1, null));
				}

				JSONObject categories = (JSONObject) project.get("categories");

				JSONArray audience = (JSONArray) categories.get("audience");
				JSONArray database = (JSONArray) categories.get("database");
				JSONArray developmentstatus = (JSONArray) categories
						.get("developmentstatus");
				JSONArray environment = (JSONArray) categories
						.get("environment");
				JSONArray language = (JSONArray) categories.get("language");
				JSONArray license = (JSONArray) categories.get("license");
				JSONArray os = (JSONArray) categories.get("os");
				JSONArray topic = (JSONArray) categories.get("topic");
				JSONArray translation = (JSONArray) categories
						.get("translation");

				ArrayList<String> categoriesList = new ArrayList<>(
						Arrays.asList("audience", "database",
								"developmentstatus", "environment", "language",
								"license", "os", "topic", "translation"));

				List<Audience> audiencelist = new ArrayList<Audience>();
				List<Database> databaselist = new ArrayList<Database>();
				List<Developmentstatu> developmentStatuslist = new ArrayList<Developmentstatu>();
				List<Environment> environmentlist = new ArrayList<Environment>();
				List<Language> languagelist = new ArrayList<Language>();
				List<License> licenselist = new ArrayList<License>();
				List<Os> oslist = new ArrayList<Os>();
				List<Topic> topiclist = new ArrayList<Topic>();
				List<Translation> translationlist = new ArrayList<Translation>();
				JSONObject categoryInnerObject;

				if (translation.size() != 0)
				{
					categoryInnerObject = new JSONObject();
					i = translation.iterator();
					while (i.hasNext())
					{
						categoryInnerObject = (JSONObject) i.next();
						translationlist.add(new Translation(
								(String) categoryInnerObject.get("fullname"),
								(String) categoryInnerObject.get("fullpath"),
								(long) categoryInnerObject.get("id"),
								(String) categoryInnerObject.get("shortname")));
					}
				}
				else
				{
					translationlist.add(new Translation(null, null, -1, null));
				}

				if (topic.size() != 0)
				{
					categoryInnerObject = new JSONObject();
					i = topic.iterator();
					while (i.hasNext())
					{
						categoryInnerObject = (JSONObject) i.next();
						topiclist.add(new Topic((String) categoryInnerObject
								.get("fullname"), (String) categoryInnerObject
								.get("fullpath"), (long) categoryInnerObject
								.get("id"), (String) categoryInnerObject
								.get("shortname")));
					}
				}
				else
				{
					topiclist.add(new Topic(null, null, -1, null));
				}

				if (os.size() != 0)
				{
					categoryInnerObject = new JSONObject();
					i = os.iterator();
					while (i.hasNext())
					{
						categoryInnerObject = (JSONObject) i.next();
						oslist.add(new Os((String) categoryInnerObject
								.get("fullname"), (String) categoryInnerObject
								.get("fullpath"), (long) categoryInnerObject
								.get("id"), (String) categoryInnerObject
								.get("shortname")));
					}
				}
				else
				{
					oslist.add(new Os(null, null, -1, null));
				}

				if (license.size() != 0)
				{
					categoryInnerObject = new JSONObject();
					i = license.iterator();
					while (i.hasNext())
					{
						categoryInnerObject = (JSONObject) i.next();
						licenselist.add(new License(
								(String) categoryInnerObject.get("fullname"),
								(String) categoryInnerObject.get("fullpath"),
								(long) categoryInnerObject.get("id"),
								(String) categoryInnerObject.get("shortname")));
					}
				}
				else
				{
					licenselist.add(new License(null, null, -1, null));
				}

				if (environment.size() != 0)
				{
					categoryInnerObject = new JSONObject();
					i = environment.iterator();
					while (i.hasNext())
					{
						categoryInnerObject = (JSONObject) i.next();
						environmentlist.add(new Environment(
								(String) categoryInnerObject.get("fullname"),
								(String) categoryInnerObject.get("fullpath"),
								(long) categoryInnerObject.get("id"),
								(String) categoryInnerObject.get("shortname")));
					}
				}
				else
				{
					environmentlist.add(new Environment(null, null, -1, null));
				}

				if (language.size() != 0)
				{
					categoryInnerObject = new JSONObject();
					i = language.iterator();
					while (i.hasNext())
					{
						categoryInnerObject = (JSONObject) i.next();
						languagelist.add(new Language(
								(String) categoryInnerObject.get("fullname"),
								(String) categoryInnerObject.get("fullpath"),
								(long) categoryInnerObject.get("id"),
								(String) categoryInnerObject.get("shortname")));
					}
				}
				else
				{
					languagelist.add(new Language(null, null, -1, null));
				}

				if (developmentstatus.size() != 0)
				{
					categoryInnerObject = new JSONObject();
					i = developmentstatus.iterator();
					while (i.hasNext())
					{
						categoryInnerObject = (JSONObject) i.next();
						developmentStatuslist.add(new Developmentstatu(
								(String) categoryInnerObject.get("fullname"),
								(String) categoryInnerObject.get("fullpath"),
								(long) categoryInnerObject.get("id"),
								(String) categoryInnerObject.get("shortname")));
					}
				}
				else
				{
					developmentStatuslist.add(new Developmentstatu(null, null,
							-1, null));
				}

				if (database.size() != 0)
				{
					categoryInnerObject = new JSONObject();
					i = database.iterator();
					while (i.hasNext())
					{
						categoryInnerObject = (JSONObject) i.next();
						databaselist.add(new Database(
								(String) categoryInnerObject.get("fullname"),
								(String) categoryInnerObject.get("fullpath"),
								(long) categoryInnerObject.get("id"),
								(String) categoryInnerObject.get("shortname")));
					}
				}
				else
				{
					databaselist.add(new Database(null, null, -1, null));
				}

				if (audience.size() != 0)
				{
					categoryInnerObject = new JSONObject();
					i = audience.iterator();
					while (i.hasNext())
					{
						categoryInnerObject = (JSONObject) i.next();
						audiencelist.add(new Audience(
								(String) categoryInnerObject.get("fullname"),
								(String) categoryInnerObject.get("fullpath"),
								(long) categoryInnerObject.get("id"),
								(String) categoryInnerObject.get("shortname")));
					}
				}
				else
				{
					audiencelist.add(new Audience(null, null, -1, null));
				}

				Categories category = new Categories(audiencelist,
						databaselist, developmentStatuslist, environmentlist,
						languagelist, licenselist, oslist, topiclist,
						translationlist);
				p = p.withCategories(category);
			}
			else
			{
				System.err.println("length = 0  " + ProjectName);
			}
		}

		catch (Exception e)
		{
			System.err.println("Exception " + ProjectName);
		}

		return p;
	}
}