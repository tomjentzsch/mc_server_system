package de.dortom.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.dortom.main.Main;

public class Gamemode_CE implements CommandExecutor {

	public Gamemode_CE(Main main) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Player p = (Player) sender;

		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("0")) {
				p.setGameMode(GameMode.ADVENTURE);
				p.sendMessage("Dein Gamemode wurde zu Adventure geändert!");
			} else if (args[0].equalsIgnoreCase("1")) {
				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage("Dein Gamemode wurde zu Kreativ geändert!");
			} else {
				p.sendMessage("");
			}
		}

		return true;
	}

}
