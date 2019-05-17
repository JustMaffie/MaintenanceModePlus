package nl.justmaffie.maintenancemodeplus;

public enum Permissions {
	ACTIVATE_MAINTENANCE("maintenancemodeplus.activate"), BYPASS_MAINTENANCE("maintenancemodeplus.bypass");
	private String permission;

	Permissions(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
}
