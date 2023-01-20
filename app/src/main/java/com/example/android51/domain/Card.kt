package com.example.android51.domain

data class Card<Content>(

    var isFacedUp:Boolean = false,
    var isMatched:Boolean= false,
    var id: Int ,
    var content: Content
) {

}
