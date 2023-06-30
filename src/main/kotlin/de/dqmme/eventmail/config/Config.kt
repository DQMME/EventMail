package de.dqmme.eventmail.config

import de.dqmme.eventmail.EventMail
import org.bukkit.configuration.file.FileConfiguration

object Config {
    private lateinit var instance: EventMail
    private lateinit var config: FileConfiguration

    operator fun invoke(instance: EventMail) {
        Config.instance = instance

        instance.saveDefaultConfig()

        config = instance.config
    }

    fun getHost() = config.getString("hostname")

    fun getPort() = config.getInt("port")

    fun getUsername() = config.getString("username")

    fun getPassword() = config.getString("password")

    fun getSender() = config.getString("sender")

    fun getReceiver() = config.getString("receiver")

    fun getEnabledEvents(): List<String> = config.getStringList("enabled_events")
}