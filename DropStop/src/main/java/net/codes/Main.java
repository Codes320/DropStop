package net.codes;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class Main extends JavaPlugin {

    private Map<UUID, ItemsManager> cache = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("lockitem").setExecutor(new DropCommand(this));
        getServer().getPluginManager().registerEvents(new DropListener(this), this);
    }

    @Override
    public void onDisable() {

    }

    public Map<UUID, ItemsManager> getCache() {
        return cache;
    }
}
