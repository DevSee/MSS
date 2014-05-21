package me.MineShine;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.ChatColor;

public class Var 
{
	//All kind of Files
	public File config = new File("plugins//MSS//config.yml");
	
	// Checks if all Components work fine (SET ONLY WHEN A SEVERE HAPPENS)
	public boolean pluginWorksProperly;
	
	//Prefix
	public String prefix = ChatColor.GOLD+"[MSS] ";
	
	//Reply
	public HashMap<String, String> replies = new HashMap<String, String>();
	
	//SocialSpy
	public ArrayList<String> socialspy = new ArrayList<String>();
	
	//God
	public ArrayList<String> god = new ArrayList<String>();
	
	//Chatformat
	public String chatformat;
	
	//MySQL-Variables
	public String host;
	public String port;
	public String user;
	public String password;
	public String database;
}
