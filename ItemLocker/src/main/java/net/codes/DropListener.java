package net.codes;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.UUID;

public class DropListener implements Listener {

    private Main main;

    public DropListener(Main main) {
        this.main = main;
    }


    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {

        Player player = e.getPlayer();
        String hand = e.getItemDrop().getItemStack().getType().toString();
        UUID playerUUID = player.getUniqueId();


        if (main.getCache().get(playerUUID).contains(hand)) {
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "This item is on your lock list. Type /lockitem to unlock it.");
        }

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

    }
}
