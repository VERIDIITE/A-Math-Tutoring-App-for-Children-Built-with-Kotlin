package com.example.mathtutorforchildern

import android.content.ContentValues
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_questions.*

class MainActivity : AppCompatActivity() {

    var plusBtn: Button? = null  //Button-Connection
    var minusBtn: Button? = null
    var multipleBtn: Button? = null
    var divisionBtn: Button? = null
    var combinationBtn: Button? = null
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        plusBtn = findViewById(R.id.plusBtn)
        minusBtn = findViewById(R.id.minusBtn)
        multipleBtn = findViewById(R.id.multipleBtn)
        divisionBtn = findViewById(R.id.divisionBtn)
        combinationBtn = findViewById(R.id.combBtn)
        combinationBtn!!.setOnClickListener {
            val intent = Intent(this@MainActivity, QuestionsActivity::class.java)
            intent.putExtra("operator", "comb")
            startActivity(intent)
        } //
        plusBtn!!.setOnClickListener {
            val intent = Intent(this@MainActivity, QuestionsActivity::class.java)
            intent.putExtra("operator", "+")
            startActivity(intent)
        }
        minusBtn!!.setOnClickListener {
            val intent = Intent(this@MainActivity, QuestionsActivity::class.java)
            intent.putExtra("operator", "-")
            startActivity(intent)
        }
        multipleBtn!!.setOnClickListener {
            val intent = Intent(this@MainActivity, QuestionsActivity::class.java)
            intent.putExtra("operator", "*")
            startActivity(intent)
        }
        divisionBtn!!.setOnClickListener {
            val intent = Intent(this@MainActivity, QuestionsActivity::class.java)
            intent.putExtra("operator", "/")

            startActivity(intent)


        }
    }
}