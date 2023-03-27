package net.boybacks.tempbanapi;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Main extends JavaPlugin {

  public static Main INSTANCE;
  private BufferedReader in;
  private Bans bans;

  @Override
  public void onEnable() {
    INSTANCE = this;
    this.bans = new Bans(this);

    //this.getCommand("tempban").setExecutor(new BanCommand());
    Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(), this);
  }

  public static Main getInstance() {
    return INSTANCE;
  }

  public Bans getBans() {
    return bans;
  }
}
