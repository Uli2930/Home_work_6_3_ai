package com.geeks.home_work_6_3_ai

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter (var countries: ArrayList<Country>, var onclick: (Country) -> Unit):
        RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(){

            class CountryViewHolder(v: View): RecyclerView.ViewHolder(v){
                var txtNameCountry: TextView = v.findViewById(R.id.name_country)
                var flag: ImageView = v.findViewById(R.id.img_country)
                var cardView: CardView = v.findViewById(R.id.card_parent)

                fun bindData(country: Country){
                    txtNameCountry.text = country.name
                    flag.setImageResource(country.flag)
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var v = inflater.inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(v)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bindData(countries[position])
        holder.cardView.setOnClickListener{
            onclick.invoke(countries[position])
        }
    }
    override fun getItemCount(): Int {
        return countries.size
    }
}