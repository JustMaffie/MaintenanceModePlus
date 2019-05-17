package nl.justmaffie.maintenancemodeplus.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;

import nl.justmaffie.maintenancemodeplus.MaintenanceModePlus;
import nl.justmaffie.maintenancemodeplus.Messages;
import nl.justmaffie.maintenancemodeplus.Permissions;
import nl.justmaffie.pluginlibrary.utils.Colors;

public class PlayerJoinListener implements Listener {
	private MaintenanceModePlus plugin;

	public PlayerJoinListener(MaintenanceModePlus plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onLogin(PlayerLoginEvent event) {
		if (plugin.isInMaintenance()) {
			if (!event.getPlayer().hasPermission(Permissions.BYPASS_MAINTENANCE.getPermission())
					&& !event.getPlayer().hasPermission(Permissions.ACTIVATE_MAINTENANCE.getPermission())) {
				event.disallow(Result.KICK_WHITELIST, Colors.color(Messages.KICKED_IN_MAINTENANCE.getMessage()));
			}
		}
	}
}
