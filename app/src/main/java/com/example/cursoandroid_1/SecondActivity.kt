package com.example.cursoandroid_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private var username: String? = "Usuario"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btn = findViewById<Button>(R.id.btn_action)
        val txtUser = findViewById<TextView>(R.id.txt_user)

        //getting data from father activity
        //with this syntax we prevent null values
        intent.extras?.let { bundle ->
            username = bundle.getString("user")
            txtUser.text = username
        }

        btn.setOnClickListener {

            //passing data to principal activity
            val intent = Intent()
            intent.putExtra("msg", "Gracias por usar la app")
            setResult(Activity.RESULT_OK, intent)

            // tratar de matar actividad
            finish() //back to the father activity
        }
    }
}