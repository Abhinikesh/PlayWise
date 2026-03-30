package com.example.playwise

data class TicketItem(
    val name: String,
    val iconRes: Int,
    val type: String, // "sport" or "league"
    val sportKey: String
)
