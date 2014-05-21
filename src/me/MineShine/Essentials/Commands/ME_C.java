package me.MineShine.Essentials.Commands;

import me.MineShine.Utils.Console;
import me.MineShine.Utils.MSPlayer;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ME_C implements CommandExecutor
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
		if(p.hasPermission("MSS.Commands.Me"))
		{
			if(args.length == 0)
			{
				p.sendUsage("/me [Message]");
				return true;
			}
			
			if(args.length > 0)
			{
				Console.printAll(ChatColor.GOLD+" *"+ChatColor.YELLOW+p.getPlayer().getName()+"* "+ChatColor.AQUA+makeMessage(args));
			}
		}
		
		return true;
	}
	
	private String makeMessage(String[] args)
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
		return bldr.toString();
	}
}
