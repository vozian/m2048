package com.example.a2048multiplayer.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.a2048multiplayer.R
import com.example.a2048multiplayer.data.Repo
import com.example.a2048multiplayer.ui.fragments.GFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(nav_host_fragment.findNavController())
        Repo.init(this)
    }

    override fun onBackPressed() {
        val frag = nav_host_fragment.childFragmentManager.fragments.last() as? GFragment
        if(frag?.onBackPressed() == true) nav_host_fragment.findNavController().navigateUp()
    }

    override fun onSupportNavigateUp(): Boolean {
        val frag = nav_host_fragment.childFragmentManager.fragments.last() as? GFragment
        if(frag?.onBackPressed() == true) return nav_host_fragment.findNavController().navigateUp()
        else return false
    }

}
