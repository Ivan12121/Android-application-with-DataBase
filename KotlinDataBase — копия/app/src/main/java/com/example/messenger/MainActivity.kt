package com.example.messenger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import com.example.messenger.databinding.ActivityMainBinding
import com.example.messenger.models.Users

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = MainDataBase.getDataBase(this)
        db.getDao().select().asLiveData().observe(this) { list ->
            binding.listUsers.text = ""
            list.forEach {
                val text = "Id: ${it.id}, Name: ${it.name}, Surname: ${it.surname}, Pass: ${it.password}"
                binding.listUsers.append(text)
            }
        }

        binding.btnSave.setOnClickListener {
            val user = Users(null, binding.inputName.text.toString(), binding.inputSurname.text.toString(), binding.inputPassword.text.toString().toInt())
            Thread {
                db.getDao().insert(user)
            }.start()
        }
    }
}