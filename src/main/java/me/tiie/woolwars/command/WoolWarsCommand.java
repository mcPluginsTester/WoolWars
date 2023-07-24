package me.tiie.woolwars.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class WoolWarsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (args.length == 1 && args[0].equalsIgnoreCase("join")){
            return LobbyCommands.handleLobbyCommand(commandSender, command, s, args);
        }
        return false;


    }
}
