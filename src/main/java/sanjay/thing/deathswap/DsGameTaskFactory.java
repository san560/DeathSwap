package sanjay.thing.deathswap;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;


public class DsGameTaskFactory {

    public static BukkitTask CreateGameTask(DsGame game){
        return new BukkitRunnable() {
            @Override
            public void run() {

                if(game.GetIterations() == 29){
                    game.p1.sendMessage("§c§[DeathSwap]" +"you will be swapped in 10 seconds");
                    game.p2.sendMessage("§c§[DeathSwap]" +"you will be swapped in 10 seconds");
                } else if(game.GetIterations() == 30){
                    Location pos = game.p2.getLocation();

                    Location pos2 = game.p1.getLocation();

                    Location newLocation = new Location(
                            pos.getWorld(),
                            pos.getX(),
                            pos.getY(),
                            pos.getZ(),
                            pos.getYaw(),
                            pos.getPitch()
                    );
                    Location newLocation2 = new Location(
                            pos2.getWorld(),
                            pos2.getX(),
                            pos2.getY(),
                            pos2.getZ(),
                            pos2.getYaw(),
                            pos2.getPitch()
                    );
                    game.p1.teleport(newLocation);
                    game.p2.teleport(newLocation2);
                    game.p1.sendMessage("§c§[DeathSwap]" +"§c§lyou have been swapped");
                    game.p2.sendMessage("§c§[DeathSwap]" +"§c§lyou have been swapped");

            }
                game.IncrementIterations();
            }
        }.runTaskTimer(Main.getPlugin(Main.class), 20,  200);

    }
}
