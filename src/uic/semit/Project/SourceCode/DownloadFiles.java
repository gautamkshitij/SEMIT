package uic.semit.Project.SourceCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DownloadFiles
{
	String projectName;
	Set<String> mount_points;

	public DownloadFiles(String projectName, List<String> mount_points)
	{

		this.projectName = projectName;
		this.mount_points = new HashSet<String>(mount_points);

	}

}
