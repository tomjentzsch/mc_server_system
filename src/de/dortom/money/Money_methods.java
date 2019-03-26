package de.dortom.money;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.bukkit.entity.Player;

import de.dortom.main.Main;

public class Money_methods {

	public static Double getmoney(UUID uuid) {

		double money = Main.main.money_cfg.getDouble(uuid + ".money");
		return money;
	}

	public static void setmoney(UUID uuid, double amount) {

		double rounded_amount = Math.round(amount * 100.0D) / 100.0D;
		Main.main.money_cfg.set(uuid + ".money", rounded_amount);
		try {
			Main.main.money_cfg.save(Main.main.money_file);
		} catch (IOException e) {
		}
	}

	public static void addmoney(UUID uuid, double amount) {

		double money = Main.main.money_cfg.getDouble((uuid + ".money"));
		double rounded_amount = Math.round(amount * 100.0D) / 100.0D;
		money = money + rounded_amount;
		Main.main.money_cfg.set(uuid + ".money", money);
		try {
			Main.main.money_cfg.save(Main.main.money_file);
		} catch (IOException e) {
		}
	}

	public static void removemoney(UUID uuid, double amount) {

		double money = Main.main.money_cfg.getDouble(uuid + ".money");
		double rounded_amount = Math.round(amount * 100.0D) / 100.0D;
		money = money - rounded_amount;
		Main.main.money_cfg.set(uuid + ".money", money);
		try {
			Main.main.money_cfg.save(Main.main.money_file);
		} catch (IOException e) {
		}
	}

	public static void paymoney(UUID uuid_sender, UUID uuid_target, double amount) {

		double money_target = Main.main.money_cfg.getDouble(uuid_target + ".money");
		double money_sender = Main.main.money_cfg.getDouble(uuid_sender + ".money");
		double rounded_amount = Math.round(amount * 100.0D) / 100.0D;

		if (rounded_amount > money_sender) {
			System.out.println("Betrugsversuch! So viel Geld hast du nicht!");
			return;
		} else if (rounded_amount < money_sender) {

			money_target = money_target + rounded_amount;
			money_sender = money_sender - rounded_amount;

			double money_target_rounded = Math.round(money_target * 100.0D) / 100.0D;
			double money_sender_rounded = Math.round(money_sender * 100.0D) / 100.0D;

			Main.main.money_cfg.set(uuid_sender + ".money", money_sender_rounded);
			Main.main.money_cfg.set(uuid_target + ".money", money_target_rounded);

			try {
				Main.main.money_cfg.save(Main.main.money_file);
			} catch (IOException e) {
			}
		} else {
			System.out.println("Transaktion nicht möglich!");
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public static void createmoney(String uuid, Player p) {

		if (!Main.main.money_cfg.contains(uuid)) {
			Main.main.money_cfg.set(uuid + ".money", 250);
			try {
				Main.main.money_cfg.save(Main.main.money_file);
			} catch (IOException e) {
			}
		} else {
			p.sendMessage("Du hast bereits ein Konto!");
		}

	}

	// optional falls nochmal benötigt auslagern und auf public aendern!

	public static String printSimpleDateFormat() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd - HH:mm:ss ");
		Date currentTime = new Date();
		return formatter.format(currentTime);// 2012.04.14 - 21:34:07
	}

}
