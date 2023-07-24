package me.tiie.woolwars.utls;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.io.File;

public class PlayerInventoryRestorer {
    public boolean restoreInventory(Player p, String dataFolderPath) {
        PlayerInventory playerInventory = p.getInventory();

        // Load the inventory data from the file
        File playerDataFolder = new File(dataFolderPath, p.getUniqueId().toString());
        File playerInventoryFile = new File(playerDataFolder, "inventory.yml");

        if (!playerInventoryFile.exists()) {
            p.sendMessage("You don't have any stored inventory to restore.");
            return false;
        }

        YamlConfiguration config = YamlConfiguration.loadConfiguration(playerInventoryFile);
        ConfigurationSection inventorySection = config.getConfigurationSection("player_inventory");

        if (inventorySection != null) {
            // Clear the player's current inventory
            playerInventory.clear();

            // Restore the inventory contents
            for (String slotStr : inventorySection.getKeys(false)) {
                int slot = Integer.parseInt(slotStr);
                ItemStack itemStack = ItemStack.deserialize(inventorySection.getConfigurationSection(slotStr).getValues(true));
                playerInventory.setItem(slot, itemStack);
            }

            p.sendMessage("Your inventory has been restored.");
        } else {
            p.sendMessage("No stored inventory data found.");
            return false;
        }

        return true;
    }
}