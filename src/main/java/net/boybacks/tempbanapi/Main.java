package net.boybacks.tempbanapi;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

  public static Main main;

  @Override
  public void onEnable() {
    main = this;
  }

  public static ItemStack createItem(Material material, int amount, int data, String displayName) {
    ItemStack itemStack = new ItemStack(material, amount, (short) data);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(displayName);
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
}
