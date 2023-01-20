package com.example.android51.presenattion.ui

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android51.R
import com.example.android51.databinding.ItemNumberBinding
import com.example.android51.domain.Card
import com.example.android51.presenattion.presenter.EmojiGame
class EmojiAdapter :RecyclerView.Adapter<EmojiAdapter.ViewHolder>() {

    private val emojiGame = EmojiGame()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        private val ui = ItemNumberBinding.bind(itemView)
        fun onBind(card: Card<String>) {

            if (card.isMatched) onUiUpdate(card, true)
            else onUiUpdate(card, card.isFacedUp)
            if (!card.isMatched)
                ui.itemFrame.setOnClickListener {
                    onUiUpdate(card, !card.isFacedUp)

                    emojiGame.onCardsClick(card)
                    Handler(Looper.getMainLooper()).postDelayed({}, 1000)
                }
        }

        private fun onUiUpdate(card: Card<String>, isFacedUp: Boolean) {

            ui.itemTv.text = if (isFacedUp) card.content
            else ""
            ui.itemFrame.isPressed = isFacedUp




        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder{
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_number, parent, false)
        )
    }
    override fun onBindViewHolder(holder: EmojiAdapter.ViewHolder, position: Int) {
        holder.onBind(emojiGame.getCards()[position])
    }

    override fun getItemCount() = emojiGame.getCards().size



}

