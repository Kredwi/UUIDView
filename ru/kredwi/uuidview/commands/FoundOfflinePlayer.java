package ru.kredwi.uuidview.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.Plugin;

import ru.kredwi.uuidview.utils.UUIDMessage;

public class FoundOfflinePlayer implements CommandExecutor {
	
	private Configuration config;
	
	public FoundOfflinePlayer(Plugin plugin) {
		config = plugin.getConfig();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		 if (args.length >= 2) {
			sender.sendMessage(getUUIDOfflinePlayers(args[1]));
		} else {
			sender.sendMessage(config.getString("command-usage"));
		}
		return true;
	}
	
	private String getUUIDOfflinePlayers(String playerName) {
		for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
			if (player.getName().equalsIgnoreCase(playerName)) {
				return new UUIDMessage(config).format(player.getName(), player.getUniqueId());
			}
		}
		return config.getString("message-not-player");
	}
}
