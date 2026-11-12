package com.example.a0138_roomdatabase.room

@Dao
interface SiswaDao {
    @Insert(onConfilict = onConflictStartegy.IGNORE)
    suspend fun insert(siswa:Siswa)

    @Query(value = "SELECT * FROM tblSiswa ORDER BY nama ASC")
    fun getAllSiswa(): Flow<List><Siswa>>
}