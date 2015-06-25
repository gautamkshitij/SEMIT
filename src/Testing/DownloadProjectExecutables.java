package Testing;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DownloadProjectExecutables
{

	public static void downloadProject(String projectName,
			String projectFileName)
	{
		try
		{
			String downloadURL = "http://downloads.sourceforge.net/sourceforge/"
					+ projectName + "/" + projectFileName;

			String url = "http://downloads.sourceforge.net/sourceforge/"
					+ "discrialign" + "/" + "DiscriAlign.zip";
			ProcessBuilder pb = new ProcessBuilder("curl",
					"http://svn.code.sf.net/p/jibx/svn/trunk jibx-svn");

			File projectDirectory = new File("./DATA/CODE/JAVA/" + projectName);

			projectDirectory.mkdir();

			System.err.println(projectDirectory.getAbsolutePath());

			pb.directory(projectDirectory);
			pb.redirectErrorStream(true);

			Process p = pb.start();

			// better way to download files
			try (InputStream stream = p.getInputStream())
			{
				Files.copy(
						stream,
						Paths.get("./DATA/CODE/JAVA/" + projectName + "/"
								+ projectFileName));
			}

		}
		catch (Exception e)
		{
			System.err.println(projectName + "-" + e);
		}
	}

	public static void main(String[] args) throws IOException
	{
		DownloadProjectExecutables.downloadProject("discrialign",
				"DiscriAlign.zip");

	}
}
