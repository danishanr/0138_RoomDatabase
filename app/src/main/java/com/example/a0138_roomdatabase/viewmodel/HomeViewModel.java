package com.example.a0138_roomdatabase.viewmodel;

import static kotlinx.coroutines.flow.FlowKt.stateIn;

import com.example.a0138_roomdatabase.repositori.RepositoriSiswa;
import com.example.a0138_roomdatabase.room.Siswa;

import java.util.List;

import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;

public class HomeViewModel(private val repositoriSiswa:RepositoriSiswa):ViewModel() {

    companion object {
        private const val TIMEOUT_MILIS = 5_000L
    }

    val homeUiState: StateFlow<HomeUiState> = repositoriSiswa.getAllSiwaStream()
                                                .filterNotNull()
            .map { HomeUiState(listSiswa = it.toList()) }
            .stateIn( scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = HomeUiState()
            )
    data class HomeUiState(
            val listSiswa:List<Siswa>= listOf()
    )
}
