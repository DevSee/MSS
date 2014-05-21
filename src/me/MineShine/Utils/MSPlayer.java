package me.MineShine.Utils;

import me.MineShine.MSS;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class MSPlayer
{
	Player p;
	public MSPlayer(Player player)
	{
		this.p = player;
	}
	
	public Player getPlayer()
	{
		return this.p;
	}
	
	public PermissionUser getPermissions()
	{
		PermissionUser user = PermissionsEx.getUser(p);
		return user;
	}
	
	public void print(String msg)
	{
		p.sendMessage(MSS.getInstance().var.prefix+ChatColor.AQUA+msg);
	}
	
	public boolean hasPermission(String node)
	{
		if(getPermissions().has(node) || getPermissions().has("MSS.*"))
		{
			return true;
		} else {
			print("Du brauchst dafür die Permission: "+ChatColor.RED+node);
			return false;
		}
	}
	
	public void sendUsage(String usage)
	{
		print(ChatColor.RED+"Verwendung: "+ChatColor.AQUA+usage.toLowerCase());
	}
	
}
