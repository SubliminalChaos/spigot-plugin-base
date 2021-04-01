package me.waqe.plugin

//import me.waqe.myspigot.commands.LoginCommand
import me.waqe.plugin.commands.VersionCmd
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.bukkit.event.player.PlayerJoinEvent

class App : JavaPlugin(), Listener {
    companion object {
        lateinit var instance: App
    }

    override fun onEnable() {
        instance = this

        this.reloadConfig()
        this.saveDefaultConfig()

        this.server.pluginManager.registerEvents(this, this)
        this.getCommand("Check")?.setExecutor(this)
        getCommand("login")?.setExecutor(VersionCmd())
    }

    override fun onDisable() {

    }

}

@EventHandler
fun onPlayerJoin(e: PlayerJoinEvent) {
    e.joinMessage = "Welcome To My Server!"
}