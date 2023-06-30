package de.dqmme.eventmail.listener

import de.dqmme.eventmail.dataclass.EventType
import de.dqmme.eventmail.util.Mailer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ConnectionListeners: Listener {
    private val ioScope = CoroutineScope(Dispatchers.IO)

    @EventHandler
    fun onJoin(event: PlayerJoinEvent) {
        ioScope.launch {
            val time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a"))
            Mailer.sendEmail(EventType.PLAYER_JOINED, event.player.name, Bukkit.getOnlinePlayers().size, time)
        }
    }

    @EventHandler
    fun onQuit(event: PlayerQuitEvent) {
        ioScope.launch {
            val time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm a"))
            Mailer.sendEmail(EventType.PLAYER_LEFT, event.player.name, Bukkit.getOnlinePlayers().size - 1, time)
        }
    }
}