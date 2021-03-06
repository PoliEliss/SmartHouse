package com.rorono.smarthouse

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator
import com.rorono.smarthouse.databinding.ActivityMenuBinding
import com.rorono.smarthouse.screens.Electro
import com.rorono.smarthouse.screens.Floor1
import com.rorono.smarthouse.screens.Floor2Fragmeny
import com.rorono.smarthouse.screens.MenuFragment
import com.rorono.smarthouse.utils.APP_MENU_ACTIVITY

class Menu : AppCompatActivity() {
    lateinit var navController :NavController

    private val dataViewModel: DataViewModel by viewModels()

    //  private var fragList = listOf(
    //     MenuFragment.newInstance(),
    //    Floor1.newInstance(),
    //    Floor2Fragmeny.newInstance(),
    //    Electro.newInstance()
    //)
    // private var fragListTitles = listOf(
    //     "Mеню", "Первый этаж", "Второй этаж", "Приборы"
    //  )
    lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
         APP_MENU_ACTIVITY = this
        //   val adapter = VpAdapter(this, fragList)
        //  binding.viewpager2.adapter = adapter
        //  TabLayoutMediator(binding.tabLayoutMenu, binding.viewpager2) { tab, pos ->
        //    tab.text = fragListTitles[pos]

        //  }.attach()

         val navHostFragment  = supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment

        val navController = navHostFragment.navController
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(navController)


    }
}