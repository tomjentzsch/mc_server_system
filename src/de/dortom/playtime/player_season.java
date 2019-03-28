package de.dortom.playtime;

import java.io.IOException;
import java.text.DecimalFormat;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.dortom.main.Main;

public class player_season{

	public player_season() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	public void player_season_timer() {

		Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.main, new Runnable() {

			@Override
			public void run() {

				for (Player p : Bukkit.getOnlinePlayers()) {
					int stunden = Main.main.player_season_cfg.getInt(p.getUniqueId().toString() + ".stunden");
					int minuten = Main.main.player_season_cfg.getInt(p.getUniqueId().toString() + ".minuten");

					minuten++;

					Main.main.player_season_cfg.set(p.getUniqueId().toString() + ".minuten", minuten);

					try {
						Main.main.player_season_cfg.save(Main.main.player_season_file);
					} catch (IOException e) {
						e.printStackTrace();
					}

					if (minuten == 60) {

						Main.main.player_season_cfg.set(p.getUniqueId().toString() + ".minuten", 0);
						stunden++;
						Main.main.player_season_cfg.set(p.getUniqueId().toString() + ".stunden", stunden);
						try {
							Main.main.player_season_cfg.save(Main.main.player_season_file);
						} catch (IOException e) {
							e.printStackTrace();
						}

						// Payday

						DecimalFormat f = new DecimalFormat("#0.00");

						double steuern = 0.0;
						double konto = Main.main.money_file_cfg.getDouble(p.getUniqueId() + ".money");
						double zinssatz = 0.0;
						double zinsen = konto * zinssatz / 100;
						double neukonto = konto + zinsen - steuern;

						p.sendMessage("<< PAYDAY >>");
						p.sendMessage("Zinsen: " + (f.format(zinsen)) + "€");
						p.sendMessage("Steuern: " + (f.format(steuern)) + "€");
						p.sendMessage("neuer Kontostand: " + (f.format(neukonto)) + "€");

						// Berechnung?!

					}
				}
			}
		}, 20 * 1, 20 * 60);

	}

}
