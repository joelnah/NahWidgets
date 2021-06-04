package nah.prayer.nahwidgets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import nah.prayer.nahwidgets.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)


    }
}