package me.MineShine.Essentials.Commands;

import me.MineShine.Utils.Console;
import me.MineShine.Utils.MSPlayer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed_C implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args)
	{
		if(!(sender instanceof Player))
		{
			if(args.length == 0 || args.length > 1)
			{
				Console.sendUsage("/feed [Player]");
				return true;
			}
			
			if(args.length == 1)
			{
				MSPlayer target = new MSPlayer(Bukkit.getPlayer(args[0]));
				try{target.getPlayer().setFoodLevel(20);
				Console.print("Der Hunger von "+target.getPlayer().getName()+" wurde gestillt!");
				target.print("Dein Hunger wurde von "+ChatColor.YELLOW+"Console"+ChatColor.AQUA+" gestillt!");}catch(NullPointerException e){Console.print("Der Spieler "+args[0]+" ist nicht Online!"); return true;}
				return true;
			}
		}
		MSPlayer p = new MSPlayer((Player)sender);
		if(args.length == 0)
		{
			if(p.hasPermission("MSS.Commands.Feed"))
			{
				p.getPlayer().setFoodLevel(20);
				p.getPlayer().setSaturation(20);
				p.print("Dein Hunger wurde gestillt!");
			}
			return true;
		}
		
		if(args.length == 1)
		{
			MSPlayer target = new MSPlayer(Bukkit.getPlayer(args[0]));
			try{target.getPlayer().setFoodLevel(20);
			p.print("Der Hunger von "+ChatColor.YELLOW+target.getPlayer().getName()+ChatColor.AQUA+" wurde gestillt!");
			target.print("Dein Hunger wurde von "+ChatColor.YELLOW+p.getPlayer().getName()+ChatColor.AQUA+" gestillt!");}catch(NullPointerException e){p.print("Der Spieler "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" ist nicht Online!"); return true;}
			return true;
		}
		if(args.length > 1)
		{
			p.sendUsage("/feed <Player>");
		}
		return true;
	}
}