package com.example.android51.presenattion.presenter

import com.example.android51.domain.Card
import com.example.android51.domain.Game

class NumberGame {

    private val game = Game<Int>(listOf(1,2,3,4,5,6))



    fun getCards() = game.getCards()

    fun onCardsClick(card: Card<Int>) {
        game.onCardClick(card)
    }
}