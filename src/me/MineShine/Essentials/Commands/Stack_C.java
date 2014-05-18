package me.MineShine.Essentials.Commands;

import me.MineShine.Utils.Console;
import me.MineShine.Utils.MSPlayer;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Stack_C implements CommandExecutor
{
	  @SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args)
	  {
	    MSPlayer p = new MSPlayer((Player)sender);
	    if(!(sender instanceof Player))
	    {
	    	Console.sendOnlyPlayer();
	    	return true;
	    }
	    if(p.hasPermission("MSS.Commands.Stack"))
	    {
	    if(args.length > 0)
	    {
	    	p.sendUsage("/stack");
	    	return true;
	    }
	      boolean ignoreMax = true;
	      ItemStack[] items = p.getPlayer().getInventory().getContents();
	      int len = items.length;
	      
	      int affected = 0;
	      for (int i = 0; i < len; i++)
	      {
	        ItemStack item = items[i];
	        if ((item != null) && (item.getAmount() > 0) && (
	          (ignoreMax) || (item.getMaxStackSize() != 1)))
	        {
	          int max = ignoreMax ? 64 : item.getMaxStackSize();
	          if (item.getAmount() < max)
	          {
	            int needed = max - item.getAmount();
	            for (int j = i + 1; j < len; j++)
	            {
	              ItemStack item2 = items[j];
	              if ((item2 != null) && (item2.getAmount() > 0) && (
	                (ignoreMax) || (item.getMaxStackSize() != 1))) {
	                if ((item2.getTypeId() == item.getTypeId()) && 
	                  (item.getDurability() == item2.getDurability()) && (
	                  ((item.getItemMeta() == null) && (item2.getItemMeta() == null)) || (
	                  (item.getItemMeta() != null) && 
	                  (item.getItemMeta().equals(item2.getItemMeta())))))
	                {
	                  if (item2.getAmount() > needed)
	                  {
	                    item.setAmount(max);
	                    item2.setAmount(item2.getAmount() - needed);
	                    break;
	                  }
	                  items[j] = null;
	                  item.setAmount(item.getAmount() + item2.getAmount());
	                  needed = max - item.getAmount();
	                  
	                  affected++;
	                }
	              }
	            }
	          }
	        }
	      }
	      if (affected > 0) {
	        p.getPlayer().getInventory().setContents(items);
	      }
	      p.print("Items wurden in Stacks umgewandelt!");
	    }
		return true;
	 }
}
