package me.larsfx.rc;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class RideInventory {

	public static void openMenu(Player p) {
		Inventory RideMenu = Bukkit.createInventory(p, 18, "§6RideCounter");
		createItems.createCustomItem(RideMenu, Material.BARRIER, (byte) 0, "§cBack ->", 17);
		p.openInventory(RideMenu);
		for (Rides rides : Rides.values()) {
			if (RideCounter.getInstance().getConfig()
					.getString(p.getUniqueId().toString() + "." + rides.name()) == null) {
				createItems.createCustomItemLores(RideMenu, Material.STAINED_CLAY, (byte) 3,
						rides.getColor() + rides.getName(), rides.getRideCounter(), "§6Aantal ritten: 0");
			} else if (RideCounter.getInstance().getConfig()
					.getString(p.getUniqueId().toString() + "." + rides.name()) != null) {
				int current = RideCounter.getInstance().getConfig()
						.getInt(p.getUniqueId().toString() + "." + rides.name());

				createItems.createCustomItemLores(RideMenu, Material.STAINED_CLAY, (byte) 3,
						rides.getColor() + rides.getName(), rides.getRideCounter(), "§6Aantal ritten: " + current);

			}
		}

	}
}
