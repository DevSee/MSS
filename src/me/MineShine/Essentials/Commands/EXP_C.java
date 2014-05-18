package me.MineShine.Essentials.Commands;

import me.MineShine.Utils.Console;
import me.MineShine.Utils.MSPlayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EXP_C implements CommandExecutor 
{
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args)
	{
		if(!(sender instanceof Player))
		{
			if(args.length <= 1 || args.length >2)
			{
				Console.sendUsage("/exp [Player] [XP-Anzahl]");
				return true;
			}
			MSPlayer target = new MSPlayer(Bukkit.getPlayer(args[0]));
				try
				{
					int exp = Integer.parseInt(args[1]);
					try
					{
						target.getPlayer().setExp(exp);
					} catch (NullPointerException e)
					{
						Console.print("Der Spieler "+args[0]+" ist nicht Online!");
						return true;
					}
				} catch (NumberFormatException e)
				{
					Console.sendUsage("/exp [Player]");
					return true;
				}
				Console.print("Erfolgreich "+args[1]+"-EXP punkte für den Spieler "+args[0]+" gesetzt!");
				target.print("Deine EXP-Leiste wurde von "+ChatColor.YELLOW+"Console"+ChatColor.AQUA+" auf "+ChatColor.YELLOW+args[1]+ChatColor.AQUA+" gesetzt!");
				return true;
		}
		MSPlayer p = new MSPlayer((Player)sender);
		if(p.hasPermission("MSS.Commands.EXP"))
		{
			if(args.length == 0)
			{
				p.sendUsage("/exp [XP-Anzahl]");
				p.sendUsage("/exp [Player] [XP-Anzahl]");
				return true;
			}
			
			if(args.length == 1)
			{
				try{
				int exp = Integer.parseInt(args[0]);
				p.getPlayer().setExp(exp);
				p.print("Deine EXP-Leiste wurde auf "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" gesetzt!");
				}catch(NumberFormatException e)
				{
					p.sendUsage("/exp [XP-Anzahl]");
					p.sendUsage("/exp [Player] [XP-Anzahl]");
					return true;
				}
			}
			
			if(args.length == 2)
			{
				if(p.hasPermission("MSS.Commands.EXP.Others"))
				{
					MSPlayer target = new MSPlayer(Bukkit.getPlayer(args[0]));
					try
					{
						int exp = Integer.parseInt(args[1]);
						try
						{
							target.getPlayer().setExp(exp);
						} catch (NullPointerException e)
						{
							p.print("Der Spieler "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" ist nicht Online!");
							return true;
						}
					} catch (NumberFormatException e)
					{
						Console.sendUsage("/exp [Player]");
						return true;
					}
					p.print("Erfolgreich "+ChatColor.YELLOW+args[1]+"-EXP"+ChatColor.AQUA+" punkte für den Spieler "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" gesetzt!");
					target.print("Deine EXP-Leiste wurde von "+ChatColor.YELLOW+p.getPlayer().getName()+ChatColor.AQUA+" auf "+ChatColor.YELLOW+args[1]+ChatColor.AQUA+" gesetzt!");
					return true;
				}
			}
		}
		return true;
	}
}
