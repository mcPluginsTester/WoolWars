package me.tiie.woolwars.command;

import me.tiie.woolwars.utls.PlayerInventoryRestorer;
import me.tiie.woolwars.utls.PlayerInventorySaver;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LobbyCommands {

    public static boolean handleLobbyCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            PlayerInventoryRestorer inventoryRestorer = new PlayerInventoryRestorer();
            PlayerInventorySaver inventorySaver = new PlayerInventorySaver();
            String dataFolder = "plugins/StaffToolsNew/playerdata/data/folder";



            inventorySaver.saveInventoryToFile(player,dataFolder);
            player.setInvulnerable(true);

            player.sendMessage(ChatColor.GREEN + "Successfully Joined");
           /* if (isInventoryEmpty(player)) {
                player.sendMessage("EMPTY");

            } else {
                player.sendMessage("NOT EMPTY");
            }
        } else {*/
            // TODO: handle error message
        }

        return false;
    }

    private static boolean isInventoryEmpty(Player p) {
        return p.getInventory().isEmpty();

    }
}
