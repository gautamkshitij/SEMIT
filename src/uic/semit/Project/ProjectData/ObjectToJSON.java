package uic.semit.Project.ProjectData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import uic.semit.Project.SourceCode.DownloadFiles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ObjectToJSON
{
	public static List<DownloadFiles> projectFiles = new ArrayList<DownloadFiles>();
	static File file2 = new File(
			"./DATA/Collected/Java_Project_SouceCode_SourceForge.json");
	static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	static FileWriter fw1;
	static BufferedWriter bw1;

	public static void main(String[] args) throws Exception
	{
		fw1 = new FileWriter(file2.getAbsoluteFile());
		bw1 = new BufferedWriter(fw1);

		List<Project> projects = new ArrayList<Project>();
		Project newProject = null;

		// File file = new File(
		// "./DATA/Collected/Java_Project_Data_SourceForge.json");
		// FileWriter fw = new FileWriter(file.getAbsoluteFile());

		fw1 = new FileWriter(file2.getAbsoluteFile()); // for source code

		// BufferedWriter bw = new BufferedWriter(fw);
		//
		// bw.write("[");
		bw1.write("[");
		int i = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(
				"./DATA/projectNames/Java_Project_Part2.txt")))
		{
			for (String projectName; (projectName = br.readLine()) != null;)
			{
				System.out.println(i);
				newProject = new JsonProjectParser()
						.initiliazeProject(projectName);
				String json = gson.toJson(newProject);
				// bw.write(json);
				// bw.write(",");
				i++;
			}

		}
		// bw.write("]");
		bw1.write("]");
		// bw.close();
		bw1.close();

	}

	public static void writeToFile(DownloadFiles df)
	{
		String codejson = gson.toJson(df);
		try
		{

			bw1.write(codejson);
			bw1.write(",");
		}

		catch (Exception e)
		{
			System.err.println("IOException");
		}
	}

}
