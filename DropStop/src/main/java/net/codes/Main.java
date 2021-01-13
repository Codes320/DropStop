package net.codes;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class Main extends JavaPlugin {

    public static HashMap<UUID, ItemsManager> lockedItems = new HashMap<>();

    ItemsManager manager;

    public Main(ItemsManager manager) {
        this.manager = manager;
    }

    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new DropListener(), this);
        getCommand("lockitem").setExecutor(new DropCommand());

    }



}
