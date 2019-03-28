package de.dortom.money;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.dortom.main.Main;
import de.dortom.main.Variablen;

public class Money_CE implements CommandExecutor {

	public Money_CE(Main main) {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		// Abfrage ob Spieler ein Konto hat gleichzeitig damit auch ob
		// Spieler existiert im try/catch
		// evtl. auslagern auf eigene Methode (Code bereinigen)

		Player p = (Player) sender;

		if (args.length == 0) {
			if (Main.main.money_file_cfg.contains(p.getUniqueId().toString())) {
				p.sendMessage("aktueller Kontostand: " + Money_methods.getmoney(p.getUniqueId()) + "§l€");
			} else {
				p.sendMessage("Du hast noch kein Bankkonto!");
			}

		} else if (args.length == 1) {
			if (args[0].equals("create")) {
				Money_methods.createmoney(p.getUniqueId().toString(), p);
			} else if (p.hasPermission("money.another")) {
				Player another = Bukkit.getServer().getPlayer(args[0]);
				try {
					UUID uuid_another = another.getUniqueId();
					if (Main.main.money_file_cfg.contains(uuid_another.toString())) {
						p.sendMessage(
								"aktueller Kontostand von " + (args[0]) + ": " + Money_methods.getmoney(uuid_another));
					} else {
						p.sendMessage(args[0] + " hat kein Bankkonto!");
					}
				} catch (Exception ex) {
					p.sendMessage("Spielername richtig?");
				}
			} else {
				p.sendMessage(Variablen.NoPermission);
			}

		} else if (args.length == 3) {

			if (args[0].equalsIgnoreCase("set")) {
				if (p.hasPermission("money.set")) {
					Player target = Bukkit.getServer().getPlayer(args[1]);
					try {
						UUID uuid_target = target.getUniqueId();
						if (Main.main.money_file_cfg.contains(uuid_target.toString())) {
							Double amount = Double.valueOf(args[2]);
							double rounded = Math.round(amount * 100.0D) / 100.0D;
							Money_methods.setmoney(uuid_target, rounded);
							p.sendMessage("Du hast " + target.getName() + " " + rounded + "€ gesetzt!");
							// Logs
							Main.main.money_log_cfg.set(Money_methods.printSimpleDateFormat(),
									p.getName() + " hat " + target.getName() + " " + rounded + " € gesetzt!");
							Main.main.money_log_cfg.save(Main.main.money_log_file);
						} else {
							p.sendMessage(args[1] + " hat kein Bankkonto!");
						}
					} catch (Exception ex) {
						p.sendMessage("Spielername richtig?");
					}
				} else {
					p.sendMessage(Variablen.NoPermission);
				}

			} else if (args[0].equalsIgnoreCase("add")) {
				if (p.hasPermission("money.add")) {
					Player target = Bukkit.getServer().getPlayer(args[1]);
					try {
						UUID uuid_target = target.getUniqueId();
						if (Main.main.money_file_cfg.contains(uuid_target.toString())) {
							Double amount = Double.valueOf(args[2]);
							double rounded = Math.round(amount * 100.0D) / 100.0D;
							Money_methods.addmoney(uuid_target, rounded);
							p.sendMessage("Geld erhalten");
							// Logs
							Main.main.money_log_cfg.set(Money_methods.printSimpleDateFormat(),
									p.getName() + " hat " + target.getName() + " " + rounded + " € hinzugefuegt!");
							Main.main.money_log_cfg.save(Main.main.money_log_file);
						} else {
							p.sendMessage(args[1] + " hat kein Bankkonto!");
						}
					} catch (Exception ex) {
						p.sendMessage("Spielername richtig?");
					}
				} else {
					p.sendMessage(Variablen.NoPermission);
				}

			} else if (args[0].equalsIgnoreCase("remove")) {
				if (p.hasPermission("money.remove")) {
					Player target = Bukkit.getServer().getPlayer(args[1]);
					try {
						UUID uuid_target = target.getUniqueId();
						if (Main.main.money_file_cfg.contains(uuid_target.toString())) {
							Double amount = Double.valueOf(args[2]);
							double rounded = Math.round(amount * 100.0D) / 100.0D;
							Money_methods.removemoney(uuid_target, rounded);
							p.sendMessage("Geld verloren");
							// Logs
							Main.main.money_log_cfg.set(Money_methods.printSimpleDateFormat(),
									p.getName() + " hat " + target.getName() + " " + rounded + " € abgezogen!");
							Main.main.money_log_cfg.save(Main.main.money_log_file);
						} else {
							p.sendMessage(args[1] + " hat kein Bankkonto!");
						}
					} catch (Exception ex) {
						p.sendMessage("Spielername richtig?");
					}
				} else {
					p.sendMessage(Variablen.NoPermission);
				}

			} else if (args[0].equalsIgnoreCase("pay")) {
				if (p.hasPermission("money.pay")) {
					Player target = Bukkit.getServer().getPlayer(args[1]);
					try {
						UUID uuid_target = target.getUniqueId();
						if (Main.main.money_file_cfg.contains(uuid_target.toString())
								&& Main.main.money_file_cfg.contains(p.getUniqueId().toString())) {
							Double amount = Double.valueOf(args[2]);
							double rounded = Math.round(amount * 100.0D) / 100.0D;
							if (uuid_target == p.getUniqueId()) {
								p.sendMessage("Du kannst an dich selbst kein Geld senden!");
							} else {
								Money_methods.paymoney(p.getUniqueId(), uuid_target, rounded);
								// Logs
								Main.main.money_log_cfg.set(Money_methods.printSimpleDateFormat(),
										p.getName() + " hat " + target.getName() + " " + rounded + " € ueberwiesen!");
								Main.main.money_log_cfg.save(Main.main.money_log_file);
							}
						} else {
							p.sendMessage(args[1] + " hat kein Bankkonto!");
						}
					} catch (Exception ex) {
						p.sendMessage("Spielername richtig?");
					}
				} else {
					p.sendMessage(Variablen.NoPermission);
				}
			}

		} else {
			p.sendMessage("Der Befehl wurde falsch genutzt!");
		}

		return true;
	}

}
