package me.larsfx.rc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class RideCounter extends JavaPlugin {

	@Override
	public void onEnable() {
		instance = this;
		getCommand("ride").setExecutor(new RideCommand());
		getCommand("ridemenu").setExecutor(new OpenInventoryCommand());
		loadConfiguration();
		Bukkit.getServer().getPluginManager().registerEvents(new RideEvent(), this);
	}

	private void loadConfiguration() {
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();

	}

	private static RideCounter instance;

	public static RideCounter getInstance() {
		return instance;
	}

}
