package com.example.wavesoffood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wavesoffood.databinding.ActivitySigninBinding

class signinActivity : AppCompatActivity() {
    private val binding:ActivitySigninBinding by lazy {
        ActivitySigninBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.alreadyhavebutton.setOnClickListener{
            val intent = Intent(this,Login_page::class.java)
            startActivity(intent)
        }
    }
}