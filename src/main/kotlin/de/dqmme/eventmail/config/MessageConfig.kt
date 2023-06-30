package de.dqmme.eventmail.config

import de.dqmme.eventmail.EventMail
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

object MessageConfig {
    private lateinit var instance: EventMail
    private lateinit var file: File
    private lateinit var config: YamlConfiguration

    operator fun invoke(instance: EventMail) {
        this.instance = instance

        file = File(instance.dataFolder, "messages.yml")

        if(!file.exists()) {
            instance.saveResource("messages.yml", false)
        }

        config = YamlConfiguration.loadConfiguration(file)
    }

    fun getMessage(key: String): String {
        return config.getString(key) ?: key
    }
}

fun getMessage(key: String): String = MessageConfig.getMessage(key)