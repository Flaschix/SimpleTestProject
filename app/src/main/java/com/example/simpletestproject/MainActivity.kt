package com.example.simpletestproject

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.simpletestproject.databinding.ActivityMainBinding
import com.example.simpletestproject.dto.IpDto
import com.example.simpletestproject.mapper.IpMapper
import com.example.simpletestproject.network.ApiFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycleScope.launch {
            val ip = fetchIp()

            binding.tvIP.text = ip
        }
    }

    private suspend fun fetchIp(): String{
        val response: IpDto

        try {
            response = ApiFactory.apiService.getIpAddress()
        } catch (e: Exception){
            return "Error"
        }

        val ip = IpMapper().mapIpDtoToIP(response)

        return ip.ip
    }
}