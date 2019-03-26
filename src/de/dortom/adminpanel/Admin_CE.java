package de.dortom.adminpanel;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.dortom.main.Main;
import de.dortom.main.Variablen;

public class Admin_CE implements CommandExecutor {

	public Admin_CE(Main main) {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;

		ItemStack flyspeed = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta flyspeed_meta = flyspeed.getItemMeta();
		flyspeed_meta.setDisplayName("Flyspeed");
		flyspeed.setItemMeta(flyspeed_meta);

		ItemStack flyspeed_schnell = new ItemStack(Material.DIAMOND_BOOTS);
		ItemMeta flyspeed_schnell_meta = flyspeed_schnell.getItemMeta();
		flyspeed_schnell_meta.setDisplayName("schnell");
		flyspeed_schnell.setItemMeta(flyspeed_schnell_meta);
		Variablen.flyspeed_inv.setItem(5, flyspeed_schnell);

		ItemStack flyspeed_mittel = new ItemStack(Material.GOLDEN_BOOTS);
		ItemMeta flyspeed_mittel_meta = flyspeed_mittel.getItemMeta();
		flyspeed_mittel_meta.setDisplayName("mittel");
		flyspeed_mittel.setItemMeta(flyspeed_mittel_meta);
		Variablen.flyspeed_inv.setItem(3, flyspeed_mittel);

		ItemStack flyspeed_normal = new ItemStack(Material.IRON_BOOTS);
		ItemMeta flyspeed_normal_meta = flyspeed_normal.getItemMeta();
		flyspeed_normal_meta.setDisplayName("normal");
		flyspeed_normal.setItemMeta(flyspeed_normal_meta);
		Variablen.flyspeed_inv.setItem(1, flyspeed_normal);

		Variablen.adminpanel.setItem(7, flyspeed);

		if (cmd.getName().equalsIgnoreCase("admin")) {
			p.openInventory(Variablen.adminpanel);
		}

		return true;
	}

}
