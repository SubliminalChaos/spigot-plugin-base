package me.waqe.plugin.utils

import org.bukkit.ChatColor
import org.bukkit.command.CommandSender

object Utils {
    fun color(message: String) : String {
        return ChatColor.translateAlternateColorCodes('&', message)
    }
    fun cm(p: CommandSender, message: String) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', message))
    }
}