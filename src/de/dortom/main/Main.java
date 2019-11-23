package de.dortom.main;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.dortom.adminpanel.Admin_CE;
import de.dortom.adminpanel.adminpanel_inventory_click_Listener;
import de.dortom.commands.Gamemode_CE;
import de.dortom.garage.Garage_CE;
import de.dortom.garage.garage_Inventory_click_Listener;
import de.dortom.garage.garage_sign_Listener;
import de.dortom.money.Money_CE;
import de.dortom.playtime.player_season;
import de.dortom.resourcepack.ressourcepack_status_Listener;
import de.dortom.schienenwerk.Dienst_CE;
import de.dortom.schienenwerk.block_break_Listener;
import de.dortom.schienenwerk.craft_item_Listener;
import de.dortom.schienenwerk.delivery;
import de.dortom.schienenwerk.drop_item_Listener;
import de.dortom.schienenwerk.furnace_burn_Listener;
import de.dortom.schienenwerk.geben_CE;
import de.dortom.schienenwerk.inventory_click_Listener;
import de.dortom.schienenwerk.player_interact_Listener;
import de.dortom.scoreboard.scoreboard_timer;

public class Main extends JavaPlugin {

	public static Main main;

	// public (Klassenname) (cd_...) -> Verbindung zur onEnable Methode dort
	// Klassenname eingetragen und über Main.main Klassenaufruf mit
	// Methodenaufruf
	public player_season cd_player_playtime;
	public delivery cd_delivery;
	public scoreboard_timer cd_scoreboard;

	// Files
	public File money_file = new File("plugins/CraftingCity", "money.yml");
	public FileConfiguration money_file_cfg = YamlConfiguration.loadConfiguration(money_file);

	public File money_log_file = new File("plugins/CraftingCity", "money_log.yml");
	public FileConfiguration money_log_cfg = YamlConfiguration.loadConfiguration(money_log_file);

	public File player_season_file = new File("plugins/CraftingCity", "player_season.yml");
	public FileConfiguration player_season_cfg = YamlConfiguration.loadConfiguration(player_season_file);

	public File location_file = new File("plugins/CraftingCity", "schienenwerk_locations.yml");
	public FileConfiguration location_file_cfg = YamlConfiguration.loadConfiguration(location_file);

	public File garage_file = new File("plugins/CraftingCity", "garage.yml");
	public FileConfiguration garage_cfg = YamlConfiguration.loadConfiguration(garage_file);

	/////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void onDisable() {
		System.out.println("[Plugin] erfolgreich deaktiviert!");
	}

	@Override
	public void onEnable() {

		Main.main = this;
		registerEvents();

		// filechecks
		money_file_check();

		// Spielzeit / Payday
		cd_player_playtime = new player_season();
		Main.main.cd_player_playtime.player_season_timer();

		// Schienenwerk
		cd_delivery = new delivery();
		Main.main.cd_delivery.delivery_items();

		// Scoreboard
		// cd_scoreboard = new scoreboard_timer();
		// Main.main.cd_scoreboard.board_timer();

		this.getCommand("dienst").setExecutor(new Dienst_CE(this));
		this.getCommand("geben").setExecutor(new geben_CE(this));
		this.getCommand("admin").setExecutor(new Admin_CE(this));
		this.getCommand("money").setExecutor(new Money_CE(this));
		this.getCommand("garage").setExecutor(new Garage_CE(this));
		this.getCommand("gamemode").setExecutor(new Gamemode_CE(this));

		System.out.println("[Plugin] erfolgreich aktiviert!");

	}

	public void registerEvents() {

		PluginManager pm = getServer().getPluginManager();
		// Resourcenpack
		pm.registerEvents(new ressourcepack_status_Listener(), this);

		// Adminpanel
		pm.registerEvents(new adminpanel_inventory_click_Listener(), this);

		// Schienenwerk
		pm.registerEvents(new furnace_burn_Listener(), this);
		pm.registerEvents(new craft_item_Listener(), this);
		pm.registerEvents(new player_join_Listener(), this);
		pm.registerEvents(new player_quit_Listener(), this);
		pm.registerEvents(new player_quit_Listener(), this);
		pm.registerEvents(new drop_item_Listener(), this);
		pm.registerEvents(new player_interact_Listener(), this);
		pm.registerEvents(new inventory_click_Listener(), this);
		pm.registerEvents(new block_break_Listener(), this);
		pm.registerEvents(new chat_Listener(), this);

		//
		pm.registerEvents(new garage_sign_Listener(), this);
		pm.registerEvents(new garage_Inventory_click_Listener(), this);

	}

	private void money_file_check() {

		// ergänzt wegen Kurs zum testen!!!

		File money_file_test = new File("plugins/CraftingCity/money.yml");

		if (money_file_test.exists()) {

			System.out.println("[Filecheck] 'money.yml' gefunden!");
		} else {
			try {
				money_file_cfg.save(money_file);
				System.out.println("[Filecheck] 'money.yml' wurde neu erstellt!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// private void player_season_file_check() {
	// if (new File("plugins/CraftingCity/player_season.yml").exists()) {
	// System.out.println("[Filecheck] 'player_season.yml' gefunden!");
	// } else {
	// System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	// System.out.println("[Filecheck] 'player_season.yml' nicht gefunden!");
	// System.out.println("[Hinweis] File manuell erstellen oder aus Backup
	// einspielen!");
	// System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	// }
	// }
	//
	// private void schienenwerk_locations_file_check() {
	// if (new File("plugins/CraftingCity/schienenwerk_locations.yml").exists())
	// {
	// System.out.println("[Filecheck] 'schienenwerk_locations.yml' gefunden!");
	// } else {
	// System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	// System.out.println("[Filecheck] 'schienenwerk_locations.yml' nicht
	// gefunden!");
	// System.out.println("[Hinweis] File manuell erstellen oder aus Backup
	// einspielen!");
	// System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	// }
	// }
	//
	// private void garage_file_check() {
	// if (new File("plugins/CraftingCity/garage.yml").exists()) {
	// System.out.println("[Filecheck] 'garage.yml' gefunden!");
	// } else {
	// System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	// System.out.println("[Filecheck] 'garage.yml' nicht gefunden!");
	// System.out.println("[Hinweis] File manuell erstellen oder aus Backup
	// einspielen!");
	// System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	// }
	// }
	//
	// private void messages_file_check() {
	// File f = new File("plugins/CraftingCity/messages.yml");
	// if (new File("plugins/CraftingCity/messages.yml").exists()) {
	// System.out.println("Messages.yml vorhanden!");
	// } else {
	// try {
	// f.createNewFile();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// System.out.println("File wurde erstellt!");
	// }
	// }

}
