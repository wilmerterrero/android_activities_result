package com.example.cursoandroid_1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //on memory vars
    private lateinit var welcomeText:TextView
    private lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeText = findViewById(R.id.txt_output)
        btn = findViewById(R.id.btn_action)

        btn.setOnClickListener {
            navigateSecondActivity()
        }

    }

    private fun navigateSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("user", "Wilmer") //passing data from activity to another activity
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 1) {
            if(resultCode == Activity.RESULT_OK) {
                val msg = data?.getStringExtra("msg")
                welcomeText.text = msg
            }
        }
    }

}