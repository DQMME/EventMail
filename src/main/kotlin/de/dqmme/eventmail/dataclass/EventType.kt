package de.dqmme.eventmail.dataclass

enum class EventType(val configName: String, val key: String) {
    PLAYER_JOINED("player_joined", "player_joined_title"),
    PLAYER_LEFT("player_left", "player_left_title")
}