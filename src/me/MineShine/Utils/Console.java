package me.MineShine.Utils;

import me.MineShine.MSS;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Console 
{
	/*
	 * Sends a Message to the Console
	 */
	
	public static void print(String msg)
	{
		Bukkit.getLogger().info(MSS.getInstance().var.prefix+msg);
	}
	
	/*
	 * Sends a Warning to the Console
	 */
	
	public static void warn(String msg)
	{
		Bukkit.getLogger().warning(MSS.getInstance().var.prefix+msg);
	}
	
	/*
	 * Sends a Message to all Players and The Console.
	 */
	
	public static void printAll(String msg)
	{
		Bukkit.broadcastMessage(MSS.getInstance().var.prefix+ChatColor.AQUA+msg);
	}
	
	public static void sendUsage(String usage)
	{
		warn("Verwendung: "+ChatColor.AQUA+usage);
	}
}
