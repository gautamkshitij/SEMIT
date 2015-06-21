package Testing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunTimeCommandExample
{
	public static void main(String[] args)
	{

		RunTimeCommandExample obj = new RunTimeCommandExample();

		String domainName = "google.com";

		String command = "git clone git://git.code.sf.net/p/mingw/mpmkr mingw-mpmkr";

		String output = obj.executeCommand(command);

		System.out.println(output);

	}

	private String executeCommand(String command)
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
