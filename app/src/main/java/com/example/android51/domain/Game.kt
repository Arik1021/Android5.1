package com.example.android51.domain


class Game<content : Any>(list: List<content>) {

    private val cards: ArrayList<Card<content>> = ArrayList()

    init {
        list.forEachIndexed { i, content ->
            cards.add(Card(id = i * i, content = content))
            cards.add(Card(id = i * i + 2, content = content))

        }
    }


    fun getCards() = cards
    fun onCardClick(card: Card<content>) {
        card.isFacedUp = !card.isFacedUp
        cards.map {
//            if (card.id != it.id && card.content == it.content && it.isFacedUp) {
//                cards[cards.indexOf(card)].isMatched = true
//                it.isMatched = true
//            }
//
//            if (card.id != it.id && card.content == it.content && it.isFacedUp){
//                it.isFacedUp = false
//                cards[cards.indexOf(card)].isFacedUp = false
//            }


            if (it.isFacedUp && card.id != it.id) {
                if (card.content == it.content) {
                    cards[cards.indexOf(element = card)].isFacedUp = true
                    it.isFacedUp = true
                    cards[cards.indexOf(card)].isMatched = true
                    it.isMatched = true
                } else if (it.content.equals(!it.isMatched)&& card.content.equals(!it.isMatched) && it.isFacedUp && card.isFacedUp) {
                    cards[cards.indexOf(card)].isFacedUp = true
                    it.isFacedUp = true
                }
            }


        }


    }
}