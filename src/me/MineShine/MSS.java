package me.MineShine;

import java.io.IOException;

import me.MineShine.Essentials.Commands.EXP_C;
import me.MineShine.Essentials.Commands.Enchant_C;
import me.MineShine.Essentials.Commands.Feed_C;
import me.MineShine.Essentials.Commands.Stack_C;
import me.MineShine.Features.BlockCommands;
import me.MineShine.Utils.Console;
import me.MineShine.Utils.Setup;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class MSS extends JavaPlugin 
{
	// Returning instance;
	static MSS mss;
	public Var var = new Var();
	
	@Override
	public void onEnable()
	{
		//Setting instance;
		mss = this;
		Console.print("Loading Config..");
		loadConfig();
		Console.print("Loading Commands..");
		loadCommands();
		Console.print("Loading Events..");
		loadEvents();
		Console.print("Establishing MySQL Connection..");
		//TODO Add MySQL-Methods
		Console.print("Succesfully Loaded "+this.getDescription().getName()+" v"+this.getDescription().getVersion()+"!");
		Console.print("Plugin coded for MineShine. Do not distribute. All rights reserved!");
		Console.print("Created by: See, Sunix3, Dom3Zockt.");
	}
	
	@Override
	public void onDisable()
	{
		Console.printAll("Das "+ChatColor.YELLOW+"MSS"+ChatColor.AQUA+" wurde deaktiviert!");
	}
	
	//Set getInstance method
	public static MSS getInstance()
	{
		return mss;
	}
	
	private void loadConfig()
	{
		if(Setup.checkFile(var.config, "plugins//MSS") == false)
		{
			FileConfiguration cfg = YamlConfiguration.loadConfiguration(var.config);
			cfg.set("MineShine.SQL.Hostname", "Host");
			cfg.set("MineShine.SQL.Port", "3306");
			cfg.set("MineShine.SQL.Username", "User");
			cfg.set("MineShine.SQL.Password", "Password");
			cfg.set("MineShine.SQL.Database", "database");
			try{cfg.save(var.config);}catch(IOException e){}
		}
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(var.config);
		var.host = cfg.getString("MineShine.SQL.Hostname");
		var.port = cfg.getString("MineShine.SQL.Port");
		var.user = cfg.getString("MineShine.SQL.Username");
		var.password = cfg.getString("MineShine.SQL.Password");
		var.database = cfg.getString("MineShine.SQL.Database");
	}
	
	private void loadEvents()
	{
		//MS-Economy:
		
		//MS-Shop:
		
		//MS-Essentials:
		
		//MS-Bans:
		
		//MS-Suport:
		
		//MS-Stats
		
		//MS-Clan
		
		//MS-Friede
		
		//MS-Info
		Bukkit.getPluginManager().registerEvents(new BlockCommands(), this);
	}
	
	/*
	 * Runs in Main;
	 */
	
	private void loadCommands()
	{
		//MS-Economy:
		
		//MS-Shop:
		
		//MS-Essentials:
		this.getCommand("feed").setExecutor(new Feed_C());
		this.getCommand("stack").setExecutor(new Stack_C());
		this.getCommand("enchant").setExecutor(new Enchant_C());
		this.getCommand("exp").setExecutor(new EXP_C());
		
		//MS-Bans:
		
		//MS-Suport:
		
		//MS-Stats
		
		//MS-Clan
		
		//MS-Friede
		
		//MS-Info
	}
}
