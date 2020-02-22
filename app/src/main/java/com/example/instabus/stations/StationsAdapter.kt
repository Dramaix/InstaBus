package com.example.instabus.stations

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.instabus.R
import com.example.instabus.models.Station

class StationsAdapter (private val context: Context, private val stations: List<Station>?, val itemListener: CocktailItemListener) :
    RecyclerView.Adapter<StationsAdapter.ViewHolder>() {

    interface CocktailItemListener {
        fun onCocktailItemClick(cocktail: Station)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView? = itemView.findViewById(R.id.cardview)
        val cocktailImage: ImageView? = itemView.findViewById(R.id.card_view_cocktail_image)
        val cocktailName: TextView? = itemView.findViewById(R.id.card_view_cocktail_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewItem = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_station, parent, false)
        return ViewHolder(viewItem)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cocktail = stations?.get(position)

        with(holder) {
            cardView?.tag = position
            cardView?.setOnClickListener {
                itemListener.onCocktailItemClick(cocktail!!)
            }
            cocktailName?.text = cocktail?.name
            // cocktailImage?.setImageURI(Uri.parse(cocktail?.resId))
            Glide.with(context)
                .load(cocktail?.resId)
                .into(cocktailImage!!)
            // cocktailImage?.setBackgroundResource(cocktail.resId?:-1)
        }
    }

    override fun getItemCount() = stations?.size?:0
}