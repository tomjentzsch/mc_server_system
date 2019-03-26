package de.dortom.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Variablen {

	public Variablen(Main main) {
	}

	// Schienenwerk
	public static ArrayList<Location> locs = new ArrayList<Location>();
	public static ArrayList<Player> beigetreten = new ArrayList<Player>();
	public static String bedienpanel = "§3Bedienpanel";

	// Adminpanel
	public static Inventory adminpanel = Bukkit.createInventory(null, 9, "Adminpanel");
	public static Inventory flyspeed_inv = Bukkit.createInventory(null, 9, "Flyspeed");
	
	public static String NoPermission = "Du hast keine Rechte um diesen Befehl zu nutzen!";
	
	//Garagen
	public static String garagen_inv = "Garagen";

}
