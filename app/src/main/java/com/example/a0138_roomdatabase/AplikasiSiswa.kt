package com.example.a0138_roomdatabase

import android.app.Application
import com.example.a0138_roomdatabase.repositori.ContainerApp
import com.example.a0138_roomdatabase.repositori.ContainerDataApp

class AplikasiSiswa : Application() {
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}