package me.MineShine.Utils;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Setup 
{
	
	/*
	 * Runs in Main;
	 */
	
	public static void loadEvents()
	{
		//MS-Economy:
		
		//MS-Shop:
		
		//MS-Essentials:
		
		//MS-Bans:
		
		//MS-Suport:
		
		//MS-Stats
		
		//MS-Clan
		
		//MS-Friede
		
		//MS-Info
	}
	
	/*
	 * Runs in Main;
	 */
	
	public static void loadCommands()
	{
		//MS-Economy:
		
		//MS-Shop:
		
		//MS-Essentials:
		
		//MS-Bans:
		
		//MS-Suport:
		
		//MS-Stats
		
		//MS-Clan
		
		//MS-Friede
		
		//MS-Info
	}
	
	/*
	 * Runs in Main;
	 * Executes checkFile method;
	 */
	
	public static void loadConfig()
	{
		
	}
	
	/*
	 * 
	 */
	
	public static void checkFile(File file)
	{
	}
	
	/*
	 * Sends a Message to the Console
	 */
	
	public static void print(String msg)
	{
		Bukkit.getLogger().info("[MSS] "+msg);
	}
	
	/*
	 * Sends a Warning to the Console
	 */
	
	public static void warn(String msg)
	{
		Bukkit.getLogger().warning("[MSS] "+msg);
	}
	
	/*
	 * Sends a Message to a Player
	 */
	
	public static void print(Player p, String msg)
	{
		p.sendMessage(ChatColor.GOLD+"[MSS] "+ChatColor.AQUA+msg);
	}
	
	public static void printAll(String msg)
	{
		Bukkit.broadcastMessage(ChatColor.GOLD+"[MSS] "+ChatColor.AQUA+msg);
	}

}
