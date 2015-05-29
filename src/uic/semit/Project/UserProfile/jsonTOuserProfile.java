package uic.semit.Project.UserProfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class jsonTOuserProfile
{
	public static UserProfile getUserProfile(String developerName)
	{

		Gson gson = new Gson();
		UserProfile userprofile = null;
		try
		{
			// http://sourceforge.net/rest/u/[username]/profile
			BufferedReader br = new BufferedReader(new FileReader(
					"./userprofile.json"));

			// convert the json string back to object
			userprofile = gson.fromJson(br, UserProfile.class);

			// System.out.println(userprofile);

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return userprofile;
	}
}
