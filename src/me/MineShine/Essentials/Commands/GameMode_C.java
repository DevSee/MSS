package me.MineShine.Essentials.Commands;

import me.MineShine.Utils.Console;
import me.MineShine.Utils.MSPlayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameMode_C implements CommandExecutor
{
	private boolean wrongGamemode;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args)
	{
		if(!(sender instanceof Player))
		{
			if(args.length <= 1 || args.length > 2)
			{
				Console.sendUsage("/Gamemode [Player] [GameMode]");
			}
			
			if(args.length == 2)
			{
				MSPlayer target = new MSPlayer(Bukkit.getPlayer(args[0]));
				try
				{
					if(getMode(args, 1) == target.getPlayer().getGameMode())
					{
						Console.print("Der Spieler "+args[0]+" hat bereits den Gamemode "+getMode(args, 1)+"!");
						return true;
					}
					
					if(wrongGamemode)
					{
						Console.print("Den Gamemode "+args[1].toUpperCase()+" gibt es nicht!");
						return true;
					}
					target.getPlayer().setGameMode(getMode(args, 1));
					Console.print("Der Gamemode von "+args[0]+" wurde auf "+getMode(args, 1)+" geändert!");
					target.print("Dein Gamemode wurde von "+ChatColor.YELLOW+"Console"+ChatColor.AQUA+" auf "+ChatColor.YELLOW+getMode(args, 1)+ChatColor.AQUA+" gesetzt!");
				} catch (NullPointerException e)
				{
					Console.print("Der Spieler "+args[0]+" ist nicht Online!");
					return true;
				}
				return true;
			}
			return true;
		}
		
		MSPlayer p = new MSPlayer((Player)sender);
		
		if(p.hasPermission("MSS.Commands.Gamemode"))
		{
			if(args.length == 0)
			{
				p.sendUsage("/Gamemode <Player> [GameMode]");
				return true;
			}
			
			if(args.length == 1)
			{
				if(getMode(args, 0) == p.getPlayer().getGameMode())
				{
					p.print("Du hast bereits den Gamemode "+ChatColor.YELLOW+getMode(args, 0)+ChatColor.AQUA+"!");
					return true;
				}
				
				if(wrongGamemode)
				{
					p.print("Den Gamemode "+ChatColor.YELLOW+args[0].toUpperCase()+ChatColor.YELLOW+" gibt es nicht!");
					return true;
				}
				p.getPlayer().setGameMode(getMode(args, 0));
				p.print("Dein Gamemode wurde auf "+ChatColor.YELLOW+getMode(args, 0)+ChatColor.AQUA+" gesetzt!");
				return true;
			}
			
			if(args.length == 2)
			{
				if(p.hasPermission("MSS.Commands.Gamemode.Others"))
				{
					MSPlayer target = new MSPlayer(Bukkit.getPlayer(args[0]));
					try
					{
						if(getMode(args, 1) == target.getPlayer().getGameMode())
						{
							p.print("Der Spieler "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" hat bereits den Gamemode "+ChatColor.YELLOW+getMode(args, 1)+ChatColor.AQUA+"!");
							return true;
						}
						
						if(wrongGamemode)
						{
							p.print("Den Gamemode "+ChatColor.YELLOW+args[1].toUpperCase()+ChatColor.AQUA+" gibt es nicht!");
							return true;
						}
						target.getPlayer().setGameMode(getMode(args, 1));
						p.print("Der Gamemode von "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" wurde auf "+ChatColor.YELLOW+getMode(args, 1)+ChatColor.AQUA+" geändert!");
						target.print("Dein Gamemode wurde von "+ChatColor.YELLOW+p.getPlayer().getName()+ChatColor.AQUA+" auf "+ChatColor.YELLOW+getMode(args, 1)+ChatColor.AQUA+" gesetzt!");
					} catch (NullPointerException e)
					{
						Console.print("Der Spieler "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" ist nicht Online!");
						return true;
					}
					return true;
				}
			}
			return true;
		}
		return true;
	}
	
	private GameMode getMode(String[] args, int i)
	{
		if(args[i].equalsIgnoreCase("0") || args[i].equalsIgnoreCase("survival"))
		{
			wrongGamemode = false;
			return GameMode.SURVIVAL;
		}
		
		if(args[i].equalsIgnoreCase("1") || args[i].equalsIgnoreCase("creative"))
		{
			wrongGamemode = false;
			return GameMode.CREATIVE;
		}
		
		if(args[i].equalsIgnoreCase("2") || args[i].equalsIgnoreCase("adventure"))
		{
			wrongGamemode = false;
			return GameMode.ADVENTURE;
		}
		wrongGamemode = true;
		return null;
	}
	
}