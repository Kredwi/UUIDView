package ru.kredwi.uuidview;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import ru.kredwi.uuidview.commands.ConfigReload;
import ru.kredwi.uuidview.commands.FoundOfflinePlayer;
import ru.kredwi.uuidview.commands.FoundPlayer;

public class MainCommandExecutor implements CommandExecutor {
	
	private Plugin plugin;
	
	public MainCommandExecutor(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!sender.hasPermission("uuidview.use")) {
			sender.sendMessage(plugin.getConfig().getString("message-no-permission"));
			return true;
		} else if (args.length < 1) {
			sender.sendMessage(plugin.getConfig().getString("command-usage"));
			return true;
		}
		switch (args[0].toLowerCase()) {
			case "get": {
				new FoundPlayer(plugin).onCommand(sender, cmd, label, args);
				break;
			}
			case "off": {
				new FoundOfflinePlayer(plugin).onCommand(sender, cmd, label, args);
				break;
			}
			case "reload": {
				new ConfigReload(plugin).onCommand(sender, cmd, label, args);
				break;
			}
		}
		return true;
	}
}
