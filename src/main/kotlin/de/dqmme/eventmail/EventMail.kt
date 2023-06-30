package de.dqmme.eventmail

import de.dqmme.eventmail.config.Config
import de.dqmme.eventmail.config.MessageConfig
import de.dqmme.eventmail.listener.ConnectionListeners
import de.dqmme.eventmail.util.Mailer
import org.bukkit.plugin.java.JavaPlugin

class EventMail: JavaPlugin() {
    override fun onEnable() {
        Config(this)
        MessageConfig(this)
        Mailer()

        server.pluginManager.registerEvents(ConnectionListeners(), this)
    }
}