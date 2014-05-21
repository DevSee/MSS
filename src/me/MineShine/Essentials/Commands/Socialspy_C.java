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

public class Socialspy_C implements CommandExecutor 
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
		if(p.hasPermission("MSS.Commands.Socialspy"))
		{
			if(!MSS.getInstance().var.socialspy.contains(p.getPlayer().getName()))
			{
				MSS.getInstance().var.socialspy.add(p.getPlayer().getName());
				p.print("Socialspy ist nun bis zum nächsten Reload/Restart aktiviert!");
			} else {
				MSS.getInstance().var.socialspy.remove(p.getPlayer().getName());
				p.print("Socialspy wurde deaktiviert!");
			}
		}
		return true;
	}
	
	public static void socialSpy(String playerName, String targetName, String message)
	{
		for(Player all : Bukkit.getOnlinePlayers())
		{
			MSPlayer p = new MSPlayer(all);
			if(p.getPermissions().has("MSS.Commands.Socialspy") && MSS.getInstance().var.socialspy.contains(p.getPlayer().getName()))
			{
				p.print(ChatColor.GOLD+"[Spy] "+ChatColor.GRAY+"["+ChatColor.YELLOW+playerName+ChatColor.GRAY+" -> "+ChatColor.YELLOW+targetName+ChatColor.GRAY+"] "+ChatColor.GREEN+ChatColor.ITALIC+message);
			}
		}
	}
}
