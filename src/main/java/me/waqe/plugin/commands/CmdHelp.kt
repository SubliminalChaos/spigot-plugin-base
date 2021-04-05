package me.waqe.plugin.commands

import me.waqe.plugin.utils.Utils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player


class CmdHelp : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (!label.equals("help", true))
            return true
        if (!sender.hasPermission("App.permission.help"))
            return true
        if (sender !is Player)
            return true

        Utils.color("&7Usage: /command")

        return true
    }
}