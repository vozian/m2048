package com.example.a2048multiplayer.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.a2048multiplayer.R
import com.example.a2048multiplayer.data.Repo
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterFragment : GFragment(R.layout.fragment_register) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        register_button.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main){
                val user = Repo.register(
                    username_field.text.toString(),
                    email_field.text.toString(),
                    password_field.text.toString()
                )

                if (user != null) {
                    findNavController().navigate(R.id.action_registerFragment_to_mainFragment)
                } else {
                    Toast.makeText(context, "Error: wrong login or password!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}