package uic.semit.Project.SourceCode.Downloading;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectStructure
{
	/*
	 * url: projectDownloadURL projectFolderName: Project Name will be
	 * projectFolderName internalFolderName: Inside projectFolderName, folder
	 * name of menuType will be created as "internalFolderName". menuType: git,
	 * hg, svn, code
	 */

	String projectName;

	Map<String, String> internFolder_with_URL = new HashMap<String, String>();
	/*
	 * Mapping of folder name with clone url
	 */
	Map<String, List<String>> folderStructure = new HashMap<String, List<String>>();

	/*
	 * mapping of menu type with internal folder name list
	 */

	@Override
	public String toString()
	{
		return "ProjectStructure [projectName=" + projectName
				+ "\n\n, internFolder_with_URL="
				+ internFolder_with_URL.toString() + "\n\n, FolderStructure="
				+ folderStructure.toString() + "]";
	}

	public String getProjectName()
	{
		return projectName;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}

	public Map<String, String> getInternFolder_with_URL()
	{
		return internFolder_with_URL;
	}

	public void setInternFolder_with_URL(
			Map<String, String> internFolder_with_URL)
	{
		this.internFolder_with_URL = internFolder_with_URL;
	}

	public Map<String, List<String>> getFolderStructure()
	{
		return folderStructure;
	}

	public void setFolderStructure(Map<String, List<String>> folderStructure)
	{
		this.folderStructure = folderStructure;
	}

	public ProjectStructure(String projectName,
			Map<String, String> internFolder_with_URL,
			Map<String, List<String>> folderStructure)
	{

		this.projectName = projectName;
		this.internFolder_with_URL = internFolder_with_URL;
		this.folderStructure = folderStructure;
	}

	public ProjectStructure()

	{
	}

}
