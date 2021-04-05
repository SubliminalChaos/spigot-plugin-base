package me.waqe.plugin.listeners

import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class ListenerPlayerJoin : Listener {
    @EventHandler
    private fun onPlayerJoin(e: PlayerJoinEvent) {
        e.player.sendMessage("Welcome to the server, ${ChatColor.LIGHT_PURPLE}${e.player.displayName}${ChatColor.WHITE}!")
    }
}