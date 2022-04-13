package com.born2k.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.born2k.lotto.databinding.ActivityNameBinding

class NameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goButton.setOnClickListener {
            if(TextUtils.isEmpty(binding.editText.text.toString())){
                Toast.makeText(applicationContext, "이름을 입력하세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.
                   getLottoNumbersFromHash(binding.editText.text.toString())))
            intent.putExtra("name", binding.editText.text.toString())
            startActivity(intent)
        }

        binding.backButton.setOnClickListener {
            finish()
        }
    }
}