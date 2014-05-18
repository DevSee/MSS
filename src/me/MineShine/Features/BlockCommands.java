package me.MineShine.Features;

import me.MineShine.Utils.MSPlayer;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class BlockCommands implements Listener
{
	@EventHandler
	public void onBlock(PlayerCommandPreprocessEvent e)
	{
		String args = e.getMessage();
		MSPlayer p = new MSPlayer(e.getPlayer());
		if(args.toLowerCase().contains("/pex") || args.toLowerCase().contains("/plugins") || args.toLowerCase().contains("/about") || args.toLowerCase().contains("/help") || args.toLowerCase().contains("/?") || args.toLowerCase().contains("/Version") || args.toLowerCase().contains("/ver"))
		{
			if(!p.hasPermission("MSS.Admin")){e.setCancelled(true);}
		}
	}
}
