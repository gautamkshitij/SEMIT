package uic.semit.Project.SourceCode;

import java.util.List;

public class DownloadFiles
{
	String projectName;
	List<String> mount_points;

	public DownloadFiles(String projectName, List<String> mount_points)
	{

		this.projectName = projectName;
		this.mount_points = mount_points;
	}

}
