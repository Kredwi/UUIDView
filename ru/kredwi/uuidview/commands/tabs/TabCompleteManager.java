package ru.kredwi.uuidview.commands.tabs;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class TabCompleteManager implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
		List<String> list = new ArrayList<String>();
		if (args.length == 1) {
			list.add("get");
			list.add("off");
			list.add("reload");
		} else if (args.length == 2 && args[0].equalsIgnoreCase("get")) {
			for (Player player : Bukkit.getOnlinePlayers()) {
				if (sender.getName().equalsIgnoreCase(player.getName())) continue;
				list.add(player.getName());
			}
		} else if (args.length == 2 && args[0].equalsIgnoreCase("off")) {
			for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
				if (sender.getName().equalsIgnoreCase(player.getName())) continue;
				list.add(player.getName());
			}
		}
		return list.stream()
				.filter(s -> s.startsWith(args[args.length - 1]))
				.collect(Collectors.toList());
	}
}
