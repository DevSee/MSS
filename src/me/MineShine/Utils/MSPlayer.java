package me.MineShine.Utils;

import org.bukkit.entity.Player;

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
}
