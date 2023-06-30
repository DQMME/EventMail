package de.dqmme.eventmail.util

import de.dqmme.eventmail.config.Config
import de.dqmme.eventmail.config.getMessage
import de.dqmme.eventmail.dataclass.EventType
import net.axay.simplekotlinmail.delivery.mailerBuilder
import net.axay.simplekotlinmail.delivery.send
import net.axay.simplekotlinmail.email.emailBuilder
import org.bukkit.Bukkit
import org.simplejavamail.api.mailer.Mailer
import java.util.logging.Level

object Mailer {
    private var mailer: Mailer? = null

    operator fun invoke() {
        val host = Config.getHost()

        if (host == null || Config.getSender() == null || Config.getReceiver() == null) {
            Bukkit.getLogger().log(Level.WARNING, "The mailer information wasn't provided correctly. Mails won't send.")
            return
        }

        val port = Config.getPort()

        val username = Config.getUsername()
        val password = Config.getPassword()

        mailer = if (username == null || password == null) {
            mailerBuilder(host = host, port = port)
        } else {
            mailerBuilder(host = host, port = port, username = username, password = password)
        }
    }

    suspend fun sendEmail(type: EventType, playerName: String, newPlayerCount: Int, time: String) {
        if (mailer == null) return

        if(!Config.getEnabledEvents().contains(type.configName)) return

        val text = if (type == EventType.PLAYER_JOINED) getMessage("email_joined") else getMessage("email_left")

        val mail = emailBuilder {
            from(Config.getSender()!!)
            to(Config.getReceiver()!!)

            withSubject("New Event - ${getMessage(type.key)}")
            withPlainText(
                text
                    .replace("%PLAYER_NAME%", playerName)
                    .replace("%NEW_PLAYER_COUNT%", "$newPlayerCount")
                    .replace("%TIME%", time)
            )
        }

        mail.send(mailer!!)
    }
}