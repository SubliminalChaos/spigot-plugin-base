package me.waqe.plugin

import me.waqe.plugin.commands.CmdHelp
import me.waqe.plugin.listeners.ListenerPlayerJoin
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.io.File




class App : JavaPlugin() {
    companion object {
        lateinit var instance: App
    }

    var pluginFolder: File? = null

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
        saveDefaultConfig()
        reloadConfig()
    }

    private fun registerListeners() {
        val pm = Bukkit.getPluginManager()
        pm.registerEvents(ListenerPlayerJoin(), this)
    }

    private fun registerCommands() {
        getCommand("help")!!.setExecutor(CmdHelp())
    }
}