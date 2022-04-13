package com.born2k.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.born2k.lotto.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.randomCard.setOnClickListener {
           //startActivity(Intent(this, ResultActivity::class.java))
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getShuffleLottoNumbers()))
            startActivity(intent)
        }

        binding.constellationCard.setOnClickListener {
            startActivity(Intent(this, ConstellationActivity::class.java))
        }

        binding.nameCard.setOnClickListener {
            startActivity(Intent(this, NameActivity::class.java))
        }
    }
}