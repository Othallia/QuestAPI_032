package com.example.questapi_032.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.questapi_032.modeldata.DetailSiswa
import com.example.questapi_032.modeldata.UIStateSiswa
import com.example.questapi_032.modeldata.toDataSiswa
import com.example.questapi_032.modeldata.toUiStateSiswa
import com.example.questapi_032.repositori.RepositoryDataSiswa
import com.example.questapi_032.uicontroller.route.DestinasiDetail
import kotlinx.coroutines.launch
import retrofit2.Response

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryDataSiswa: RepositoryDataSiswa
) : ViewModel() {

    var uiStateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetail.itemIdArg])

    init {
        viewModelScope.launch {
            try {
                val siswa = repositoryDataSiswa.getSatuSiswa(idSiswa)
                uiStateSiswa = siswa.toUiStateSiswa(isEntryValid = true)
            } catch (e: Exception) {
                println("Error Load Data: ${e.message}")
            }
        }
    }

    fun updateUiState(detailSiswa: DetailSiswa) {
        uiStateSiswa = UIStateSiswa(
            detailSiswa = detailSiswa,
            isEntryValid = validasiInput(detailSiswa)
        )
    }

    private fun validasiInput(uiState: DetailSiswa = uiStateSiswa.detailSiswa): Boolean {
        return with(uiState) {
            nama.isNotBlank() && alamat.isNotBlank() && telpon.isNotBlank()
        }
    }

    suspend fun editSatuSiswa() {
        if (validasiInput(uiStateSiswa.detailSiswa)) {
            try {
                val response: Response<Void> = repositoryDataSiswa.editSatuSiswa(
                    idSiswa,
                    uiStateSiswa.detailSiswa.toDataSiswa()
                )
                if (response.isSuccessful) {
                    println("Update Sukses: ${response.message()}")
                } else {
                    println("Update Gagal: ${response.errorBody()}")
                }
            } catch (e: Exception) {
                println("Update Error: ${e.message}")
            }
        }
    }
}