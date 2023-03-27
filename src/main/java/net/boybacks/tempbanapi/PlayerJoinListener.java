package net.boybacks.tempbanapi;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;

//public class PlayerJoinListener implements Listener {
//
//  @EventHandler
//  public void onPlayerJoinEvent(PlayerJoinEvent event) {
//    Player player = event.getPlayer();
//
//    BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
//    scheduler.scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
//      @Override
//      public void run() {
//        if(Main.getInstance().getBans().isBanned(player.getUniqueId().toString())) {
//          if(Main.getInstance().getBans().getBanMillis(player.getUniqueId().toString()) <= System.currentTimeMillis()) {
//            Main.getInstance().getBans().unban(player.getUniqueId().toString());
//          } else {
//            Main.getInstance().getBans().sendBanScreen(player);
//          }
//        }
//      }
//    }, 5);
//  }
//}
