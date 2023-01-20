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
import com.example.android51.presenattion.presenter.NumberGame

class NumberAdapter : RecyclerView.Adapter<NumberAdapter.ViewHolder>() {

    private val numberGame = NumberGame()


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        private val ui = ItemNumberBinding.bind(itemView)
        fun onBind(card: Card<Int>) {

            if (card.isMatched) onUiUpdate(card, true)
            else onUiUpdate(card, card.isFacedUp)
            if (!card.isMatched)
                ui.itemFrame.setOnClickListener {
                    onUiUpdate(card, !card.isFacedUp)

                    numberGame.onCardsClick(card)
                    Handler(Looper.getMainLooper()).postDelayed({}, 1000)
                }
        }

        private fun onUiUpdate(card: Card<Int>, isFaced: Boolean) {

            ui.itemTv.text = if (isFaced) card.content.toString()
            else ""
            ui.itemFrame.isPressed = isFaced
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_number, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.onBind(numberGame.getCards()[position])
    }

    override fun getItemCount() = numberGame.getCards().size


}