package me.larsfx.rc;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RideEvent implements Listener {

	@EventHandler
	public void onProfileClick(InventoryClickEvent event) {

		Player player = (Player) event.getWhoClicked(); // The player that

		ItemStack clicked = event.getCurrentItem(); // The item that was clicked
		Inventory inventory = event.getInventory(); // The inventory that was
		// clicked in
		if (inventory.getName().equals("§6RideCounter") && clicked.getType() == Material.STAINED_CLAY) {
			event.setCancelled(true);
			return;
		}
		if (inventory.getName().equals("§6RideCounter") && (clicked.getType() == Material.BARRIER)) {
			player.getOpenInventory().close();
			event.setCancelled(true);
			Bukkit.getScheduler().runTaskLater(RideCounter.getInstance(), () -> {

				player.performCommand("menu");
				return;
			}, 2);
		}
	}
}
