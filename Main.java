package me.serverproxy.staffhelper;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	
	@Override
	public void onEnable() {
		getConfig().options().copyDefaults(true);
		saveDefaultConfig();
		this.getServer().getPluginManager().registerEvents(new BannedPlayerJoin(this), this);
		getCommand("kick").setExecutor(new CommandKick());
		getCommand("ban").setExecutor(new CommandBan(this));
		getCommand("unban").setExecutor(new CommandUnBan(this));
	}
	
	@Override
	public void onDisable() {
		saveConfig();
	}

}
