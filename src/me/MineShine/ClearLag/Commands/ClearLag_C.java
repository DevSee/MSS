package me.MineShine.ClearLag.Commands;

import java.util.Iterator;
import java.util.List;

import me.MineShine.Utils.MSPlayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;

public class ClearLag_C implements CommandExecutor 
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args)
	{
		MSPlayer p = new MSPlayer((Player)sender);
		if(args.length == 0)
		{
			p.sendUsage("/ClearLag <World : Here>");
			return true;
		}
		
		if(args.length == 1)
		{
			if(args[0].equalsIgnoreCase("Here"))
			{
				List<Entity> list = p.getPlayer().getWorld().getEntities();
				Iterator<Entity> entities = list.iterator();
				while (entities.hasNext()) 
				{
				    Entity entity = entities.next();
				    if (entity instanceof Player|| entity instanceof ItemFrame) 
				    {
				    	return true;
				    }
				}
				p.print("Alle Entities wurden gelöscht! ("+p.getPlayer().getWorld().getEntities().size()+")");
			}
		}
		return true;
	}
}
