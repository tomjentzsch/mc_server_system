package de.dortom.main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chat_Listener implements Listener {

	@EventHandler
	public void OnPrefixChat(AsyncPlayerChatEvent e) {

		Player p = e.getPlayer();
		String msg = e.getMessage();

		String Owner = "&f[&4Owner&f]";
		Owner = Owner.replace("&", "§");
		String Admin = "&f[&cAdmin&f]";
		Admin = Admin.replace("&", "§");
		String Builder = "&f[&3Builder&f]";
		Builder = Builder.replace("&", "§");

		if (p.hasPermission("Prefix.Owner")) {
			e.setFormat(Owner + " ● " + p.getName() + "§8 : §f" + msg);

		} else if (p.hasPermission("Prefix.Admin")) {
			e.setFormat(Admin + " ● " + p.getName() + "§8 : §f" + msg);

		} else if (p.hasPermission("Prefix.Builder")) {
			e.setFormat(Builder + " ● " + p.getName() + "§8 : §f" + msg);

		}

	}

}
