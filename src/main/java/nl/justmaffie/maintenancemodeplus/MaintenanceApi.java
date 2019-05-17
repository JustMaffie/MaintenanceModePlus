package nl.justmaffie.maintenancemodeplus;

public interface MaintenanceApi {
	public void toggleMaintenance();

	public void disableMaintenance();

	public void enableMaintenance();

	public boolean isInMaintenance();
}
