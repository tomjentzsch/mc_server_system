package de.dortom.schienenwerk;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.dortom.main.Main;

public class geben_CE implements CommandExecutor {

	public geben_CE(Main main) {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		
		String burn_name = (ChatColor.AQUA + "Industriekohle - Schienenwerk");
		
		ItemStack item_burn = new ItemStack(Material.COAL);
		ItemMeta meta_burn = item_burn.getItemMeta();
		meta_burn.setDisplayName(burn_name);
		item_burn.setItemMeta(meta_burn);
		
		ItemStack item_furnice = new ItemStack(Material.FURNACE);
		ItemMeta meta_furnice = item_furnice.getItemMeta();
		meta_furnice.setDisplayName("Produktionsofen - 1");
		item_furnice.setItemMeta(meta_furnice);
		
////////////////////////////////////////////////////////////////////////////////////
		
		// Test für Garage entfernen!!!!!!!!
		
		if(cmd.getName().equalsIgnoreCase("geben")){
			if(args[0].equalsIgnoreCase("Kohle")){
				p.getInventory().setItem(1, item_burn);
				p.sendMessage("Teil gegeben!");
				
				//Test für TPack
				
				String songname = "kawumm";

				final String soundArg = songname;
				final String soundArg1 = "kawumm";

				p.playSound(p.getLocation(), soundArg, 3.0F, 1F);
				p.playSound(p.getLocation(), soundArg1, 3.0F, 1F);
				
				
			}else if(args[0].equalsIgnoreCase("Ofen")){
				Main.main.garage_cfg.set("Garage_1" + ".status", "");
				Main.main.garage_cfg.set("Garage_1" + ".uuid", "");
				try {
					Main.main.garage_cfg.save(Main.main.garage_file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return false;
	}

}
