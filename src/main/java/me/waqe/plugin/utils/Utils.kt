package me.waqe.plugin.utils

import org.bukkit.ChatColor

object Utils {
    fun color(message: String) : String {
        return ChatColor.translateAlternateColorCodes('&', message)
    }
}