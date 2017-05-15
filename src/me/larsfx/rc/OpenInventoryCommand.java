package me.larsfx.rc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OpenInventoryCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmnd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			return false;
		} else
			RideInventory.openMenu((Player) sender);
		return true;
	}

}
