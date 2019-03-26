package de.dortom.schienenwerk;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import de.dortom.main.Variablen;

public class player_interact_Listener implements Listener {
	
	@EventHandler
	public void player_interact(PlayerInteractEvent e){
		
		Player p = e.getPlayer();
		Inventory bedienpanel = Bukkit.createInventory(null, 9, Variablen.bedienpanel);
		
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR){
				try{
					if(e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(Variablen.bedienpanel)){
						p.openInventory(bedienpanel);
					}
				}catch(Exception ex){
					
				}

			
		}
		
	}

}
