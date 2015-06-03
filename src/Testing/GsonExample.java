package Testing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class GsonExample
{
	public static void main(String[] args)
	{

		Gson gson = new Gson();

		try
		{

			BufferedReader br = new BufferedReader(new FileReader(
					"./masterale.json"));

			// System.err.println(br.toSt);
			// convert the json string back to object
			DataObject obj = gson.fromJson(br, DataObject.class);

			System.out.println(obj);

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
}