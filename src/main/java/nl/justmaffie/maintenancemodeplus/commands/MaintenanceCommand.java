package nl.justmaffie.maintenancemodeplus.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import nl.justmaffie.maintenancemodeplus.Messages;
import nl.justmaffie.maintenancemodeplus.gui.MaintenanceGUI;
import nl.justmaffie.pluginlibrary.CustomPlugin;
import nl.justmaffie.pluginlibrary.command.AbstractCommand;
import nl.justmaffie.pluginlibrary.command.CommandResult;
import nl.justmaffie.pluginlibrary.command.EmptyTabCompleter;

public class MaintenanceCommand extends AbstractCommand {

	public MaintenanceCommand(CustomPlugin plugin) {
		super(plugin);
	}

	@Override
	public String getName() {
		return "maintenance";
	}

	@Override
	public TabCompleter getTabCompleter() {
		// Its a GUI based command, and console can't tab complete, so no need to make a
		// tab completer
		return new EmptyTabCompleter();
	}

	@Override
	public CommandResult onConsoleSender(CommandSender sender, Command cmd, String label, String[] args) {
		return CommandResult.get(Messages.PLAYER_ONLY.getMessage());
	}

	@Override
	public CommandResult onPlayerSender(Player player, Command cmd, String label, String[] args) {
		new MaintenanceGUI(plugin, player).open();
		return CommandResult.get(); // Don't send a message, only open the GUI
	}

}
