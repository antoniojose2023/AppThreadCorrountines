package br.com.antoniojoseuchoa.appthreadcorrountines

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.antoniojoseuchoa.appthreadcorrountines.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private var validate = false
    private var pararThread = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btNext.setOnClickListener {
            startActivity(Intent(this, SegundaActivity::class.java))

        }

        binding.btStart.setOnClickListener {
               //MinhaThread().start()
               //Thread(MinhaRunnable()).start()
               Thread{
                   //simular um processo pesado de dados
                   repeat(10){ indice ->

                       if(pararThread){
                           pararThread = false
                           return@Thread
                       }

                       Log.i("TAG", "run: $indice")
                       Thread.sleep(1000)

                       runOnUiThread {
                           binding.btStart.isEnabled = false
                           binding.btStart.text = "Indice : $indice"

                           if(indice >= 9){
                               binding.btStart.isEnabled = true

                           }
                       }

                   }
               }.start()

        }

        binding.btStop.setOnClickListener {
            pararThread = true
            validate = true
            binding.btStart.isEnabled = validate
            binding.btStart.text = "Reiniciar"
        }

    }

    inner class MinhaRunnable: Runnable{
        override fun run() {
            //simular um processo pesado de dados
            repeat(10){ indice ->

                if(pararThread){
                    pararThread = false
                    return
                }

                Log.i("TAG", "run: $indice")
                Thread.sleep(1000)

                runOnUiThread {
                    binding.btStart.isEnabled = false
                    binding.btStart.text = "Indice : $indice"

                    if(indice >= 9){
                        binding.btStart.isEnabled = true

                    }
                }

            }
        }

    }


    inner class MinhaThread: Thread(){
        override fun run() {
            super.run()

            //simular um processo pesado de dados
            repeat(10){ indice ->

                if(pararThread){
                    pararThread = false
                    return
                }

                Log.i("TAG", "run: $indice")
                sleep(1000)

                runOnUiThread {
                    binding.btStart.isEnabled = false
                    binding.btStart.text = "Indice : $indice"

                    if(indice >= 9){
                        binding.btStart.isEnabled = true

                    }
                }

            }

        }
    }
}