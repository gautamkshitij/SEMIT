package uic.semit.Project.SourceCode.Downloading;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Downloading
{
	public static void main(String[] args)
	{

		Downloading obj = new Downloading();

		String domainName = "google.com";

		// in mac oxs
		String[] command =
		{
				"/bin/sh",
				"-c",
				"cd ./DATA/CODE/JAVA/; svn checkout svn://svn.code.sf.net/p/jibx/svn/trunk jibx-svn" };

		String output = obj.executeCommand(command);

		System.out.println(output);

	}

	private String executeCommand(String[] command)
	{

		StringBuffer output = new StringBuffer();

		Process p;
		try
		{
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					p.getInputStream()));

			String line = "";
			while ((line = reader.readLine()) != null)
			{
				output.append(line + "\n");
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return output.toString();

	}
}
