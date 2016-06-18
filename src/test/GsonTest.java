package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import resourceLoader.ResourceObject;

public class GsonTest 
{
	public static void main(String[] args) throws IOException
	{
		ResourceObject[] img = 
			{
					new ResourceObject("test", "test", "Resources", ResourceObject.MUSIC),
					new ResourceObject("foxfire", "foxfire.png", "Resources", ResourceObject.SPRITE)
			};
		
			String json = new Gson().toJson(img);
			System.out.println(json);
		
			ResourceObject[] img2;
			Gson gson = new Gson();
			img2 = gson.fromJson(json, ResourceObject[].class);
		
			for(int i = 0; i < img2.length; i++)
			{
				System.out.println(img2[i].getName() + " " + img[i].getDirectory() + " " + img2[i].getFile());
			}
			
			File file = new File("Test.txt");
			FileWriter writer = new FileWriter(file);
			
			writer.write(json);
			writer.close();
	}
}
