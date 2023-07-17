package me.tiie.woolwars;

import me.tiie.woolwars.game.Game;
import org.bukkit.plugin.java.JavaPlugin;

public final class WoolWars extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Game g = new Game();
        g.state;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
