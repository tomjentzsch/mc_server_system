package de.dortom.garage;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class garage_sign_Listener implements Listener {

	@EventHandler
	public void PlayerInteract(PlayerInteractEvent e) {

		Player p = e.getPlayer();

		// auf UUID umschreiben!

		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getClickedBlock().getState() instanceof Sign) {
				Sign s = (Sign) e.getClickedBlock().getState();

				if (s.getLine(0).equalsIgnoreCase("Garage")) {
					if (s.getLine(2).equalsIgnoreCase("Besitzer:")) {

						// Sign playername -> zu String -> zu UUID
						Player test1 = Bukkit.getServer().getPlayer(s.getLine(3));

						if (test1.getUniqueId().toString().equals(p.getUniqueId().toString())) {
							String garage = s.getLine(1).toString();
							open_close_garage(p.getUniqueId(), p, garage, s);
						} else {
							p.sendMessage("Nicht deine Garage!");
						}

					} else if (s.getLine(2).equalsIgnoreCase("ZU VERKAUFEN")) {
						p.sendMessage("Benutze /garage !");
					}
				}
			}
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////
	//
	// Locations - Garagen
	//
	//////////////////////////////////////////////////////////////////////////////////////////

	World w = Bukkit.getWorld("CraftingCity_0.1");

	// Garage 1
	Location g1_0 = new Location(w, -61, 71, -984);
	Location g1_1 = new Location(w, -62, 71, -984);
	Location g1_2 = new Location(w, -63, 71, -984);
	Location g1_3 = new Location(w, -64, 71, -984);
	Location g1_4 = new Location(w, -65, 71, -984);
	
	Location g1_5 = new Location(w, -61, 70, -984);
	Location g1_6 = new Location(w, -62, 70, -984);
	Location g1_7 = new Location(w, -63, 70, -984);
	Location g1_8 = new Location(w, -64, 70, -984);
	Location g1_9 = new Location(w, -65, 70, -984);
	
	Location g1_10 = new Location(w, -61, 69, -984);
	Location g1_11 = new Location(w, -62, 69, -984);
	Location g1_12 = new Location(w, -63, 69, -984);
	Location g1_13 = new Location(w, -64, 69, -984);
	Location g1_14 = new Location(w, -65, 69, -984);
	// Garage 2

	private void open_close_garage(UUID uuid, Player p, String garage, Sign s) {

		switch (garage) {
		case "1":
			if (g1_0.getBlock().getType().equals(Material.AIR)) {
				p.sendMessage("Tor geschlossen!");
				g1_close();
			} else {
				p.sendMessage("Tor geoeffnet!");
				g1_open();
			}
			break;

		// case "2":
		// if (g1_0.getBlock().getType().equals(Material.AIR)) {
		// p.sendMessage("Tor geschlossen!");
		// g1_close();
		// } else {
		// p.sendMessage("Tor geoeffnet!");
		// g1_open();
		// }
		// break;
		//
		// case "3":
		// if (g1_0.getBlock().getType().equals(Material.AIR)) {
		// p.sendMessage("Tor geschlossen!");
		// g1_close();
		// } else {
		// p.sendMessage("Tor geoeffnet!");
		// g1_open();
		// }
		// break;
		//
		// case "4":
		// if (g1_0.getBlock().getType().equals(Material.AIR)) {
		// p.sendMessage("Tor geschlossen!");
		// g1_close();
		// } else {
		// p.sendMessage("Tor geoeffnet!");
		// g1_open();
		// }
		// break;
		//
		// case "5":
		// if (g1_0.getBlock().getType().equals(Material.AIR)) {
		// p.sendMessage("Tor geschlossen!");
		// g1_close();
		// } else {
		// p.sendMessage("Tor geoeffnet!");
		// g1_open();
		// }
		// break;
		//
		// case "6":
		// if (g1_0.getBlock().getType().equals(Material.AIR)) {
		// p.sendMessage("Tor geschlossen!");
		// g1_close();
		// } else {
		// p.sendMessage("Tor geoeffnet!");
		// g1_open();
		// }
		// break;

		default:
			break;
		}

	}

	//////////////////////////////////////////////////////////////////////////////////////////
	//
	// Locations - Garagen
	//
	//////////////////////////////////////////////////////////////////////////////////////////

	private void g1_open() {
		g1_0.getBlock().setType(Material.AIR);
		g1_1.getBlock().setType(Material.AIR);
		g1_2.getBlock().setType(Material.AIR);
		g1_3.getBlock().setType(Material.AIR);
		g1_4.getBlock().setType(Material.AIR);
		g1_5.getBlock().setType(Material.AIR);
		g1_6.getBlock().setType(Material.AIR);
		g1_7.getBlock().setType(Material.AIR);
		g1_8.getBlock().setType(Material.AIR);
		g1_9.getBlock().setType(Material.AIR);
		g1_10.getBlock().setType(Material.AIR);
		g1_11.getBlock().setType(Material.AIR);
		g1_12.getBlock().setType(Material.AIR);
		g1_13.getBlock().setType(Material.AIR);
		g1_14.getBlock().setType(Material.AIR);
	}

	private void g1_close() {
		g1_0.getBlock().setType(Material.QUARTZ_PILLAR);
		g1_1.getBlock().setType(Material.QUARTZ_PILLAR);
		g1_2.getBlock().setType(Material.QUARTZ_PILLAR);
		g1_3.getBlock().setType(Material.QUARTZ_PILLAR);
		g1_4.getBlock().setType(Material.QUARTZ_PILLAR);
		g1_5.getBlock().setType(Material.QUARTZ_PILLAR);
		g1_6.getBlock().setType(Material.QUARTZ_PILLAR);
		g1_7.getBlock().setType(Material.QUARTZ_PILLAR);
		g1_8.getBlock().setType(Material.QUARTZ_PILLAR);
		g1_9.getBlock().setType(Material.QUARTZ_PILLAR);
		g1_10.getBlock().setType(Material.QUARTZ_PILLAR);
		g1_11.getBlock().setType(Material.QUARTZ_PILLAR);
		g1_12.getBlock().setType(Material.QUARTZ_PILLAR);
		g1_13.getBlock().setType(Material.QUARTZ_PILLAR);
		g1_14.getBlock().setType(Material.QUARTZ_PILLAR);
	}

}
