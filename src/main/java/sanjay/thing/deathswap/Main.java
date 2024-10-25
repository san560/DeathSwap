package sanjay.thing.deathswap;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        System.out.println("Deathswap plugin is working :D VERSION 2");
        getServer().getPluginManager().registerEvents(new JoinAndLeaveEvents(this), this);
        getServer().getPluginManager().registerEvents(new MainEventHandler(this), this);
        getCommand("ds").setExecutor((CommandExecutor)new DsCommandHandler());
        getCommand("tesst").setExecutor((CommandExecutor)new testcommand());


    }
}