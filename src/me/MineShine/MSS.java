package me.MineShine;

import me.MineShine.ChatManager.PlayerChatListener;
import me.MineShine.ClearLag.Commands.ClearLag_C;
import me.MineShine.Essentials.Commands.EXP_C;
import me.MineShine.Essentials.Commands.Enchant_C;
import me.MineShine.Essentials.Commands.Feed_C;
import me.MineShine.Essentials.Commands.Fly_C;
import me.MineShine.Essentials.Commands.GameMode_C;
import me.MineShine.Essentials.Commands.God_C;
import me.MineShine.Essentials.Commands.ME_C;
import me.MineShine.Essentials.Commands.MSG_C;
import me.MineShine.Essentials.Commands.More_C;
import me.MineShine.Essentials.Commands.Ping_C;
import me.MineShine.Essentials.Commands.Repair_C;
import me.MineShine.Essentials.Commands.Reply_C;
import me.MineShine.Essentials.Commands.Socialspy_C;
import me.MineShine.Essentials.Commands.Stack_C;
import me.MineShine.Essentials.Commands.Workbench_C;
import me.MineShine.Features.BlockCommands;
import me.MineShine.Utils.Console;

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
        Console.print("=======================================================");
        Console.print("|                                                     |");
        Console.print("|               MSS - MineShineSystem                 |");
        Console.print("|     Copyright (C) 2012 - 2014  Laurin Fäller        |");
        Console.print("|                                                     |");
        Console.print("|        This program is not free software!           |");
        Console.print("|    You are not allowed to use, modify or spread     |");
        Console.print("|  it without the agreement of the copyright holder.  |");
        Console.print("|                                                     |");
        Console.print("|          Contact: Admin@LF-Online.info              |");
        Console.print("|               Coded for MineShine.me                |");
        Console.print("|                                                     |");
        Console.print("=======================================================");
        Console.print("");
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
		Console.print("Created by: "+this.getDescription().getAuthors());
	}
	
	@Override
	public void onDisable()
	{
		Console.print("=======================================================");
		Console.print("|                                                     |");
		Console.print("|               MSS - MineShineSystem                 |");
		Console.print("|     Copyright (C) 2012 - 2014  Laurin Fäller        |");
		Console.print("|                                                     |");
		Console.print("|         This program is not free software!          |");
		Console.print("|             TPS successfully disabled!              |");
		Console.print("=======================================================");
		Console.printAll("Das "+ChatColor.YELLOW+"MSS"+ChatColor.AQUA+" wurde deaktiviert!");
	}
	
	//Set getInstance method
	public static MSS getInstance()
	{
		return mss;
	}
	
	private void loadConfig()
	{
		this.saveDefaultConfig();
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(var.config);
		var.host = cfg.getString("MineShine.SQL.Hostname");
		var.port = cfg.getString("MineShine.SQL.Port");
		var.user = cfg.getString("MineShine.SQL.Username");
		var.password = cfg.getString("MineShine.SQL.Password");
		var.database = cfg.getString("MineShine.SQL.Database");
		var.chatformat = cfg.getString("MineShine.Chat.Format");
	}
	
	private void loadEvents()
	{
		//MS-Economy
		
		//MS-ChatManager
		Bukkit.getPluginManager().registerEvents(new PlayerChatListener(), this);
		
		//MS-Shop:
		
		//MS-Essentials:
		Bukkit.getPluginManager().registerEvents(new God_C(), this);
		
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
		this.getCommand("fly").setExecutor(new Fly_C());
		this.getCommand("msg").setExecutor(new MSG_C());
		this.getCommand("reply").setExecutor(new Reply_C());
		this.getCommand("socialspy").setExecutor(new Socialspy_C());
		this.getCommand("gamemode").setExecutor(new GameMode_C());
		this.getCommand("ping").setExecutor(new Ping_C());
		this.getCommand("repair").setExecutor(new Repair_C());
		this.getCommand("workbench").setExecutor(new Workbench_C());
		this.getCommand("me").setExecutor(new ME_C());
		this.getCommand("more").setExecutor(new More_C());
		this.getCommand("god").setExecutor(new God_C());
		
		//MS-Bans:
		
		//MS-Suport:
		
		//MS-Stats
		
		//MS-Clan
		
		//MS-Friede
		
		//MS-ClearLag
		this.getCommand("clearlag").setExecutor(new ClearLag_C());
		
		//MS-Info
	}
}
