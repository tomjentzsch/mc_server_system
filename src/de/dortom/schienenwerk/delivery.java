package de.dortom.schienenwerk;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import de.dortom.main.Main;
import de.dortom.main.Variablen;

public class delivery {
	
	public delivery() {
	}

	@SuppressWarnings("deprecation")
	public void delivery_items(){
		
		Bukkit.getServer().getScheduler().scheduleAsyncRepeatingTask(Main.main, new Runnable(){

			
			World w = Bukkit.getServer().getWorld("CraftingCity_0.1");
			
			@Override
			public void run() {
				
				String time = new SimpleDateFormat("HH:mm:ss").format(new Date());

				if(time.equalsIgnoreCase("")){
					loc_list_check();
					iron_delivery();
				}else if(time.equalsIgnoreCase("")){
					iron_delivery();
					wood_delivery();
					redstone_delivery();
					string_delivery();
					pressure_plate_delivery();
				}
			}
			
			
			
			////////////////////////////////////////////////////////////////////////////////////////////////////
			//Lieferung Eisenerz
			private void iron_delivery() {
				Location iron1 = new Location(w, 272, 63, -1056);
				
				w.getBlockAt(iron1).setType(Material.IRON_ORE);
				
			//alternativ mit BlockMeta --> aber Abfrage Meta in block_break_event
			//	Block b = w.getBlockAt(iron1);
			//	b.setMetadata("name", new FixedMetadataValue(Main.main, "Testblock"));
				
				
				for(Player p : Variablen.beigetreten){
					p.sendMessage("[Info] Die Lieferung aus dem Bergwerk ist eingetroffen!");
				}
			}
			
			////////////////////////////////////////////////////////////////////////////////////////////////////
			//Lieferung Baumstämme
			private void wood_delivery() {
				Location wood1 = new Location (w,271,63,-1056);
				
				w.getBlockAt(wood1).setType(Material.ACACIA_WOOD);
				
				for(Player p : Variablen.beigetreten){
					p.sendMessage("[Info] Die Lieferung aus dem Wald ist eingetroffen!");
				}
			}
			
			////////////////////////////////////////////////////////////////////////////////////////////////////
			//Lieferung Redstone
			private void redstone_delivery() {
				Location redstone1 = new Location (w,270,63,-1056);
				w.getBlockAt(redstone1).setType(Material.REDSTONE_WIRE);
				
				for(Player p : Variablen.beigetreten){
					p.sendMessage("[Info] Die Lieferung der Kabel ist eingetroffen!");
				}	
			}
			
			////////////////////////////////////////////////////////////////////////////////////////////////////
			//Lieferung Fäden
			private void string_delivery() {
				Location string1 = new Location (w,269,63,-1056);
				w.getBlockAt(string1).setType(Material.TRIPWIRE);
				
				for(Player p : Variablen.beigetreten){
					p.sendMessage("[Info] Die Lieferung der Steuerkabel ist eingetroffen!");
				}
			}
			
			////////////////////////////////////////////////////////////////////////////////////////////////////
			//Lieferung Steindruckplatten
			private void pressure_plate_delivery() {
				Location pressure_plate1 = new Location (w,268,63,-1056);
				w.getBlockAt(pressure_plate1).setType(Material.STONE_PRESSURE_PLATE);
				
				for(Player p : Variablen.beigetreten){
					p.sendMessage("[Info] Die Lieferung der Sensorplatten ist eingetroffen!");
				}
			}
			
			////////////////////////////////////////////////////////////////////////////////////////////////////
			//Checkt ob Location in ArrayList vorhanden ist
			
			private void loc_list_check() {
				World w = Bukkit.getServer().getWorld("CraftingCity_0.1");
				Location iron_1 = new Location(w, 272, 63, -1056);
				
				if(!Variablen.locs.contains(iron_1)){
					Variablen.locs.add(iron_1);
				}
			/*	if(!Variablen.locs.contains(iron_1)){
					Variablen.locs.add(iron_1);
				}
				if(!Variablen.locs.contains(iron_1)){
					Variablen.locs.add(iron_1);
				}
				if(!Variablen.locs.contains(iron_1)){
					Variablen.locs.add(iron_1);
				}
				if(!Variablen.locs.contains(iron_1)){
					Variablen.locs.add(iron_1);
				}
				if(!Variablen.locs.contains(iron_1)){
					Variablen.locs.add(iron_1);
				}
				*/
			}

			
		}, 0, 20*1);
		

		
	}

}
