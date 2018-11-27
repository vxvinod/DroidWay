package com.example.a60010743.day2login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var username : EditText
    lateinit var password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbar)

        username = findViewById<EditText>(R.id.username)
        password = findViewById<EditText>(R.id.password)
        var loginBtn = findViewById<Button>(R.id.submit)
        //Get Reference of Edit Text and Button

        //Oncreate method call the showToast

        val onClickListener = loginBtn?.setOnClickListener {
            showToast()
        }


    }

    private fun showToast(){
        var name : String = username.text.toString()
        if(!name.equals("")){
            var name = username.text
            Toast.makeText(this, "${name} loginned", Toast.LENGTH_LONG).show()
        }
    }

}
