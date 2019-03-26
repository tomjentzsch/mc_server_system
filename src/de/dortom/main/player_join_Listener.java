package de.dortom.main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

//import de.dortom.scoreboard.scoreboard_timer;

public class player_join_Listener implements Listener {

	@EventHandler
	public void player_join(PlayerJoinEvent e) {

		Player p = e.getPlayer();

//		scoreboard_timer.create_board(p);

		p.sendTitle("ß2Hallo " + p.getPlayer().getName() + "!", "ßfViel Spaﬂ beim bauen!", 20, 50, 20);

	}

}
