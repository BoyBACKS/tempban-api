//package net.boybacks.tempbanapi.old;
//
//import org.bukkit.plugin.java.JavaPlugin;
//
//import java.io.BufferedReader;
//
//public class Main extends JavaPlugin {
//
//  public static Main INSTANCE;
//  private BufferedReader in;
//  private Bans bans;
//
//  @Override
//  public void onEnable() {
//    INSTANCE = this;
//    this.bans = new Bans(this);
//  }
//
//  public static Main getInstance() {
//    return INSTANCE;
//  }
//
//  public Bans getBans() {
//    return bans;
//  }
//}
