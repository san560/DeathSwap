package sanjay.thing.deathswap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GameStorage {
    public static List<DsGame> storage = new ArrayList<DsGame>();

    public void CreateGame(Player p1, Player p2, int swaptime){
        DsGame game = new DsGame(p1,p2,swaptime);
        game.IntializeTask();
        storage.add(game);
    }
    public boolean IsGameRunning(String p1name, String p2name){
        for (DsGame game:storage){
            if(game.p1.getName().equals(p1name) || game.p1.getName().equals(p2name)) {
                return true;
            }
            if(game.p2.getName().equals(p1name) || game.p2.getName().equals(p2name)) {
                return true;
            }
        }
        return false;
    }
    public void EndGame(Player dead){
        for (DsGame game:storage){
            if((game.p1.getName().equals(dead.getName()) || game.p2.getName().equals(dead.getName()))) {
                int x = game.SwapTask.getTaskId();
                boolean y = Bukkit.getServer().getScheduler().isCurrentlyRunning(x);
                if(!game.SwapTask.isCancelled()){
                    Main.getPlugin(Main.class).getServer().getScheduler().cancelTask(x);
                    if (game.p1.getName().equals(dead.getName())) {
                        game.p2.sendMessage("§c§[DeathSwap]" +"player 1 died, what a loser");
                    } else{
                        game.p1.sendMessage("§c§[DeathSwap]" +"Player 2 died, what a loser");
                    }
                    storage.remove(game);
                    break;
                }
            }

        }

    }
}
