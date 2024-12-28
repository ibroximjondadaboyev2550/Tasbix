package com.example.tasbix2024

import android.app.ListActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tasbix2024.databinding.ActivityMainBinding
import android.content.Intent
import android.content.SharedPreferences
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    private lateinit var tvCounter: TextView
    private lateinit var btnTasbih: Button
    private lateinit var btnList: Button
    private lateinit var sharedPreferences: SharedPreferences

    private var counter = 0
    private val targetValue = 999999  // Maksimal qiymat

    private lateinit var tvCount: TextView
    private lateinit var btnCounter: Button
    private lateinit var btnReset: Button
    private var count = 0



    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // UI komponentlarini aniqlash
        tvCounter = findViewById(R.id.tvCounter)
        btnTasbih = findViewById(R.id.btnTasbih)
        btnList = findViewById(R.id.btnList)

        // SharedPreferences
        sharedPreferences = getSharedPreferences("TasbihPrefs", MODE_PRIVATE)
        counter = sharedPreferences.getInt("COUNTER", 0)
        tvCounter.text = counter.toString()

        // Tasbih tugmasi
        btnTasbih.setOnClickListener {
            if (counter < targetValue) {
                counter++
                tvCounter.text = counter.toString()
            } else {
                Toast.makeText(this, "Limitga yetdingiz!", Toast.LENGTH_SHORT).show()
            }
        }

        // List tugmasi
        btnList.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        // Hisoblagichni saqlash
        sharedPreferences.edit().putInt("COUNTER", counter).apply()
    }

}
