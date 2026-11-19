package com.example.a0138_roomdatabase.uicontroller

object DestinasiDetailSiswa : DestinasiNavigasi {
    override val route = "detail_siswa"

    override val titleRes = "Detail Siswa"

    const val itemIdArg = "idSiswa"

    val routeWithArgs = "$route/{$itemIdArg}"
}