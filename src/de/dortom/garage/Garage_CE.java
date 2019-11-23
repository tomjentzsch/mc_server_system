package de.dortom.garage;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.dortom.main.Main;
import de.dortom.main.Variablen;

public class Garage_CE implements CommandExecutor {

	public Garage_CE(Main main) {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
m
		// File Zugriff ob verkauft oder frei
		String Garage_1 = Main.main.garage_cfg.getString("Garage_1" + ".status");
		// String Garage_2 = Main.main.garage_cfg.getString("Garage_2");
		// String Garage_3 = Main.main.garage_cfg.getString("Garage_3");

		Inventory inv = Bukkit.createInventory(null, 9, Variablen.garagen_inv);

		// ItemStacks
		ItemStack g1 = new ItemStack(Material.MAP);
		ItemMeta g1_meta = g1.getItemMeta();
		g1_meta.setDisplayName("Garage 1");

		// ArrayLists
		ArrayList<String> zu_verkaufen = new ArrayList<>();
		zu_verkaufen.add("Zu Verkaufen!");

		ArrayList<String> verkauft = new ArrayList<>();
		verkauft.add("Verkauft!");

		ArrayList<String> own_garage = new ArrayList<>();
		own_garage.add("Um deine Garage zu verkaufen(Linksklick)!");

		Object uuid = Main.main.garage_cfg.get("Garage_1" + ".uuid");

		try {

			if (Garage_1.equals("verkauft")) {
				if (uuid.equals(p.getUniqueId().toString())) {
					p.sendMessage("Geht!");
					g1_meta.setLore(own_garage);
					g1.setItemMeta(g1_meta);
					inv.setItem(0, g1);
				} else {
					g1_meta.setLore(verkauft);
					g1.setItemMeta(g1_meta);
					inv.setItem(0, g1);
				}

			} else {
				g1_meta.setLore(zu_verkaufen);
				g1.setItemMeta(g1_meta);
				inv.setItem(0, g1);
			}

			p.openInventory(inv);
		} catch (Exception e) {
		}

		return false;
	}

}
