package sanjay.thing.deathswap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DsCommandHandler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player p1 = (Player) sender;
            if(args.length == 0){
                p1.sendMessage(ChatColor.RED + "too few arguments");
            }

            else if (args.length == 1){
                String p2name = args[0];
                Player p2 = Bukkit.getServer().getPlayerExact(p2name);
                String p1name = p1.getName();
                if (p2 == null){
                    p1.sendMessage("[DeathSwap]" +"player is not online");
                    return false;
                }
                if(MainEventHandler.storage.IsGameRunning(p1name,p2name)){
                    p1.sendMessage("task already running");
                }
                // if(player == p1target){
                //   player.sendMessage("you cannot swap yourself");
                // }
                else {

                    p2.openInventory(Gui.createGui(p1name));


                    //player.sendMessage(p1name + ":" + String.valueOf(pos.getY()));
                    //player.sendMessage(playerName + ":" + String.valueOf(pos2.getY()));

                }


            }

            return true;
        }

        return false;
    }
}
