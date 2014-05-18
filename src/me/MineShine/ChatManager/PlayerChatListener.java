package me.MineShine.ChatManager;

import me.MineShine.MSS;
import me.MineShine.Utils.MSPlayer;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener 
{
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e)
	{
		MSPlayer p = new MSPlayer(e.getPlayer());
		String format = MSS.getInstance().var.chatformat;
		format = format.replace("%playername", p.getPlayer().getName());
		format = format.replace("%prefix", p.getPermissions().getPrefix());
		format = format.replace("%suffix", p.getPermissions().getSuffix());
		format = format.replace("%message", e.getMessage());
		format = ChatColor.translateAlternateColorCodes('&', format);
		
		e.setFormat(format);
	}
}
