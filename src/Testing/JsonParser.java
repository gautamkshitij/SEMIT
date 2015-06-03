package Testing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser
{
	public static void main(String[] args)
	{

		JSONParser parser = new JSONParser();

		try
		{

			Object obj = parser.parse(new FileReader("./untitled.json"));

			JSONObject project = (JSONObject) obj;

			String id = (String) project.get("_id");
			String createDate = (String) project.get("creation_date");
			String externalHomepage = (String) project.get("external_homepage");
			String iconUrl = (String) project.get("icon_url");
			String movedURL = (String) project.get("moved_to_url");
			String name = (String) project.get("name");
			String preferredSupportTool = (String) project
					.get("preferred_support_tool");
			String preferredSupportURL = (String) project
					.get("preferred_support_url");
			String shortDescription = (String) project.get("short_description");
			String shortname = (String) project.get("shortname");
			String status = (String) project.get("status");
			String summary = (String) project.get("summary");
			String url = (String) project.get("url");
			String videoURL = (String) project.get("video_url");
			// System.out.println(id + "-" + createDate + "-" + externalHomepage
			// + "-" + iconUrl + "-" + movedURL + "-" + name + "-"
			// + preferredSupportTool + "-" + preferredSupportURL + "-"
			// + shortDescription + "-" + shortname + "-" + status + "-"
			// + summary + "-" + url + "-" + videoURL);

			Boolean _private = (Boolean) project.get("private");
			JSONArray developers = (JSONArray) project.get("developers");
			JSONArray screenshots = (JSONArray) project.get("screenshots");
			JSONArray socialnetworks = (JSONArray) project
					.get("socialnetworks");
			JSONArray tools = (JSONArray) project.get("tools");

			JSONObject categories = (JSONObject) project.get("categories");
			JSONArray audience = (JSONArray) categories.get("audience");
			JSONArray database = (JSONArray) categories.get("database");
			JSONArray developmentstatus = (JSONArray) categories
					.get("developmentstatus");
			JSONArray environment = (JSONArray) categories.get("environment");
			JSONArray language = (JSONArray) categories.get("language");
			JSONArray license = (JSONArray) categories.get("license");
			JSONArray os = (JSONArray) categories.get("os");
			JSONArray topic = (JSONArray) categories.get("topic");
			JSONArray translation = (JSONArray) categories.get("translation");
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}

	}
}
