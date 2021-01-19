package net.codes;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class DropListener implements Listener {

    private final Main core;

    public DropListener(Main core) {
        this.core = core;
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        if(!core.getCache().containsKey(player.getUniqueId())) {
            return;
        }

        ItemsManager manager = core.getCache().get(player.getUniqueId());
        Material hand = event.getItemDrop().getItemStack().getType();

        if(manager.getItems().contains(hand)) {
            event.setCancelled(true);
        }

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        StorageAPI.loadPlayer(event.getPlayer().getName());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        StorageAPI.savePlayer(core.getCache().get(event.getPlayer().getUniqueId()));
    }

}