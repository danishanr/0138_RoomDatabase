package com.example.a0138_roomdatabase.repositori

import com.example.a0138_roomdatabase.room.Siswa
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa{
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)
}