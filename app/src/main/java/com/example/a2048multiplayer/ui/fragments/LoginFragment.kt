package com.example.a2048multiplayer.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.a2048multiplayer.R
import com.example.a2048multiplayer.data.Repo
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.*

class LoginFragment : GFragment(R.layout.fragment_login) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login_button.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                val user = Repo.login(
                    username_field.text.toString(),
                    password_field.text.toString()
                )

                if (user != null) {
                    findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                } else {
                    Toast.makeText(context, "Error: wrong login or password!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        register_button.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

    }
}