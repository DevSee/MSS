package me.MineShine;

import me.MineShine.Utils.Setup;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class MSS extends JavaPlugin 
{
	// Returning instance;
	static MSS mss;
	
	@Override
	public void onEnable()
	{
		//Setting instance;
		mss = this;
		Setup.print("Loading Config..");
		Setup.loadConfig();
		Setup.print("Loading Commands..");
		Setup.loadCommands();
		Setup.print("Lade Events..");
		Setup.loadEvents();
		Setup.print("Succesfully Loaded "+this.getDescription().getName()+" v"+this.getDescription().getVersion()+"!");
		Setup.print("Plugin coded for MineShine. Do not distribute. All rights reserved!");
		Setup.print("Created by: See, Sunix3, Dom3Zockt.");
	}
	
	@Override
	public void onDisable()
	{
		Setup.printAll("Das "+ChatColor.YELLOW+"MSS"+ChatColor.AQUA+" wurde deaktiviert!");
	}
	
	//Set getInstance method
	public static MSS getInstance()
	{
		return mss;
	}
}
