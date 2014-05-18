package me.MineShine.Essentials.Commands;

import me.MineShine.Utils.Console;
import me.MineShine.Utils.MSPlayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly_C implements CommandExecutor 
{
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args)
	{
		if(!(sender instanceof Player))
		{
			if(args.length == 0 || args.length > 1)
			{
				Console.sendUsage("/fly [Player]");
				return true;
			}
			MSPlayer target = new MSPlayer(Bukkit.getPlayer(args[0]));
			if(!target.getPlayer().getAllowFlight())
			{
				try
				{
					target.getPlayer().setAllowFlight(true);
					Console.print("Der Spieler "+args[0]+" kann nun Fliegen!");
					target.print("Du kannst nun dank "+ChatColor.YELLOW+"Console"+ChatColor.AQUA+" Fliegen!");
				} catch (NullPointerException e)
				{
					Console.print("Der Spieler "+args[0]+" ist nicht Online!");
				}
			} else {
				try
				{
					target.getPlayer().setAllowFlight(false);
					Console.print("Der Spieler "+args[0]+" kann nun nicht mehr Fliegen!");
					target.print("Du kannst nun wegen "+ChatColor.YELLOW+"Console"+ChatColor.AQUA+" nicht mehr Fliegen!");
				} catch (NullPointerException e)
				{
					Console.print("Der Spieler "+args[0]+" ist nicht Online!");
				}
			}
		} else {
			MSPlayer p = new MSPlayer((Player)sender);
			if(p.hasPermission("MSS.Commands.Fly"))
			{
				if(args.length > 1)
				{
					p.sendUsage("/fly <Player>");
					return true;
				}
				
				if(args.length == 0)
				{
					if(!p.getPlayer().getAllowFlight())
					{
						p.getPlayer().setAllowFlight(true);
						p.print("Du kannst nun Fliegen!");
					} else {
						p.getPlayer().setAllowFlight(false);
						p.print("Du kannst nun nicht mehr Fliegen!");
						return true;
					}
				}
				if(args.length == 1)
				{
				MSPlayer target = new MSPlayer(Bukkit.getPlayer(args[0]));
				if(!p.getPlayer().getAllowFlight())
				{
					try
					{
						target.getPlayer().setAllowFlight(true);
						p.print("Der Spieler "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" kann nun Fliegen!");
						target.print("Du kannst nun dank "+ChatColor.YELLOW+p.getPlayer().getName()+ChatColor.AQUA+" Fliegen!");
					} catch (NullPointerException e)
					{
						p.print("Der Spieler "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" ist nicht Online!");
					}
				} else {
					try
					{
						target.getPlayer().setAllowFlight(false);
						p.print("Der Spieler "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" kann nun nicht mehr Fliegen!");
						target.print("Du kannst nun wegen "+ChatColor.YELLOW+p.getPlayer().getName()+ChatColor.AQUA+" nicht mehr Fliegen!");
					} catch (NullPointerException e)
					{
						p.print("Der Spieler "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" ist nicht Online!");
					}
				}
				}
			}
		}
		return true;
	}
	
}