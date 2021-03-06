package com.born2k.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.DatePicker
import com.born2k.lotto.databinding.ActivityConstellationBinding
import java.time.Year
import java.util.*
import kotlin.collections.ArrayList

class ConstellationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConstellationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstellationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goResultButton.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash(
                makeConstellationString(binding.datePicker.month, binding.datePicker.dayOfMonth))))

            intent.putExtra("constellation", makeConstellationString(binding.datePicker.month, binding.datePicker.dayOfMonth))
            startActivity(intent)
        }

        binding.textView.text = makeConstellationString(binding.datePicker.month, binding.datePicker.dayOfMonth)

        val calendar = Calendar.getInstance()
        binding.datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
        object:CalendarView.OnDateChangeListener, DatePicker.OnDateChangedListener{
            override fun onDateChanged(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                binding.textView.text = makeConstellationString(binding.datePicker.month, binding.datePicker.dayOfMonth)
            }

            override fun onSelectedDayChange(view: CalendarView, year: Int, month: Int, dayofMonth: Int) {
            }
        })
    }

    fun makeConstellationString(month: Int, day: Int): String{
        val target = "${month + 1}${String.format("%02d", day)}".toInt()
        when(target){
            in 101..119 -> return "????????????"
            in 120..218 -> return "????????????"
            in 219..320 -> return "???????????????"
            in 321..419 -> return "?????????"
            in 420..520 -> return "????????????"
            in 521..621 -> return "???????????????"
            in 622..722 -> return "?????????"
            in 723..822 -> return "????????????"
            in 823..923 -> return "????????????"
            in 924..1022 -> return "????????????"
            in 1023..1122 -> return "????????????"
            in 1123..1224 -> return "????????????"
            in 1225..1231 -> return "????????????"
            else -> return "???????????????"
        }
    }
}