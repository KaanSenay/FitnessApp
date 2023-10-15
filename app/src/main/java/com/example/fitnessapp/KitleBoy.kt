package com.example.fitnessapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessapp.databinding.ActivityKitleBoyBinding


class KitleBoy : AppCompatActivity() {

    private lateinit var binding: ActivityKitleBoyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKitleBoyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun next(view: View){
        if(binding.editTextText.text.isNullOrEmpty() && binding.editTextText2.text.isNullOrEmpty()){
            Toast.makeText(this@KitleBoy, "Lutfen Boy Kilo Verilerinizi Giriniz", Toast.LENGTH_LONG).show()
        } else {
            val intentpushup = Intent(this@KitleBoy, PushUps::class.java)
            val boy = binding.editTextText.text.toString().toInt()
            val kilo = binding.editTextText2.text.toString().toInt()
            intentpushup.putExtra("boypushup", boy)
            intentpushup.putExtra("kilopushup", kilo)
            startActivity(intentpushup)
        }

    }

}