package net.boybacks.tempbanapi;

import net.boybacks.releaseschecker.ReleaseChecker;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.UUID;

public class TempBan extends JavaPlugin {

  private static TempBan tempBanInstance;

  private static File file;
  private static YamlConfiguration cfg;

  private static String banScreen;

  @Override
  public void onEnable() {
    tempBanInstance = this;
    //    Plugin plugin = this;
    //
    //    ReleaseChecker.getVersion("v1.0");
    //    ReleaseChecker.getRepository("boybacks", "releasesChecker-api");
    //    if (!ReleaseChecker.releaseCheck()) {
    //      System.out.println(ChatColor.RED + "\n\nThere is new version of that api! Update now!\n");
    //      TempBan.getInstance().getPluginLoader().disablePlugin(plugin);
    //    }
  }

  public static void banPlayer(Player player, String reason, long seconds) {
    String uuid = String.valueOf(player.getUniqueId());
    if (isBanned(uuid)) {
      return;
    }
    long time = 0;
    long current = System.currentTimeMillis();
    long millis = seconds * 1000;
    time = current + millis;

    if (seconds == -1) {
      time = -1;
    }

    cfg.set("Bans." + uuid + ".time", time);
    cfg.set("Bans." + uuid + ".reason", reason);
    saveBansFile();
  }

  public static void unbanPlayer(Player player) {
    String uuid = String.valueOf(player.getUniqueId());
    cfg.set("Bans." + uuid + ".time", null);
    cfg.set("Bans." + uuid + ".reason", null);
    saveBansFile();
  }

  public static String setBanScreen(String banScreen) {
    return banScreen;
  }

  public static void sendBanScreen(Player player) {
    if (banScreen == null) {
      player.kickPlayer("§cYou have been banned!\n\n" + "§7Reason: §c" + getReason(player.getUniqueId().toString()) + "\n\n" + "§7Unban date: §c" + getUnbanDate(player.getUniqueId().toString()));
      return;
    }
    player.kickPlayer(banScreen.replace("%reason%", getReason(player.getUniqueId().toString())).replace("%unban-date%", getUnbanDate(player.getUniqueId().toString())));
  }

  public static String getReason(Player player) {
    String uuid = String.valueOf(player.getUniqueId());
    return cfg.getString("Bans." + uuid + ".reason");
  }

  public static String getUnbanDate(Player player) {
    String uuid = String.valueOf(player.getUniqueId());
    long time = cfg.getLong("Bans." + uuid + ".time");
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    sdf.setTimeZone(TimeZone.getTimeZone("Europe/Warsaw"));
    Date date = new Date(time);
    return sdf.format(date);
  }

  public static boolean isBanned(Player player) {
    String uuid = String.valueOf(player.getUniqueId());
    return cfg.getString("Bans." + uuid + ".reason") != null;
  }

  public static long getBanTime(Player player) {
    String uuid = String.valueOf(player.getUniqueId());
    return cfg.getLong("Bans." + uuid + ".time");
  }

  public static void saveBansFile() {
    try {
      cfg.save(file);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //API METHODS
  private static String getReason(String uuid) {
    return cfg.getString("Bans." + uuid + ".reason");
  }

  private static String getUnbanDate(String uuid) {
    long time = cfg.getLong("Bans." + uuid + ".time");
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    sdf.setTimeZone(TimeZone.getTimeZone("Europe/Warsaw"));
    Date date = new Date(time);
    return sdf.format(date);
  }

  private static boolean isBanned(String uuid) {
    return cfg.getString("Bans." + uuid + ".reason") != null;
  }
}
