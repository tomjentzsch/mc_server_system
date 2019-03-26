package de.dortom.main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class player_quit_Listener implements Listener {
	
	@EventHandler
	public void player_quit (PlayerQuitEvent e){
		
		e.setQuitMessage(null);
		
	}

}
