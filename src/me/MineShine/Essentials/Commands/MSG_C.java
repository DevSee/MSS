package me.MineShine.Essentials.Commands;

import me.MineShine.MSS;
import me.MineShine.Utils.Console;
import me.MineShine.Utils.MSPlayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MSG_C implements CommandExecutor 
{
	String message = null;
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args)
	{
		if(!(sender instanceof Player))
		{
			if(args.length <= 1)
			{
				Console.sendUsage("/msg [Spieler]");
				return true;
			}
			
			if(args.length >= 2)
			{
				makeMessage(args);
				MSPlayer target = new MSPlayer(Bukkit.getPlayer(args[0]));
				try
				{
					Console.print(ChatColor.GRAY+"["+ChatColor.YELLOW+"Console "+ChatColor.GRAY+"-> "+ChatColor.YELLOW+target.getPlayer().getName()+ChatColor.GRAY+"] "+ChatColor.AQUA+message);
					target.print(ChatColor.GRAY+"["+ChatColor.YELLOW+"Console "+ChatColor.GRAY+"-> "+ChatColor.YELLOW+target.getPlayer().getName()+ChatColor.GRAY+"] "+ChatColor.AQUA+message);
					Socialspy_C.socialSpy("Console", target.getPlayer().getName(), message);
					return true;
				} catch (NullPointerException e)
				{
					Console.print("Der Spieler "+args[0]+" ist nicht Online!");
					return true;
				}
			}
			return true;
		}
		MSPlayer p = new MSPlayer((Player)sender);
		if(p.hasPermission("MSS.Commands.MSG"))
		{
			if(args.length <= 1)
			{
				p.sendUsage("/msg [Spieler] [Nachricht]");
				return true;
			}
			
			if(args.length >= 2)
			{
				makeMessage(args);
				MSPlayer target = new MSPlayer(Bukkit.getPlayer(args[0]));
				try
				{
					p.print(ChatColor.GRAY+"["+ChatColor.YELLOW+p.getPlayer().getName()+ChatColor.GRAY+" -> "+ChatColor.YELLOW+target.getPlayer().getName()+ChatColor.GRAY+"] "+ChatColor.AQUA+message);
					target.print(ChatColor.GRAY+"["+ChatColor.YELLOW+p.getPlayer().getName()+ChatColor.GRAY+" -> "+ChatColor.YELLOW+target.getPlayer().getName()+ChatColor.GRAY+"] "+ChatColor.AQUA+message);
					Socialspy_C.socialSpy(p.getPlayer().getName(), target.getPlayer().getName(), message);
					MSS.getInstance().var.replies.put(p.getPlayer().getName(), target.getPlayer().getName());
					MSS.getInstance().var.replies.put(target.getPlayer().getName(), p.getPlayer().getName());
					return true;
				} catch (NullPointerException e)
				{
					p.print("Der Spieler "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" ist nicht Online!");
					return true;
				}
			}
		}
		return true;
	}
	
	private void makeMessage(String[] args)
	{
		final StringBuilder bldr = new StringBuilder();
		for (int i = 1; i < args.length; i++)
		{
			if (i != 1)
			{
				bldr.append(" ");
			}
			bldr.append(args[i]);
		}
		message = bldr.toString();
	}
	
}
