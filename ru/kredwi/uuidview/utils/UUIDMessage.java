package ru.kredwi.uuidview.utils;

import java.util.UUID;

import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;

public class UUIDMessage {
	
	private Configuration config;
	
	public UUIDMessage(Configuration config) {
		this.config = config;
	}
	
	public String getUUIDMessage(Player player) {
		if (player == null) return config.getString("message-not-player");
		else return format(player.getName(), player.getUniqueId());
		// PlaceholdersAPI is not required :);
	}
	public String format(String name, UUID uuid) {
		return config.getString("message-uuid")
				.replaceAll("%nickname%", name)
				.replaceAll("%uuid%", uuid.toString());
		// PlaceholdersAPI is not required :);
	}
}
