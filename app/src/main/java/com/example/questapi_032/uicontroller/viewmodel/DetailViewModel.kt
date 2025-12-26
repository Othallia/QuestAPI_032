package com.example.questapi_032.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.questapi_032.modeldata.DataSiswa
import com.example.questapi_032.repositori.RepositoryDataSiswa
import com.example.questapi_032.uicontroller.route.DestinasiDetail
import kotlinx.coroutines.launch
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

sealed interface StatusUiDetail {
    data class Success(val satusiswa: DataSiswa) : StatusUiDetail
    object Error : StatusUiDetail
    object Loading : StatusUiDetail
}

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryDataSiswa: RepositoryDataSiswa
) : ViewModel() {

    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetail.itemIdArg])

    var statusUiDetail: StatusUiDetail by mutableStateOf(StatusUiDetail.Loading)
        private set

    init {
        getSatuSiswa()
    }

    fun getSatuSiswa() {
        viewModelScope.launch {
            statusUiDetail = StatusUiDetail.Loading
            try {
                val satusiswa = repositoryDataSiswa.getSatuSiswa(idSiswa)
                statusUiDetail = StatusUiDetail.Success(satusiswa)
            } catch (e: IOException) {
                statusUiDetail = StatusUiDetail.Error
            } catch (e: HttpException) {
                statusUiDetail = StatusUiDetail.Error
            }
        }
    }

    suspend fun hapusSatuSiswa() {
        try {
            val response: Response<Void> = repositoryDataSiswa.hapusSatuSiswa(idSiswa)
            if (response.isSuccessful) {
                println("Sukses Hapus Data: ${response.message()}")
            } else {
                println("Gagal Hapus Data: ${response.errorBody()}")
            }
        } catch (e: Exception) {
            println("Error Hapus: ${e.message}")
        }
    }
}