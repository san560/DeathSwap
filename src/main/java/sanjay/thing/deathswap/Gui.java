package sanjay.thing.deathswap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Gui {



    public static Inventory createGui(String p1name){
        String invname = (p1name + " " + "has challenged you to deathswap");

        ItemStack item = new ItemStack(Material.GREEN_CONCRETE);
        ItemStack noitem = new ItemStack(Material.RED_CONCRETE);
        ItemMeta itemmeta = item.getItemMeta();
        ItemMeta noitemmeta = noitem.getItemMeta();
        itemmeta.setDisplayName("Yea lets gooo");
        noitemmeta.setDisplayName("Nah, bugger off");
        item.setItemMeta(itemmeta);
        noitem.setItemMeta(noitemmeta);
        Inventory inventory = Bukkit.createInventory(null,9,invname);
        inventory.setItem(0,item);
        inventory.setItem(8,noitem);
        return inventory;
    }
}
