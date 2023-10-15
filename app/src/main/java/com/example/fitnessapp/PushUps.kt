package com.example.fitnessapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnessapp.databinding.ActivityPushUpsBinding
import kotlin.math.pow


class PushUps : AppCompatActivity() {

    private lateinit var binding: ActivityPushUpsBinding
    var sure = 0
    var sureyedek = 0
    var runnable : Runnable = Runnable{}
    var handler : Handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPushUpsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button2.isEnabled = false
        val intentFromKitleBoy = intent
        val boy = intentFromKitleBoy.getIntExtra("boypushup",-1)
        val kilo = intentFromKitleBoy.getIntExtra("kilopushup",-1)
        val kitleindeks = kilo / (boy.toDouble() / 100).pow(2)
        if(kitleindeks <= 18.5){
            sure = 21
            sureyedek = 21
            binding.endeks.text = "Vücut Kitle Endeksiniz: ${kitleindeks}\nİdeal kilonuzun altındasınız"
        } else if(kitleindeks > 18.5 && kitleindeks <= 24.9){
            sure = 31
            sureyedek = 31
            binding.endeks.text = "Vücut Kitle Endeksiniz: ${kitleindeks}\nİdeal kilonuzdasınız"
        } else if(kitleindeks > 24.9 && kitleindeks <= 29.9){
            sure = 41
            sureyedek = 41
            binding.endeks.text = "Vücut Kitle Endeksiniz: ${kitleindeks}\nİdeal kilonuzun üstündesiniz"
        } else if(kitleindeks > 29.9 && kitleindeks <= 39.9){
            sure = 51
            sureyedek = 51
            binding.endeks.text = "Vücut Kitle Endeksiniz: ${kitleindeks}\nİdeal kilonuzun çok üstündesiniz(obez)"
        } else {
            sure = 61
            sureyedek = 61
            binding.endeks.text = "Vücut Kitle Endeksiniz: ${kitleindeks}\nİdeal kilonuzun çok çok üstündesiniz(morbid obez)"
        }

    }

    fun basla(view: View){
        sure = sureyedek
        runnable = object : Runnable{
            override fun run() {
                sure = sure - 1
                binding.saniye.text = "Saniye: ${sure}"
                handler.postDelayed(this,1000)
            }
        }

        handler.post(runnable)
        binding.button.isEnabled = false
        binding.button2.isEnabled = true
    }

    fun sifirla(view: View){
        handler.removeCallbacks(runnable)
        binding.button2.isEnabled = false
        binding.button.isEnabled = true
        binding.saniye.text = "Saniye: 0"
    }

}