package com.example.festival

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.festival.databinding.ActivityLoginBinding
import com.example.festival.databinding.ActivitySignupBinding

class signupActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //뒤로가기 버튼
        binding.signupBack.setOnClickListener {
            val intent = Intent(this, loginActivity::class.java)
            startActivity(intent)
        }


    }


}