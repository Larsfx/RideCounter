package me.larsfx.rc;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class RideCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (args.length != 2) {
			cs.sendMessage(ChatColor.RED + "Mislukt! [Args]");
			return false;
		}
		if (args.length == 2) {

			Rides rides = getRide(args[0]);
			Player target = Bukkit.getServer().getPlayer(args[1]);
			if (rides == null && target == null) {
				cs.sendMessage(ChatColor.RED + "Mislukt! [Ride/Player]");
				return false;
			} else if (RideCounter.getInstance().getConfig()
					.getString(target.getUniqueId().toString() + "." + rides.name()) == null) {
				int current = RideCounter.getInstance().getConfig()
						.getInt(target.getUniqueId().toString() + "." + rides.name());
				int toAdd = 1;
				int added = current + toAdd;
				target.sendMessage(" ");
				target.sendMessage("§6Je aantal ritten in de " + rides.getName() + "§6 staat nu op " + added + "");
				target.sendMessage(" ");
				cs.sendMessage(ChatColor.GREEN + "Gelukt! [RideCounter geupdate]");
				RideCounter.getInstance().getConfig().set(target.getUniqueId().toString() + "." + rides.name(),
						added);
				RideCounter.getInstance().saveConfig();
				return true;
			} else if (!(RideCounter.getInstance().getConfig()
					.getString(target.getUniqueId().toString() + "." + rides.name()) == null)) {
				int current = RideCounter.getInstance().getConfig()
						.getInt(target.getUniqueId().toString() + "." + rides.name());
				int toAdd = 1;
				int added = current + toAdd;
				cs.sendMessage(ChatColor.GREEN + "Gelukt! [RideCounter geupdate]");
				target.sendMessage(" ");
				target.sendMessage("§6Je aantal ritten in de " + rides.getName() + "§6 staat nu op " + added + "");
				target.sendMessage(" ");
				RideCounter.getInstance().getConfig().set(target.getUniqueId().toString() + "." + rides.name(),
						current + toAdd);
				RideCounter.getInstance().saveConfig();
				

			}
		}

		{

		}
		{

		}

		{
		}
		return false;
	}

	private Rides getRide(String ride) {
		for (Rides rides : Rides.values()) {
			if (rides.name().equalsIgnoreCase(ride)) {

				return rides;

			}
		}
		return null;
	}
}
