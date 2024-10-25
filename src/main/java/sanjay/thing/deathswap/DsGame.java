package sanjay.thing.deathswap;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

public class DsGame {
    public Player p1;
    public Player p2;
    public BukkitTask SwapTask;

    private int iterations = 0;



    public int SwapTime;

    public int GetIterations(){
        return iterations;
    }

    public int IncrementIterations(){
       if(iterations > 30){
           iterations = 0;
       }
        iterations++;
        return 0;
    }

    public void IntializeTask(){
        SwapTask = DsGameTaskFactory.CreateGameTask(this);
    }

    public DsGame(Player p1, Player p2, int swaptime) {
        this.p1 = p1;
        this.p2 = p2;
        this.SwapTask = null;
        this.SwapTime = swaptime;
    }
}
