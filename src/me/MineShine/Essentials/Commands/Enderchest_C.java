package me.MineShine.Essentials.Commands;

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
import org.bukkit.event.inventory.InventoryClickEvent;

public class Enderchest_C implements Listener, CommandExecutor
{
	String targetName;
	
	//TODO: Fix Bugs
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args)
	{	
		if(!(sender instanceof Player))
		{
			Console.sendOnlyPlayer();
			return true;
		}
		
		MSPlayer p = new MSPlayer((Player)sender);
		if(p.hasPermission("MSS.Commands.Enderchest"))
		{
			if(args.length > 1)
			{
				p.sendUsage("/enderchest <Player>");
				return true;
			}
			
			if(args.length == 0)
			{
				p.getPlayer().openInventory(p.getPlayer().getEnderChest());
				return true;
			}
			
			if(args.length == 1)
			{
				if(p.hasPermission("MSS.Commands.Enderchest.Others"))
				{
					MSPlayer target = new MSPlayer(Bukkit.getPlayer(args[0]));
					try
					{
						targetName = target.getPlayer().getName();
						p.getPlayer().openInventory(target.getPlayer().getEnderChest());
					} catch (NullPointerException e)
					{
						p.print("Der Spieler "+ChatColor.YELLOW+args[0]+ChatColor.AQUA+" ist nicht Online!");
						return true;
					}
				}
			}
		}
		return true;
	}
	
	@EventHandler
	public void onModify(InventoryClickEvent e)
	{
		if(e.getClickedInventory().getName() == targetName)
		{
			e.getWhoClicked().closeInventory();
		}
	}
}
