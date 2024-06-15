package ru.kredwi.uuidview.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class ConfigReload implements CommandExecutor {
	
	private Plugin plugin;
	
	public ConfigReload(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!sender.hasPermission("uuidview.reload")) {
			sender.sendMessage(plugin.getConfig().getString("message-no-permission"));
			return true;
		}
		plugin.reloadConfig();
		sender.sendMessage(plugin.getConfig().getString("config-reloaded"));
		return true;
	}
}
