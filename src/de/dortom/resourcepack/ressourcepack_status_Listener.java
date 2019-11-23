package de.dortom.resourcepack;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent.Status;

import de.dortom.main.Main;

public class ressourcepack_status_Listener implements Listener {

	@EventHandler
	public void Player_Resource_Pack_Status(PlayerResourcePackStatusEvent e) {

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.main, new Runnable() {

			@Override
			public void run() {

				Player p = e.getPlayer();

				if (e.getStatus() == Status.ACCEPTED) {
				} else if (e.getStatus() == Status.DECLINED) {
					Kick_Player(p);
				} else if (e.getStatus() == Status.FAILED_DOWNLOAD) {
					p.sendMessage("Download des Texturen- u. Soundpaketes fehlgeschlagen!");
					Kick_Player(p);
				} else if (e.getStatus() == Status.SUCCESSFULLY_LOADED) {
					p.sendMessage("Das Texturen- u. Soundpaket wurde geladen!");
					p.setWalkSpeed(0.2F);
				}
			}
		}, 0);
	}

	// Kick aus PlayerResourcePackStatusEvent nicht moeglich
	// Deshalb über Runnable gekickt und Verzögert um Nachricht darzustellen

	private void Kick_Player(Player p) {

		try {
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.main, new Runnable() {

				@Override
				public void run() {
					p.kickPlayer(
							"Benutze bitte das Texturenpaket des Servers! Achte darauf das du es nicht schon vor dem Betreten des Servers deaktiviert hast!");
				}
			}, 20 * 1);
		} catch (Exception ex) {

		}
	}

}
