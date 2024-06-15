package ru.kredwi.uuidview.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import ru.kredwi.uuidview.utils.UUIDMessage;

public class FoundPlayer implements CommandExecutor {
	
	private Configuration config;
	
	public FoundPlayer(Plugin plugin) {
		config = plugin.getConfig();
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 1) {
            if (sender instanceof Player) sender.sendMessage(new UUIDMessage(config).getUUIDMessage((Player) sender));
            else sender.sendMessage(config.getString("specify-player"));
		} else if (args.length >= 2) {
			sender.sendMessage(new UUIDMessage(config).getUUIDMessage(Bukkit.getPlayer(args[1])));
		} else {
			sender.sendMessage(config.getString("command-usage"));
		}
		return true;
	}
}
