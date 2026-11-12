package com.example.a0138_roomdatabase

import com.example.a0138_roomdatabase.repositori.ContainerApp
import com.example.a0138_roomdatabase.repositori.ContainerDataApp

class AplikasiSiswa {
    /**
     * AppContainer instance digunakan oleh kelas-kelas lainnya untuk mendapatkan dependensi
     */
    lateinit var container: ContainerApp

    override fun onCreate(){
        super.onCreate()
        container = ContainerDataApp(this)
    }
}