/**
 * 
 */
package uic.semit.kshitij;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * @author kshitijgautam
 * 
 */
public class DataCollection
{
	public static void main(String[] args)
	{
		// http://sourceforge.net/rest/p/[project_name]
		// List<String> incomplete_Project_data;
		List<String> project_names = null;
		try
		{
			project_names = FileUtils.readTextFileByLines("./input copy.txt");
		}
		catch (IOException e)
		{

		}

		for (String project : project_names)
		{
			sendGet("http://sourceforge.net/projects/" + project);
			// break;
		}

	}

	private static void sendGet(String url)
	{

		URL _url = null;

		HttpURLConnection con = null;
		try
		{
			_url = new URL(url);
			con = (HttpURLConnection) _url.openConnection();

			int responseCode = 200;
			responseCode = con.getResponseCode();

			// System.out.println("\nSending 'GET' request to URL : " + url);
			if (responseCode != 200)
			{
				System.out.println("Response Code : " + responseCode);
				System.out.println(url);
			}
			else
			{
				System.out.println(1);

			}
			BufferedReader in = null;
			in = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null)
			{
				response.append(inputLine);
			}

			in.close();
		}
		catch (Exception e)
		{
		}
		// print result
		// System.out.println(response.toString());

	}
}
