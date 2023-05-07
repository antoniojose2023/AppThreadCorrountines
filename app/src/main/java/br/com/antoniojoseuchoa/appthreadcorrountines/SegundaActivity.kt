package br.com.antoniojoseuchoa.appthreadcorrountines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.antoniojoseuchoa.appthreadcorrountines.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySegundaBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}