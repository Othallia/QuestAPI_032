package com.example.questapi_032.uicontroller.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.questapi_032.repositori.AplikasiDataSiswa
import com.example.questapi_032.uicontroller.viewmodel.EntryViewModel
import com.example.questapi_032.uicontroller.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {

        // Initializer untuk HomeViewModel
        initializer {
            HomeViewModel(aplikasiDataSiswa().container.repositoryDataSiswa)
        }

        // Initializer untuk EntryViewModel
        initializer {
            EntryViewModel(aplikasiDataSiswa().container.repositoryDataSiswa)
        }
    }
}

// Fungsi ekstensi untuk mengambil instance AplikasiDataSiswa
fun CreationExtras.aplikasiDataSiswa(): AplikasiDataSiswa =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiDataSiswa)