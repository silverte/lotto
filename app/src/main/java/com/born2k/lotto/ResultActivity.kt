package com.born2k.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import com.born2k.lotto.databinding.ActivityResultBinding
import kotlinx.android.synthetic.main.activity_result.*
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val result = intent.getIntegerArrayListExtra("result")
        val name = intent.getStringExtra("name")
        val constellation = intent.getStringExtra("constellation")

        binding.resultLabel.text = "랜덤으로 생성된\n로또 번호입니다"

        if(!TextUtils.isEmpty(name)){
            resultLabel.text = "${name}님의\n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n로또 번호입니다"
        }

        if(!TextUtils.isEmpty(constellation)){
            resultLabel.text = "${constellation}의\n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n로또 번호입니다"
        }

        result?.let{
            resultNumer.text = result.toString()
        }
    }
}