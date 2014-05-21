package me.MineShine.Essentials.Commands;

import me.MineShine.Utils.Console;
import me.MineShine.Utils.MSPlayer;
import net.minecraft.server.v1_7_R2.EntityPlayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class Ping_C implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args)
	{
		if(!(sender instanceof Player))
		{
			if(args.length == 0 || args.length >1)
			{
				Console.sendUsage("/ping [Player]");
				return true;
			}
			
			if(args.length == 1)
			{
				MSPlayer target = new MSPlayer(Bukkit.getPlayer(args[0]));
				try
				{
					Console.print("Name: "+target.getPlayer().getName());
					Console.print("IP: "+getIP(target.getPlayer()));
					Console.print("Ping: "+getPing(target.getPlayer()));
				} catch (NullPointerException e)
				{
					Console.print("Der Spieler "+args[0]+" ist nicht Online!");
					return true;
				}
				return true;
			}
		}
		
		MSPlayer p = new MSPlayer((Player)sender);
		if(p.hasPermission("MSS.Commands.Ping"))
		{
			if(args.length > 1)
			{
				p.sendUsage("/ping <Player>");
			}
			if(args.length == 0)
			{
				p.print("Name: "+ChatColor.YELLOW+p.getPlayer().getName());
				p.print("IP: "+ChatColor.YELLOW+getIP(p.getPlayer()));
				p.print("Ping: "+ChatColor.YELLOW+getPing(p.getPlayer()));
				return true;
			}
			
			if(args.length == 1)
			{
				if(p.hasPermission("MSS.Commands.Ping.Others"))
				{
					MSPlayer target = new MSPlayer(Bukkit.getPlayer(args[0]));
					try
					{
						p.print("Name: "+ChatColor.YELLOW+target.getPlayer().getName());
						p.print("IP: "+ChatColor.YELLOW+getIP(target.getPlayer()));
						p.print("Ping: "+ChatColor.YELLOW+getPing(target.getPlayer()));
					} catch (NullPointerException e)
					{
						p.print("Der Spieler "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" ist nicht Online!");
						return true;
					}
					return true;					
				}
			}
		}
		
		return true;
	}
	
	public int getPing(Player p) 
	{
		CraftPlayer cp = (CraftPlayer) p;
		EntityPlayer ep = cp.getHandle();
		return ep.ping;
	}
	
	public String getIP(Player p)
	{
		StringBuilder sbr = new StringBuilder(p.getAddress().toString().substring(0, p.getAddress().toString().indexOf(":")));
		sbr.deleteCharAt(0);
		return sbr.toString();
	}
}
