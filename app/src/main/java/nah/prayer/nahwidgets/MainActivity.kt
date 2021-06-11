package nah.prayer.nahwidgets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import nah.prayer.nahwidgets.databinding.ActivityNahMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityNahMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)

        binding.tvTest.setNaStrokeColor(ContextCompat.getColor(this, R.color.black))
        binding.tvTest.setNaStrokeSize(10f)

    }
}