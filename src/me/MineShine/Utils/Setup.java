package me.MineShine.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Setup 
{
	
	public static void print(String msg)
	{
		Bukkit.getLogger().info("[MSS] "+msg);
	}
	
	public static void warn(String msg)
	{
		Bukkit.getLogger().warning("[MSS] "+msg);
	}
	
	public static void print(Player p, String msg)
	{
		p.sendMessage(ChatColor.GOLD+"[MSS] "+ChatColor.AQUA+msg);
	}
	
	public static void printAll(String msg)
	{
		Bukkit.broadcastMessage(ChatColor.GOLD+"[MSS] "+ChatColor.AQUA+msg);
	}

}
