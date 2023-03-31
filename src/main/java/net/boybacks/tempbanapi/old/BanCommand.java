package net.boybacks.tempbanapi.old;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

//public class BanCommand implements CommandExecutor {
//
//  @Override
//  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
//    if (sender instanceof Player) {
//      Player player = (Player) sender;
//
//      if(player.hasPermission("bans.tempban")) {
//
//        if (args.length >= 4) {
//          String name = args[0];
//          UUID uuid = Bukkit.getPlayer(args[0]).getUniqueId();
//
//          if (Main.getInstance().getBans().isBanned(String.valueOf(uuid))) {
//            player.sendMessage("§cThis player is already banned.");
//            return true;
//          }
//
//          long value = 0;
//          try {
//            value = Integer.valueOf(args[1]);
//          } catch (NumberFormatException e) {
//            player.sendMessage("§cPlease enter a number at <Value>");
//          }
//
//          String unitString = args[2];
//          String reason = "";
//          for (int i = 3; i < args.length; i++) {
//            reason += args[i] + " ";
//          }
//
//          List<String> unitList = TimeUnits.getUnitsAsString();
//          if (unitList.contains(unitString.toLowerCase())) {
//
//            TimeUnits unit = TimeUnits.getUnit(unitString);
//            long seconds = value * unit.getToSecond();
//            Main.getInstance().getBans().ban(String.valueOf(uuid), reason, seconds);
//            player.sendMessage("§7" + name + " has been banned for " + value + " " + unit.getName() + "!");
//
//            if(Bukkit.getPlayer(name) != null) {
//              Main.getInstance().getBans().sendBanScreen(Bukkit.getPlayer(name));
//            }
//          }
//        } else {
//          player.sendMessage("§7Use: §b/tempban <Name> <Value> <BanUnit>");
//        }
//
//      } else {
//        player.sendMessage("§cNo permissions.");
//      }
//
//    } else {
//      sender.sendMessage("§cYou need to be a player to use this command!");
//    }
//    return false;
//  }
//}
