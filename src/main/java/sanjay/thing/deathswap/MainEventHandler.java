package sanjay.thing.deathswap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MainEventHandler implements Listener {

    Main plugin;
    public static GameStorage storage = new GameStorage();
    public MainEventHandler(Main plugin){
        this.plugin = plugin;
    }
    

    @EventHandler
    public void OnPlayerClickInv(InventoryClickEvent e){
        Player p2 = (Player) e.getWhoClicked();
        //p2.sendMessage("§c§[DeathSwap]" + "you have accepted");
        System.out.println("test");
        String[] words = e.getView().getTitle().split(" ");
        if(words.length != 6){
            return;
        }
        String p1name = words[0];
        Player p1 = Bukkit.getServer().getPlayerExact(p1name);
        if(p1 == null){
            p2.sendMessage("§c§[DeathSwap]" +p1name + " abandoned the game, what a fucking pussy");
            return;
        }

        int slot = e.getSlot();
        System.out.println(slot);
        if(slot == 0){
            p2.closeInventory();
            p1.sendMessage("§c§[DeathSwap]" +"§c§lThe deathswap game has started! GO GO GO!");
            p2.sendMessage("§c§[DeathSwap]" +"§c§lThe deathswap game has started! GO GO GO!");



            p2.sendMessage("you have agreed");
            p2.playSound(p2.getEyeLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 6f, 6f);
            MainEventHandler.storage.CreateGame(p1,p2,100);
        }if(slot == 8){
            p2.closeInventory();
            return;
        }
        e.setCancelled(true);
    }

    @EventHandler
    public void OnPlayerdie(PlayerDeathEvent event) {
        Player p = event.getEntity().getPlayer();
        storage.EndGame(p);
    }
}

