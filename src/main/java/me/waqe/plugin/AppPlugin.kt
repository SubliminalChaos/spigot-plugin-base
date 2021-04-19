package me.waqe.plugin

import org.bukkit.event.EventHandler
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.mineacademy.fo.plugin.SimplePlugin

class App : SimplePlugin(), Listener {
    companion object {
        lateinit var instance: App
    }

    override fun onPluginStart() {
        instance = this

        //this.reloadConfig()
        //this.saveDefaultConfig()

        this.server.pluginManager.registerEvents(this, this)
    }

    override fun onPluginStop() {
        super.onPluginStop()
    }

}

@EventHandler
fun onPlayerJoin(e: PlayerJoinEvent) {
    e.joinMessage = "Welcome To My Server!"
}