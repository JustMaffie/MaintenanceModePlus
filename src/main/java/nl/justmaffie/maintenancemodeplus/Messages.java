package nl.justmaffie.maintenancemodeplus;

import nl.justmaffie.pluginlibrary.storage.YmlFile;
import nl.justmaffie.pluginlibrary.utils.Colors;

public enum Messages {
	KICKED_IN_MAINTENANCE("kicked", "&cYou cannot join this server\n&cThis server is currently in maintenance mode"),
	PLAYER_ONLY("player_only", "You must be a player to use this command."),
	MAINTENANCE_MODE_ENABLED("maintenance_mode.enabled", "&cMaintenance mode has been &4&lENABLED&c!"),
	MAINTENANCE_MODE_DISABLED("maintenance_mode.disabled", "&cMaintenance mode has been &a&lDISABLED&c!");

	private String id;
	private String defaultMsg;
	private YmlFile file;

	Messages(String id, String defaultMsg) {
		this.id = id;
		this.defaultMsg = defaultMsg;
	}

	public String getId() {
		return this.id;
	}

	public String getDefaultMessage() {
		return this.defaultMsg;
	}

	public void setFile(YmlFile file) {
		this.file = file;
	}

	public String getMessage() {
		return Colors.color(file.get().getString(this.getId(), this.getDefaultMessage()));
	}
}
