package me.tiie.woolwars.utls;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.io.File;
import java.io.IOException;

public class PlayerInventorySaver {

    public void saveInventoryToFile(Player player, String dataFolder) {
        // Get the player's inventory
        PlayerInventory playerInventory = player.getInventory();

        // Create a new YamlConfiguration to save the data to a file
        YamlConfiguration config = new YamlConfiguration();

        // Store the inventory contents in the ConfigurationSection
        ConfigurationSection inventorySection = config.createSection("player_inventory");
        for (int i = 0; i < playerInventory.getSize(); i++) {
            ItemStack itemStack = playerInventory.getItem(i);
            if (itemStack != null) {
                inventorySection.set(Integer.toString(i), itemStack.serialize());
            }
        }

        // Create a folder for the player's data if it doesn't exist
        File playerDataFolder = new File(dataFolder, player.getUniqueId().toString());
        if (!playerDataFolder.exists()) {
            playerDataFolder.mkdirs();
        }

        try {
            // Save the configuration to the player's inventory file
            File playerInventoryFile = new File(playerDataFolder, "inventory.yml");
            config.save(playerInventoryFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
