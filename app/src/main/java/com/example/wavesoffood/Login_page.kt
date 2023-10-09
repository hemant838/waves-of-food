package com.example.wavesoffood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wavesoffood.databinding.ActivityLoginPageBinding
import com.example.wavesoffood.databinding.ActivityStartBinding

class Login_page : AppCompatActivity() {
    private val binding:ActivityLoginPageBinding by lazy {
        ActivityLoginPageBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.logininButton.setOnClickListener {
            val intent = Intent(this,signinActivity::class.java)
            startActivity(intent)
        }

        binding.donotAccount.setOnClickListener {
            val intent = Intent(this,signinActivity::class.java)
            startActivity(intent)
        }
    }
}