package uic.semit.Project.SourceCode.Downloading;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Downloading
{

	String folderPath = "./DATA/CODE/JAVA/";
	List<String> command = new ArrayList<>(Arrays.asList("/bin/sh", "-c"));
	boolean commandSuccess;

	public Downloading(ProjectStructure projectStructure) throws IOException
	{
		File file;

		String[] commands;
		Map<String, List<String>> folder = projectStructure
				.getFolderStructure();

		Map<String, String> codeURL = projectStructure
				.getInternFolder_with_URL();
		if (folder.size() != 0 || codeURL.size() != 0)
		{
			folderPath = folderPath + projectStructure.getProjectName() + "/";

			for (Map.Entry<String, List<String>> entry : folder.entrySet())
			{
				List<String> internalFolders = entry.getValue();
				if (internalFolders != null)
				{
					for (String insideFolder : internalFolders)
					{
						file = new File(folderPath + entry.getKey() + "/"
								+ insideFolder + "/");

						file.mkdirs();
						// "cd ./DATA/CODE/JAVA/; git/svn/ url" };

						command.add(
								2,
								"cd " + file.getPath() + "; "
										+ codeURL.get(insideFolder));

						commands = new String[command.size()];
						// System.out.println(command);
						System.err.println(executeCommand(command
								.toArray(commands)));

					}
				}
				else
				{
					file = new File(folderPath + entry.getKey() + "/");

					file.mkdirs();
					command.add(
							2,
							"cd " + file.getPath() + "; "
									+ codeURL.get(entry.getKey()));
					commands = new String[command.size()];
					// System.out.println(command);
					System.out
							.println(executeCommand(command.toArray(commands)));

					// System.err
					// .println(sucess + " - " + codeURL.get(entry.getKey()));

				}

			}
			/*
			 * String[] command = { "/bin/sh", "-c",
			 * "cd ./DATA/CODE/JAVA/; svn checkout svn://svn.code.sf.net/p/jibx/svn/trunk jibx-svn"
			 * };
			 */
		}
		else
		{
			folderPath = folderPath + "_emptyProjects/"
					+ projectStructure.getProjectName() + "/";
			file = new File(folderPath);
			file.mkdirs();
		}

	}

	private boolean executeCommand(String[] command)
	{
		Process p;
		try
		{
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			p.exitValue();
		}
		catch (Exception e)
		{
			System.out.println(e.toString() + "--" + command[2]);
			return false;
		}
		return true;
	}

}
