package de.dortom.garage;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import de.dortom.main.Main;
import de.dortom.main.Variablen;
import de.dortom.money.Money_methods;

public class garage_Inventory_click_Listener implements Listener {

	@EventHandler
	private void garage_Inventory_click(InventoryClickEvent e) {

		Player p = (Player) e.getWhoClicked();
		Object uuid = p.getUniqueId().toString();

		Double g1_price = 20.0;
		Double g1_sell_price = 0.70 * g1_price;
		// Double g2_price = 20.0;
		// Double g3_price = 20.0;
		// Double g4_price = 20.0;
		// Double g5_price = 20.0;
		// Double g6_price = 20.0;
		// Double g7_price = 20.0;
		// Double g8_price = 20.0;

		World w = Bukkit.getServer().getWorld("CraftingCity_0.1");

		// Sign g2_sign = (Sign) w.getBlockAt(new Location(w, 357, 72,
		// 26)).getState();
		// Sign g3_sign = (Sign) w.getBlockAt(new Location(w, 357, 72,
		// 26)).getState();
		// Sign g4_sign = (Sign) w.getBlockAt(new Location(w, 357, 72,
		// 26)).getState();
		// Sign g5_sign = (Sign) w.getBlockAt(new Location(w, 357, 72,
		// 26)).getState();
		// Sign g6_sign = (Sign) w.getBlockAt(new Location(w, 357, 72,
		// 26)).getState();
		// Sign g7_sign = (Sign) w.getBlockAt(new Location(w, 357, 72,
		// 26)).getState();
		// Sign g8_sign = (Sign) w.getBlockAt(new Location(w, 357, 72,
		// 26)).getState();

		try {

			if (e.getClickedInventory().getName().equalsIgnoreCase(Variablen.garagen_inv)) {

				Sign g1_sign = (Sign) w.getBlockAt(new Location(w, -60, 70, -986)).getState();
				// Sign g2_sign = (Sign) w.getBlockAt(new Location(w, 357, 72,
				// 26)).getState();
				// Sign g3_sign = (Sign) w.getBlockAt(new Location(w, 357, 72,
				// 26)).getState();
				// Sign g4_sign = (Sign) w.getBlockAt(new Location(w, 357, 72,
				// 26)).getState();
				// Sign g5_sign = (Sign) w.getBlockAt(new Location(w, 357, 72,
				// 26)).getState();
				// Sign g6_sign = (Sign) w.getBlockAt(new Location(w, 357, 72,
				// 26)).getState();
				// Sign g7_sign = (Sign) w.getBlockAt(new Location(w, 357, 72,
				// 26)).getState();
				// Sign g8_sign = (Sign) w.getBlockAt(new Location(w, 357, 72,
				// 26)).getState();

				String item_name = e.getCurrentItem().getItemMeta().getDisplayName();
				String Garage_1 = Main.main.garage_cfg.getString("Garage_1" + ".status");
				// String Garage_2 = Main.main.garage_cfg.getString("Garage_2");
				// String Garage_3 = Main.main.garage_cfg.getString("Garage_3");
				// String Garage_4 = Main.main.garage_cfg.getString("Garage_4");
				// String Garage_5 = Main.main.garage_cfg.getString("Garage_5");
				// String Garage_6 = Main.main.garage_cfg.getString("Garage_6");
				// String Garage_7 = Main.main.garage_cfg.getString("Garage_7");
				// String Garage_8 = Main.main.garage_cfg.getString("Garage_8");

				switch (item_name) {

				case "Garage 1":

					if ((Garage_1.equals("verkauft"))) {
						p.sendMessage("bereits verkauft");
						e.setCancelled(true);

						if (g1_sign.getLine(3).equals(p.getName())) {
							p.sendMessage("Garage verkauft!");
							Main.main.garage_cfg.set("Garage_1" + ".status", "");
							Main.main.garage_cfg.set("Garage_1" + ".uuid", "");
							Main.main.garage_cfg.save(Main.main.garage_file);
							Money_methods.addmoney(p.getUniqueId(), g1_sell_price);
							sign_update_sell(g1_sign, p, "1", g1_sign.getLocation(), w);
							p.closeInventory();

						} else {

						}

					} else {
						if (Money_methods.getmoney(p.getUniqueId()) >= g1_price) {
							Money_methods.removemoney(p.getUniqueId(), g1_price);
							p.sendMessage("gekauft!");
							Main.main.garage_cfg.set("Garage_1" + ".status", "verkauft");
							Main.main.garage_cfg.set("Garage_1" + ".uuid", uuid);
							Main.main.garage_cfg.save(Main.main.garage_file);
							sign_update_buy(g1_sign, p, "1", g1_sign.getLocation(), w);
							//e.setCancelled(true);
							p.closeInventory();
						} else {
							p.sendMessage("Du hast nicht genug Geld!");
							e.setCancelled(true);
						}
					}
					break;

				default:
					break;

				}
			} else {

			}
		} catch (Exception ex) {
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////
	//
	// Bezeichnungsupdate nach kauf
	//
	//////////////////////////////////////////////////////////////////////////////////////////

	private void sign_update_buy(Sign s, Player p, String garage_number, Location loc, World w) {

		s.setLine(0, "Garage");
		s.setLine(1, garage_number);
		s.setLine(2, "Besitzer:");
		s.setLine(3, p.getName());
		s.update();

	}

	//////////////////////////////////////////////////////////////////////////////////////////
	//
	// Bezeichnungsupdate nach verkauf
	//
	//////////////////////////////////////////////////////////////////////////////////////////

	private void sign_update_sell(Sign s, Player p, String garage_number, Location loc, World w) {

		s.setLine(0, "Garage");
		s.setLine(1, garage_number);
		s.setLine(2, "ZU VERKAUFEN!");
		s.setLine(3, "-> /garage");
		s.update();

	}

}
