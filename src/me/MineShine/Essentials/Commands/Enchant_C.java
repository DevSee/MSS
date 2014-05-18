package me.MineShine.Essentials.Commands;

import me.MineShine.Utils.Console;
import me.MineShine.Utils.MSPlayer;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class Enchant_C implements CommandExecutor 
{
	private MSPlayer p;
	private boolean levelToHigh = false;
	private boolean wrongItem = false;
	private boolean noNumber = false;
	private boolean isEnchantment = false;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdlabel, String[] args) 
	{
		if(!(sender instanceof Player))
		{
			Console.sendOnlyPlayer();
			return true;
		}
		p = new MSPlayer((Player)sender);
		if(p.hasPermission("MSS.Commands.Enchant"))
		{
			if(args.length <= 1)
			{
				p.sendUsage("/enchant [enchantment] [level]");
				return true;
			}
			
			//BOW
			if(args[0].equalsIgnoreCase("power"))
			{
				enchant(Enchantment.ARROW_DAMAGE, args[1], 5);
			}
			
			if(args[0].equalsIgnoreCase("infinity"))
			{
				enchant(Enchantment.ARROW_INFINITE, args[1], 1);
			}
			
			if(args[0].equalsIgnoreCase("flame"))
			{
				enchant(Enchantment.ARROW_FIRE, args[1], 1);
			}
			
			if(args[0].equalsIgnoreCase("punch"))
			{
				enchant(Enchantment.ARROW_KNOCKBACK, args[1], 2);
			}
			
			//TOOLS
			if(args[0].equalsIgnoreCase("efficiency"))
			{
				enchant(Enchantment.DIG_SPEED, args[1], 5);
			}
			
			if(args[0].equalsIgnoreCase("silktouch") || args[0].equalsIgnoreCase("silk_touch"))
			{
				enchant(Enchantment.SILK_TOUCH, args[1], 1);
			}

			if(args[0].equalsIgnoreCase("unbreaking"))
			{
				enchant(Enchantment.DURABILITY, args[1], 3);
			}

			if(args[0].equalsIgnoreCase("fortune"))
			{
				enchant(Enchantment.LOOT_BONUS_BLOCKS, args[1], 3);
			}

			//WEAPONS
			if(args[0].equalsIgnoreCase("fireaspect") || args[0].equalsIgnoreCase("fire_aspect"))
			{
				enchant(Enchantment.FIRE_ASPECT, args[1], 2);
			}
			
			if(args[0].equalsIgnoreCase("smite"))
			{
				enchant(Enchantment.DAMAGE_UNDEAD, args[1], 5);
			}
			
			if(args[0].equalsIgnoreCase("baneofarthropods") || args[0].equalsIgnoreCase("bane_of_arthropods"))
			{
				enchant(Enchantment.DAMAGE_ARTHROPODS, args[1], 5);
			}
			
			if(args[0].equalsIgnoreCase("sharpness"))
			{
				enchant(Enchantment.DAMAGE_ALL, args[1], 5);
			}
			
			if(args[0].equalsIgnoreCase("knockback"))
			{
				enchant(Enchantment.KNOCKBACK, args[1], 2);
			}
			
			if(args[0].equalsIgnoreCase("looting"))
			{
				enchant(Enchantment.LOOT_BONUS_MOBS, args[1], 3);
			}
			
			//Armor
			
			if(args[0].equalsIgnoreCase("protection"))
			{
				enchant(Enchantment.PROTECTION_ENVIRONMENTAL, args[1], 4);
			}
			
			if(args[0].equalsIgnoreCase("fireprotection") || args[0].equalsIgnoreCase("fire_protection"))
			{
				enchant(Enchantment.PROTECTION_FIRE, args[1], 4);
			}
			
			if(args[0].equalsIgnoreCase("featherfalling") || args[0].equalsIgnoreCase("feather_falling"))
			{
				enchant(Enchantment.PROTECTION_FALL, args[1], 4);
			}
			
			if(args[0].equalsIgnoreCase("blastprotection") || args[0].equalsIgnoreCase("blast_protection"))
			{
				enchant(Enchantment.PROTECTION_ENVIRONMENTAL, args[1], 4);
			}
			
			if(args[0].equalsIgnoreCase("projectileprotection") || args[0].equalsIgnoreCase("projectile_protection"))
			{
				enchant(Enchantment.PROTECTION_PROJECTILE, args[1], 4);
			}
			
			if(args[0].equalsIgnoreCase("respiration"))
			{
				enchant(Enchantment.OXYGEN, args[1], 3);
			}
			
			if(args[0].equalsIgnoreCase("aquaaffinity") || args[0].equalsIgnoreCase("aqua_affinity"))
			{
				enchant(Enchantment.PROTECTION_ENVIRONMENTAL, args[1], 1);
			}
			
			if(noNumber)
			{
				p.sendUsage("/enchant [enchantment] [level]");
				resetBooleans();
				return true;
			}
			
			if(isEnchantment == false)
			{
				p.print("Du kannst mit dem Enchantment "+ChatColor.YELLOW+args[0].toUpperCase()+ChatColor.AQUA+" nicht auf Level "+ChatColor.YELLOW+args[1]+ChatColor.AQUA+" verzaubern!");
				resetBooleans();
				return true;
			}
			
			if(wrongItem)
			{
				p.print("Dieses Item kann nicht mit "+ChatColor.YELLOW+args[0].toUpperCase()+ChatColor.AQUA+" verzaubert werden!");
				resetBooleans();
				return true;
			}
			
			if(levelToHigh)
			{
				p.print("Du kannst mit dem Enchantment "+ChatColor.YELLOW+args[0].toUpperCase()+ChatColor.AQUA+" nicht auf Level "+ChatColor.YELLOW+args[1]+ChatColor.AQUA+" verzaubern!");
				resetBooleans();
				return true;
			}
			resetBooleans();
			p.print("Das Item in deiner Hand wurde erfolgreich mit "+ChatColor.YELLOW+args[0].toUpperCase()+ChatColor.AQUA+" verzaubert!");
		}
		return true;
	}
	
	private void enchant(Enchantment ench, String level, int maxLevel)
	{
		try
		{
			if(Integer.parseInt(level) > maxLevel)
			{
				levelToHigh = true;
				return;
			}	
		} catch(NumberFormatException e)
		{
			noNumber = true;
			return;
		}
		
		try
		{
			try
			{
				p.getPlayer().getItemInHand().addEnchantment(ench, Integer.parseInt(level));
			} catch (NullPointerException e)
			{
				wrongItem = true;
			}
		} catch(IllegalArgumentException e)
		{
			wrongItem = true;
		}
		isEnchantment = true;
	}
	
	private void resetBooleans()
	{
		levelToHigh = false;
		wrongItem = false;
		noNumber = false;
		isEnchantment = false;
	}
}
