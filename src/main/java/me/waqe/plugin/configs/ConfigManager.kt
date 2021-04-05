package me.waqe.plugin.configs

import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.IOException

class ConfigManager(val name: String) {
    private var file: File? = null
    private var config: YamlConfiguration? = null

    fun ConfigManager(name: String) {
        file = File(me.waqe.plugin.App.instance.pluginFolder, "$name.yml")
        config = YamlConfiguration.loadConfiguration(file!!)
    }

    fun saveConfig() {
        try {
            config!!.save(file!!)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun reloadConfig() {
        config = YamlConfiguration.loadConfiguration(file!!)
    }

    fun getConfig(): YamlConfiguration? {
        return config
    }

    fun defaultSet(path: String?, value: Any?) {
        if (!config!!.isSet(path!!)) {
            config!![path] = value
        }
    }
}