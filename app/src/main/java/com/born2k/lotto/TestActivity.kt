package com.born2k.lotto

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.born2k.lotto.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Toast.makeText(applicationContext, "MainActivity", Toast.LENGTH_SHORT).show()

        binding.button.setOnClickListener {
            val intent = Intent(this@TestActivity, MainActivity::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            val intent = Intent(this@TestActivity, ConstellationActivity::class.java)
            startActivity(intent)
        }

        binding.button3.setOnClickListener {
            val intent = Intent(this@TestActivity, NameActivity::class.java)
            startActivity(intent)
        }

        binding.button4.setOnClickListener {
            val intent = Intent(this@TestActivity, ResultActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * xml에서 참조할 수 있게 메소드를 정의한다.
     */
    fun goConstellation(view: View){
        val intent = Intent(this@TestActivity, ConstellationActivity::class.java)
        startActivity(intent)
    }

    fun callWeb(view: View){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"))
        startActivity(intent)
    }
}