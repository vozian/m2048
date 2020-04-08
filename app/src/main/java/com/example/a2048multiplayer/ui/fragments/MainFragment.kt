package com.example.a2048multiplayer.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.a2048multiplayer.R
import com.example.a2048multiplayer.data.Repo
import com.example.a2048multiplayer.utils.resStr
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : GFragment(R.layout.fragment_main) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hello_label.text = resStr(R.string.hello_label).replace("{username}",Repo.user!!.username)

        button_single.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_playFragment)
        }

        button_multi.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_playFragment)
        }

        button_statistics.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_statisticsFragment)
        }

        button_settings.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_settingsFragment)
        }
    }
}