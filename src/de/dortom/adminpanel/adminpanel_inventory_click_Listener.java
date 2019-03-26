package de.dortom.adminpanel;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.dortom.main.Variablen;

public class adminpanel_inventory_click_Listener implements Listener {

	@EventHandler
	private void inventory_click(InventoryClickEvent e) {

		Player p = (Player) e.getWhoClicked();

		try {
			if (e.getClickedInventory().getName().equals("Adminpanel")) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("Flyspeed")) {
					p.openInventory(Variablen.flyspeed_inv);
					e.setCancelled(true);
				}
			} else if (e.getClickedInventory().getName().equals("Flyspeed")) {
				if (e.getCurrentItem().getItemMeta().getDisplayName().equals("normal")) {
					p.setFlySpeed(0.1F);
					p.sendMessage("§2[Info] §fDein Flyspeed wurde auf normal gestellt!");
					p.closeInventory();
					e.setCancelled(true);
				} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("mittel")) {
					p.setFlySpeed(0.3F);
					p.sendMessage("§2[Info] §fDein Flyspeed wurde auf mittel gestellt!");
					p.closeInventory();
					e.setCancelled(true);
				} else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("schnell")) {
					p.setFlySpeed(0.6F);
					p.sendMessage("§2[Info] §fDein Flyspeed wurde auf schnell gestellt!");
					p.closeInventory();
					e.setCancelled(true);
				}
			}
		} catch (Exception ex) {

		}

	}

}
