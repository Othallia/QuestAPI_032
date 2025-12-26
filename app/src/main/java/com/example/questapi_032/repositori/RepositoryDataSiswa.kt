package com.example.questapi_032.repositori

import com.example.questapi_032.apiservice.ServiceApiSiswa
import com.example.questapi_032.modeldata.DataSiswa
import retrofit2.Response

interface RepositoryDataSiswa {
    suspend fun getDataSiswa(): List<DataSiswa>
    suspend fun postDataSiswa(dataSiswa: DataSiswa): Response<Void>
    suspend fun getSatuSiswa(id: Int): DataSiswa
    suspend fun editSatuSiswa(id: Int, dataSiswa: DataSiswa): Response<Void>
    suspend fun hapusSatuSiswa(id: Int): Response<Void>
}

