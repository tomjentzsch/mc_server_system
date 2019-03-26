package de.dortom.schienenwerk;

import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.dortom.main.Main;
import de.dortom.main.Variablen;

public class Dienst_CE implements CommandExecutor {

	public Dienst_CE(Main main) {

	}
	
	private HashMap <Player, ItemStack[]> Inv_before_job = new HashMap<>();	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;
		
		ItemStack panel = new ItemStack(Material.BOOK);
		ItemMeta p_m = panel.getItemMeta();
		p_m.setDisplayName(Variablen.bedienpanel);
		panel.setItemMeta(p_m);
		
		if(cmd.getName().equalsIgnoreCase("dienst")){
			if(args.length == 1){
				if(args[0].equalsIgnoreCase("antreten")){
					if(!Variablen.beigetreten.contains(p)){
						Variablen.beigetreten.add(p);
						Inv_before_job.put(p,p.getInventory().getContents());
						p.getInventory().clear();
						p.sendMessage("Du hast den Dienst angetreten!");
						p.sendMessage("Dein Inventar wird beim beenden des Dienstes geleert!");
						p.getInventory().setItem(8, panel);
					}else{
						p.sendMessage("Du hast den Dienst bereits angetreten!");
					}
				}else if(args[0].equalsIgnoreCase("beenden")){
					if(Variablen.beigetreten.contains(p)){
						Variablen.beigetreten.remove(p);
						p.getInventory().clear();
						p.getInventory().setContents(Inv_before_job.get(p));
						p.sendMessage("Du hast den Dienst beendet!");
					}else{
						p.sendMessage("Du hast den Dienst bereits beendet!");
					}
				}
			}else{
				p.sendMessage("/dienst [antreten/beenden]");
			}
		}
		return true;
	}

}
