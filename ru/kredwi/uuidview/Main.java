package ru.kredwi.uuidview;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import ru.kredwi.uuidview.commands.tabs.TabCompleteManager;

public class Main extends JavaPlugin {
	public FileConfiguration config;
	
	@Override
	public void onLoad() {
		try {
			File configFile = new File(getDataFolder(), "config.yml");
			if (!configFile.exists()) {
				configFile.getParentFile().mkdirs();
				saveResource("config.yml", false);
			}
			config = YamlConfiguration.loadConfiguration(configFile);
			config.save(configFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void onEnable() {
		getCommand("uuidview").setExecutor(new MainCommandExecutor(this));
		getCommand("uuidview").setTabCompleter(new TabCompleteManager());
	}
}