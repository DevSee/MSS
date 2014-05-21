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
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class God_C implements Listener, CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args)
	{
		if(!(sender instanceof Player))
		{
			Console.sendOnlyPlayer();
			return true;
		}
		
		MSPlayer p = new MSPlayer((Player)sender);
		if(p.hasPermission("MSS.Commands.God"))
		{
			if(args.length >1)
			{
				p.sendUsage("/god <Player>");
				return true;
			}
			
			if(args.length == 0)
			{
				if(!MSS.getInstance().var.god.contains(p.getPlayer().getName()))
				{
					MSS.getInstance().var.god.add(p.getPlayer().getName());
					p.print("Du bist nun bis zum nächsten Reload/Restart unverwundbar!");
				} else {
					MSS.getInstance().var.god.remove(p.getPlayer().getName());
					p.print("Du bist nun wieder verwundbar!");
					return true;
				}
			}
			
			if(args.length == 1)
			{
				MSPlayer target = new MSPlayer(Bukkit.getPlayer(args[0]));
				try
				{
					if(!MSS.getInstance().var.god.contains(p.getPlayer().getName()))
					{
						MSS.getInstance().var.god.add(target.getPlayer().getName());
						p.print("Der Spieler "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" ist nun unverwundbar!");
						target.print("Der Spieler "+ChatColor.YELLOW+p.getPlayer().getName()+ChatColor.AQUA+" hat dich unverwundbar gemacht!");
					} else {
						MSS.getInstance().var.god.remove(target.getPlayer().getName());
						p.print("Der Spieler "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" ist nun wieder verwundbar!");
						target.print("Der Spieler "+ChatColor.YELLOW+p.getPlayer().getName()+ChatColor.AQUA+" hat dich wieder verwundbar gemacht!");
					}
				} catch (NullPointerException e)
				{
					p.print("Der Spieler "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" ist nicht Online!");
				}
			}
		}
		return true;
	}
	
	@EventHandler
	public void onGod(EntityDamageEvent e)
	{
		MSPlayer p = new MSPlayer((Player)e.getEntity());
		if(!(e.getEntity() instanceof Player))
		{
			return;
		} else if(MSS.getInstance().var.god.contains(p.getPlayer().getName()))
		{
			e.setCancelled(true);
		}
		
	}
}
