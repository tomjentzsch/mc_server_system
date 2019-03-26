package de.dortom.schienenwerk;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.dortom.main.Variablen;

public class block_break_Listener implements Listener {
	
	@EventHandler
	public void block_break(BlockBreakEvent e){
		
		ItemStack eisen = new ItemStack(Material.IRON_ORE);
		ItemMeta meta = eisen.getItemMeta();
		meta.setDisplayName("Test1");
		eisen.setItemMeta(meta);

		//abfragen ob Block richtg
		if(Variablen.locs.contains(e.getBlock().getLocation())){
			e.getPlayer().getWorld().dropItem(e.getPlayer().getLocation(), eisen);
			System.out.println("Drop und cancel geht!");
			e.setCancelled(true);
		}
		
	}

}