package nl.justmaffie.maintenancemodeplus;

import org.bukkit.Bukkit;

import nl.justmaffie.maintenancemodeplus.commands.MaintenanceCommand;
import nl.justmaffie.pluginlibrary.CustomPlugin;
import nl.justmaffie.pluginlibrary.storage.YmlFile;
import nl.justmaffie.pluginlibrary.utils.Colors;

public class MaintenanceModePlus extends CustomPlugin implements MaintenanceApi {

	private YmlFile config;
	private YmlFile messages;

	@Override
	public void onEnable() {
		super.onEnable();
		config = new YmlFile(this, "config.yml");
		messages = new YmlFile(this, "messages.yml");
		for (Messages message : Messages.values()) {
			message.setFile(messages);
			messages.get().addDefault(message.getId(), message.getDefaultMessage());
		}
		messages.get().options().copyDefaults(true);
		messages.save();
		config.get().addDefault("maintenance.enabled", false);
		config.get().options().copyDefaults(true);
		config.save();
		new MaintenanceCommand(this);
	}

	public YmlFile getConfigFile() {
		return config;
	}

	@Override
	public void toggleMaintenance() {
		if (isInMaintenance()) {
			disableMaintenance();
		} else {
			enableMaintenance();
		}
	}

	@Override
	public void disableMaintenance() {
		config.get().set("maintenance.enabled", false);
		config.save();
		Bukkit.getOnlinePlayers().forEach((player) -> {
			player.sendMessage(Colors.color(Messages.MAINTENANCE_MODE_DISABLED.getMessage()));
		});
	}

	@Override
	public void enableMaintenance() {
		config.get().set("maintenance.enabled", true);
		config.save();
		Bukkit.getOnlinePlayers().forEach((player) -> {
			if (!player.hasPermission(Permissions.BYPASS_MAINTENANCE.getPermission())
					&& !player.hasPermission(Permissions.ACTIVATE_MAINTENANCE.getPermission())) {
				player.kickPlayer(Colors.color(Messages.KICKED_IN_MAINTENANCE.getMessage()));
			} else {
				player.sendMessage(Colors.color(Messages.MAINTENANCE_MODE_ENABLED.getMessage()));
			}
		});
	}

	@Override
	public boolean isInMaintenance() {
		return config.get().getBoolean("maintenance.enabled", false);
	}
}
