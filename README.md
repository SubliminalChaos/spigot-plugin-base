# spigot-plugin-base
This is a basic codebase for a Spigot plugin written in Kotlin and built using Gradle.

## Requirements
- JDK 8+ (Kotlin builds to this target)
- Gradle 6+

## Initial Usage
Clone this repo, and then change the following files to match your new package name:
- `src/main/java/me/waqe/#NAME#/` (create the package)
- `src/main/java/me/waqe/#NAME#/App.kt` (change the package name in line 1)
- `src/resources/plugin.yml` (There is a `main` field)

### Additional Notes
- The Spigot version is specified in `build.gradle.kts`
- Follow the conventions of the Gradle `java` plugin
  - Keep all your source code under `src/main/java/`
  - Keep all other assets (e.g. `plugin.yml`) under `src/main/resources`

## Usage
To build a JAR file for use with Spigot, run `gradle shadowJar`. The completed file will be in `build/libs`.

```
// NamePlugin.kt:
package me.waqe.#NAME#

import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.event.Listener
//import me.waqe.myspigot.commands.LoginCommand

class App : JavaPlugin(), Listener {
  companion object {
    lateinit var instance: App
  }

  override fun onEnable() {
    instance = this

    // this.reloadConfig()
    // this.saveDefaultConfig()
 
    logger.info("Hello there!")

    // this.server.pluginManager.registerEvents(this, this)
    // this.getCommand("Check")?.setExecutor(this)
    // getCommand("login")?.setExecutor(LoginCommand())

  }
}
```