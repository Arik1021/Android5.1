package com.example.android51.presenattion.presenter

import com.example.android51.domain.Card
import com.example.android51.domain.Game

class EmojiGame {



    private val game = Game<String>(listOf("\uD83E\uDD29", "\uD83E\uDD78", "\uD83D\uDE1C", "\uD83D\uDE43", "\uD83D\uDE17", "\uD83D\uDE00"))



    fun getCards() = game.getCards()

    fun onCardsClick(card: Card<String>) {
        game.onCardClick(card)
    }


}