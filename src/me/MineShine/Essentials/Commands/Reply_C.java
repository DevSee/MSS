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

public class Reply_C implements CommandExecutor 
{
	String message = null;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args)
	{
		if(!(sender instanceof Player))
		{
			Console.sendOnlyPlayer();
			return true;
		}
		
		MSPlayer p = new MSPlayer((Player)sender);
		if(p.hasPermission("MSS.Commands.Reply"))
		{
			if(args.length == 0)
			{
				p.sendUsage("/reply [Nachricht]");
				return true;
			}
			
			if(args.length >= 1)
			{
				if(MSS.getInstance().var.replies.containsKey(p.getPlayer().getName()))
				{
					MSPlayer target = new MSPlayer(Bukkit.getPlayer(MSS.getInstance().var.replies.get(p.getPlayer().getName())));
					try
					{
						makeMessage(args);
						p.print(ChatColor.GRAY+"["+ChatColor.YELLOW+p.getPlayer().getName()+ChatColor.GRAY+" -> "+ChatColor.YELLOW+target.getPlayer().getName()+ChatColor.GRAY+"] "+ChatColor.AQUA+message);
						target.print(ChatColor.GRAY+"["+ChatColor.YELLOW+p.getPlayer().getName()+ChatColor.GRAY+" -> "+ChatColor.YELLOW+target.getPlayer().getName()+ChatColor.GRAY+"] "+ChatColor.AQUA+message);
						Socialspy_C.socialSpy(p.getPlayer().getName(), target.getPlayer().getName(), message);
						return true;
					} catch (NullPointerException e)
					{
						p.print("Der Spieler "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" ist nicht Online!");
						return true;
					}
				}
				p.print("Du hast noch keine Nachrichten bekommen!");
				return true;
			}
		}
			
		return true;
	}
	
	private void makeMessage(String[] args)
	{
		final StringBuilder bldr = new StringBuilder();
		for (int i = 0; i < args.length; i++)
		{
			if (i != 0)
			{
				bldr.append(" ");
			}
			bldr.append(args[i]);
		}
		message = bldr.toString();
	}
}
