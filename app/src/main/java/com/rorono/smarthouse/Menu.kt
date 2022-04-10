package com.rorono.smarthouse

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.rorono.smarthouse.databinding.ActivityMenuBinding

class Menu : AppCompatActivity() {

    private val dataViewModel:DataViewModel by viewModels()
    private var fragList = listOf(
        MenuFragment.newInstance(),
        Floor1.newInstance(),
        Floor2Fragmeny.newInstance(),
        Electro.newInstance()
    )
    private var fragListTitles = listOf(
        "Mеню", "Первый этаж", "Второй этаж", "Приборы"
    )
    lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = VpAdapter(this, fragList)
        binding.viewpager2.adapter = adapter
        TabLayoutMediator(binding.tabLayoutMenu, binding.viewpager2) { tab, pos ->
            tab.text = fragListTitles[pos]

        }.attach()

        dataViewModel.message.observe(this,{


        })
    }
}