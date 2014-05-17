package me.MineShine;

import java.io.File;

import org.bukkit.ChatColor;

public class Var 
{
	//All kind of Files
	public File config = new File("plugins//MSS//config.yml");
	
	// Checks if all Components work fine (SET ONLY WHEN A SEVERE HAPPENS)
	public boolean pluginWorksProperly;
	
	//Prefix
	public String prefix = ChatColor.GOLD+"[MSS] ";
	
	//MySQL-Variables
	public String host;
	public String port;
	public String user;
	public String password;
	public String database;
}
