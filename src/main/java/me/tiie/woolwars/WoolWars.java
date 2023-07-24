package me.tiie.woolwars;

import me.tiie.woolwars.command.WoolWarsCommand;
import me.tiie.woolwars.game.Game;
import org.bukkit.plugin.java.JavaPlugin;

public final class WoolWars extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("woolwars").setExecutor(new WoolWarsCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
