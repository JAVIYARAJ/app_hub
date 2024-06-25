package com.example.apphub.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.findNavController
import com.example.apphub.R
import com.example.apphub.core.SharedPrefHelper
import com.example.apphub.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*set start destination based on welcome screen flag*/
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment)
        val navController = navHostFragment?.findNavController()
        val navGraph = navController?.navInflater?.inflate(R.navigation.nav_graph)
        val isWelcome = SharedPrefHelper.getBoolean("isWelcome")
        navGraph?.setStartDestination(if (isWelcome) R.id.loginFragment else R.id.welcomeFragment)
        navGraph?.let {
            navController.graph = it
        }
    }

}

//onCreate=>onStart=>onResume=>(after minimize app)=>onPause=>back to app=>onRestart=>onStart=>onResume=>click back button=>onPause=>onDestroy
