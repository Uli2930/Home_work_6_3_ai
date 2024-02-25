package com.geeks.home_work_6_3_ai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var recv: RecyclerView
    lateinit var txtName: TextView
    lateinit var countryAdapter: CountryAdapter
    var countryList: ArrayList<Country> = arrayListOf(
        Country("Kyrgyzstan", R.drawable.kyrgyzstan),
        Country("Russia", R.drawable.russia),
        Country("Turkey", R.drawable.turkey),
        Country("Germany", R.drawable.germany),
        Country("Canada", R.drawable.canada),
        Country("USA", R.drawable.usa),
        Country("China", R.drawable.china)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recv = findViewById(R.id.recy)
        txtName = findViewById(R.id.txt_Name)

        countryAdapter = CountryAdapter(countryList){
            txtName.text = it.name
        }

        recv.apply {
            layoutManager= LinearLayoutManager(this@MainActivity)
            adapter = countryAdapter
        }
    }
}