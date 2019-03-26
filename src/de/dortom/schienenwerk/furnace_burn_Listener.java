package de.dortom.schienenwerk;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class furnace_burn_Listener implements Listener{

	@EventHandler
	public static void furnace_burn (FurnaceBurnEvent e){
	
		String burn_name = (ChatColor.AQUA + "Industriekohle - Schienenwerk");
		
		ItemStack item_burn = new ItemStack(Material.COAL);
		ItemMeta meta_burn = item_burn.getItemMeta();
		meta_burn.setDisplayName(burn_name);
		item_burn.setItemMeta(meta_burn);
		
		try {
			if(e.getFuel().getItemMeta().getDisplayName().equalsIgnoreCase(burn_name)){
				e.setBurnTime(5);
				System.out.print("Testnachricht");
			}
		} catch (Exception ex) {

		}
		

	
	}

}
