package nl.justmaffie.maintenancemodeplus.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import nl.justmaffie.maintenancemodeplus.MaintenanceModePlus;
import nl.justmaffie.pluginlibrary.CustomPlugin;
import nl.justmaffie.pluginlibrary.gui.GUI;
import nl.justmaffie.pluginlibrary.gui.Item;
import nl.justmaffie.pluginlibrary.gui.ItemBuilder;

public class MaintenanceGUI extends GUI {
	private CustomPlugin plugin;

	public MaintenanceGUI(CustomPlugin plugin, Player player) {
		super(plugin, player);
		this.plugin = plugin;
	}

	@Override
	public String getName() {
		return "Maintenance Mode";
	}

	@Override
	public List<Item> getItems() {
		MaintenanceModePlus plugin = (MaintenanceModePlus) this.plugin;
		final ArrayList<Item> items = new ArrayList<Item>();
		items.add(ItemBuilder.newBuilder()
				.setName(plugin.isInMaintenance() ? "&cDisable Maintenance Mode" : "&aEnable Maintenance Mode")
				.setItem(plugin.isInMaintenance() ? Material.REDSTONE_BLOCK : Material.EMERALD_BLOCK)
				.setLore(plugin.isInMaintenance() ? Arrays.asList("&7Click to disable maintenance")
						: Arrays.asList("&7Click to enable maintenance"))
				.onClick((clickevent) -> {
					plugin.toggleMaintenance();
				}).setSlot(4).build());
		return items;
	}

	@Override
	public int getSize() {
		return 9;
	}

}
