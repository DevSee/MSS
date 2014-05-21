package me.MineShine.Essentials.Commands;

import me.MineShine.Utils.Console;
import me.MineShine.Utils.MSPlayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Repair_C implements CommandExecutor
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
		if(p.hasPermission("MSS.Commands.Repair"))
		{
			if(args.length >= 1)
			{
				p.sendUsage("/repair");
				return true;
			}
			
			if(args.length == 0)
			{
				for(ItemStack contents : p.getPlayer().getInventory().getContents())
				{
					try
					{
						contents.setDurability((short)0);
					} catch (Exception e){}
				}
				
				if(p.getPermissions().has("MSS.Commands.Repair.Body"))
				{
					for(ItemStack armorContents : p.getPlayer().getInventory().getArmorContents())
					{
						try
						{
							armorContents.setDurability((short)0);
						} catch (Exception e){}
					}
				}
				p.print("Deine Items wurden erfolgreich repariert!");
			}
		}
		return true;
	}
}
