package sanjay.thing.deathswap;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

;

public class JoinAndLeaveEvents implements Listener {

    Main plugin;

    testcommand test;

    public JoinAndLeaveEvents(Main plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent event) {

        String pname = event.getPlayer().getName();
        event.setJoinMessage("§b§lWelcome" + " " + pname + " " + "to our server");

    }

    @EventHandler
    public void OnPlayerLeave(PlayerQuitEvent event) {

        String pnamee = event.getPlayer().getName();
        event.setQuitMessage("§4§l" + " " + pnamee + " " + "left our server");
    }

}