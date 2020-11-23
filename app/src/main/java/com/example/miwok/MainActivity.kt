package com.example.miwok

import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //creating number TextView and setting OnClick method
        val numbersTextView = findViewById<TextView>(R.id.numbers)
        numbersTextView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext, Numbers::class.java)
                startActivity(intent)
            }
        })

        //creating FamilyMember TextView and setting OnClick method
        val familyMembersTextView = findViewById<TextView>(R.id.family_members)
        familyMembersTextView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext, Family_Members::class.java)
                startActivity(intent)
            }
        })

        //creating colors TextView and setting OnClick method
        val colorsTextView = findViewById<TextView>(R.id.colors)
        colorsTextView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext, Colors::class.java)
                startActivity(intent)
            }
        })

        //creating phrases TextView and setting OnClick method
        val phrasesTextView = findViewById<TextView>(R.id.phrases)
        phrasesTextView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent(applicationContext, Phrases::class.java)
                startActivity(intent)
            }
        })

    }

}
