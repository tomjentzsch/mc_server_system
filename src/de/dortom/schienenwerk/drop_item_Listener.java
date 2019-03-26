package de.dortom.schienenwerk;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.dortom.main.Variablen;


public class drop_item_Listener implements Listener {
	
	@EventHandler
	public void onDrop (PlayerDropItemEvent e){
		
		
		
/*		String burn_name = (ChatColor.AQUA + "Industriekohle - Schienenwerk");
		
		ItemStack item_burn = new ItemStack(Material.COAL);
		ItemMeta meta_burn = item_burn.getItemMeta();
		meta_burn.setDisplayName(burn_name);
		item_burn.setItemMeta(meta_burn);				*/
		
		ItemStack panel = new ItemStack(Material.BOOK);
		ItemMeta p_m = panel.getItemMeta();
		p_m.setDisplayName(Variablen.bedienpanel);
		panel.setItemMeta(p_m);
		
		
/*		if(e.getItemDrop().getItemStack().equals(item_burn)){
			e.setCancelled(true);
		}else{
			System.out.println("Kein Bauteil gefunden!");
		} 																			*/
		
		
		if(e.getItemDrop().getItemStack().equals(panel)){
			e.setCancelled(true);
		}
		
	}
	

}
