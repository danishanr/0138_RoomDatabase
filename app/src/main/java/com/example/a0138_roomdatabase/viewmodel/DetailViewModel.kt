package com.example.a0138_roomdatabase.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a0138_roomdatabase.repositori.RepositoriSiswa
import com.example.a0138_roomdatabase.uicontroller.DestinasiDetailSiswa
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa): ViewModel(){

    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetailSiswa.itemIdArg])

    val uiDetailState: StateFlow<DetailSiswaUiState> =
        repositoriSiswa.getSiswaStream(idSiswa)
            .filterNotNull()
            .map {
                DetailSiswaUiState(detailSiswa = it.toDetailSiswa())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = TIMEOUT_MILLIS),
                initialValue = DetailSiswaUiState()
            )
}

)