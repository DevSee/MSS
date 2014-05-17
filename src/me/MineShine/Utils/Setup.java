package me.MineShine.Utils;

import java.io.File;
import java.io.IOException;

public class Setup 
{
	/*
	 * Checks if a File exists, if not it creates it.
	 * RETURNS FALSE IF THE FILE HASN'T EXISTED BEFORE!
	 */
	
	public static boolean checkFile(File file, String path)
	{
		File dir = new File(path);
		if(!file.exists())
		{
			dir.mkdirs();
			Console.print("Created Folder in "+dir.getPath()+"!");
			Console.print("Trying to create File "+file.getName()+"..");
			try{file.createNewFile();}catch(IOException e){Console.print("Failed to Create "+file.getName()+"!"); Console.print("Failed to Find Folder "+file.getPath()+". Check if the Folder exists!"); return true;}
			Console.print("Succesfully created File "+file.getName()+"!");
			return false;
		}
		return true;
	}
}
