package com.example.a0138_roomdatabase.uicontroller

import com.example.a0138_roomdatabase.R

object DestinasiEditSiswa : DestinasiNavigasi {
    override val route = "item_edit"

    override val titleRes = R.string.edit_siswa

    const val itemIdArg = "idSiswa"

    val routeWithArgs = "$route/{$itemIdArg}"
}