package de.dortom.schienenwerk;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.dortom.main.Variablen;

public class inventory_click_Listener implements Listener {
	
	
	@EventHandler
	public void inventory_click(InventoryClickEvent e){
		
		ItemStack panel = new ItemStack(Material.BOOK);
		ItemMeta p_m = panel.getItemMeta();
		p_m.setDisplayName(Variablen.bedienpanel);
		panel.setItemMeta(p_m);
		
		
		try{
			if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(Variablen.bedienpanel)){
				System.out.println("test");
				e.setCancelled(true);
			}
			
			
			
			
			
			
			
		}catch(Exception ex){
			
		}

		
	}

}
