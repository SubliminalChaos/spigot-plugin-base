package me.waqe.plugin

import me.waqe.plugin.commands.CmdHelp
import me.waqe.plugin.configs.ConfigManager
import me.waqe.plugin.listeners.ListenerPlayerJoin
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.PluginManager
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

class App : JavaPlugin() {
    companion object {
        lateinit var instance: App
    }

    var pluginFolder: File? = null

    var mainCM: ConfigManager? = null
    var mainConfig: YamlConfiguration? = null

    override fun onEnable() {
        instance = this
        pluginFolder = dataFolder
        logger.info("Plugin enabled")

        registerConfigs()
        registerListeners()
        registerCommands()
    }

    override fun onDisable() {
        logger.info("Plugin disabled")
    }

    private fun registerConfigs() {
        mainCM = ConfigManager("config")
        mainConfig = mainCM!!.getConfig()
        setupMainConfig()
    }

    private fun registerListeners() {
        val pm = Bukkit.getPluginManager()
        pm.registerEvents(ListenerPlayerJoin(), this)
    }

    private fun registerCommands() {
        getCommand("help")!!.setExecutor(CmdHelp())
    }

    private fun setupMainConfig() {
        mainCM!!.defaultSet("prefix", "[MyPlugin] ")
        mainCM!!.saveConfig()
    }
}