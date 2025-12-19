package com.example.questapi_032.uicontroller.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.questapi_032.modeldata.DetailSiswa
import com.example.questapi_032.modeldata.UIStateSiswa
import com.example.questapi_032.modeldata.toDataSiswa
import com.example.questapi_032.repositori.RepositoryDataSiswa

class EntryViewModel(private val repositoryDataSiswa: RepositoryDataSiswa) : ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    /* Fungsi untuk memvalidasi input */
    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }


    // Fungsi untuk menangani saat ada perubahan pada text input
    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa =
            UIStateSiswa(detailSiswa = detailSiswa, isEntryValid = validasiInput(detailSiswa))
    }

    /* Fungsi untuk menyimpan data yang di-entry */
    suspend fun addSiswa() {
        if (validasiInput()) {
            try {
                // Di sini kita pakai insertSiswa sesuai yang kita buat di Repository sebelumnya
                repositoryDataSiswa.insertSiswa(uiStateSiswa.detailSiswa.toDataSiswa())
                println("Sukses Tambah Data")
            } catch (e: Exception) {
                println("Gagal tambah data : ${e.message}")
            }
        }
    }
}

