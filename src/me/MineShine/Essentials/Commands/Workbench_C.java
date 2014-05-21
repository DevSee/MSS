package me.MineShine.Essentials.Commands;

import me.MineShine.Utils.Console;
import me.MineShine.Utils.MSPlayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Workbench_C implements CommandExecutor
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
		if(p.hasPermission("MSS.Commands.Workbench"))
		{
			if(args.length >0)
			{
				p.sendUsage("/workbench");
				return true;
			}
			
			if(args.length == 0)
			{
				p.getPlayer().openWorkbench(null, true);
			}
		}
		return true;
	}
}
