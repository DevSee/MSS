package me.MineShine.System;

import me.MineShine.Utils.Setup;

import org.bukkit.plugin.java.JavaPlugin;

public class MSS extends JavaPlugin 
{
	@Override
	public void onEnable()
	{
		Setup.print("Succesfully Loaded "+this.getDescription().getName()+" v"+this.getDescription().getVersion()+"!");
		Setup.print("Created by: See, Sunix3, Dom3Zockt.");
		Setup.print("Plugin coded for MineShine.me: Do not distribute!");
	}
	
	@Override
	public void onDisable()
	{
		
	}
}
