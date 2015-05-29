package uic.semit.Project.ProjectData;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class ObjectToJSON
{
	public static void main(String[] args)
	{
		Gson gson = new Gson();
		Project newProject = new JsonProjectParser().initiliazeProject("");
		List<Project> projects = new ArrayList<Project>();
		projects.add(newProject);

		String json = gson.toJson(projects);
		System.out.println(json);

	}
}
