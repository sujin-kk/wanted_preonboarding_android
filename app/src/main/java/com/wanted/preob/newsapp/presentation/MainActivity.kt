package com.wanted.preob.newsapp.presentation

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.wanted.preob.newsapp.R
import com.wanted.preob.newsapp.databinding.ActivityMainBinding
import com.wanted.preob.newsapp.presentation.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBottomNavigation()
    }


    private fun initBottomNavigation() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        with(binding.navBottomView) {
            setupWithNavController(navController)
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.topNewsFragment -> {
                        navController.navigate(R.id.topNewsFragment)
                    }
                    R.id.categoryFragment -> {
                        navController.navigate(R.id.categoryFragment)
                    }
                    R.id.savedFragment -> {
                        navController.navigate(R.id.savedFragment)
                    }
                }
                true
            }
        }
    }
}