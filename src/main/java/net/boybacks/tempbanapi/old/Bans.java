//package net.boybacks.tempbanapi.old;
//
//import org.bukkit.configuration.file.YamlConfiguration;
//import org.bukkit.entity.Player;
//import org.bukkit.plugin.Plugin;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.TimeZone;
//
//public class Bans {
//
//  private File file;
//  private YamlConfiguration cfg;
//
//  private Plugin plugin;
//
//  public Bans(Plugin plugin) {
//    this.plugin = plugin;
//    file = new File("plugins/" + plugin.getName() + "/bans.yml");
//    cfg = YamlConfiguration.loadConfiguration(file);
//
//    try {
//      if(!file.exists()) {
//        file.createNewFile();
//      }
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//
//  public void ban(String uuid, String reason, long seconds) {
//    if(isBanned(uuid)) {
//      return;
//    }
//    long time = 0;
//    long current = System.currentTimeMillis();
//    long millis = seconds*1000;
//    time = current + millis;
//
//    if(seconds == -1) {
//      time = -1;
//    }
//
//    cfg.set("Bans." + uuid + ".time", time);
//    cfg.set("Bans." + uuid + ".reason", reason);
//    saveFile();
//  }
//
//  public void sendBanScreen(Player p) {
//    p.kickPlayer("§cYou have been banned!\n\n" +
//        "§7Reason: §c" + getReason(p.getUniqueId().toString()) + "\n\n" +
//        "§7Unban date: §c" + getUnbanDate(p.getUniqueId().toString()));
//  }
//
//  public String getReason(String uuid) {
//    return cfg.getString("Bans." + uuid + ".reason");
//  }
//
//
//  public String getUnbanDate(String uuid) {
//    long time = cfg.getLong("Bans." + uuid + ".time");
//    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
//    sdf.setTimeZone(TimeZone.getTimeZone("Europe/Warsaw"));
//    Date date = new Date(time);
//    return sdf.format(date);
//  }
//
//  public void unban(String uuid) {
//    cfg.set("Bans." + uuid + ".time", null);
//    cfg.set("Bans." + uuid + ".reason", null);
//    saveFile();
//  }
//
//  public long getBanMillis(String uuid) {
//    return cfg.getLong("Bans." + uuid + ".time");
//  }
//
//  public boolean isBanned(String uuid) {
//    return cfg.getString("Bans." + uuid + ".reason") != null;
//  }
//
//  public void saveFile() {
//    try {
//      cfg.save(file);
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//}
