package com.example.questapi_032.repositori

import com.example.questapi_032.modeldata.DataSiswa
import com.example.questapi_032.service_api.ServiceApiSiswa
import java.io.IOException

// Interface Repository
interface RepositoryDataSiswa {
    suspend fun getSiswa(): List<DataSiswa>
    suspend fun insertSiswa(dataSiswa: DataSiswa)
    suspend fun updateSiswa(id: Int, dataSiswa: DataSiswa)
    suspend fun deleteSiswa(id: Int)
}

// Implementasi Repository (Jaringan)
class JaringanRepositoryDataSiswa(
    private val serviceApiSiswa: ServiceApiSiswa
) : RepositoryDataSiswa {

    override suspend fun getSiswa(): List<DataSiswa> = serviceApiSiswa.getSiswa()

    override suspend fun insertSiswa(dataSiswa: DataSiswa) {
        serviceApiSiswa.insertSiswa(dataSiswa)
    }

    override suspend fun updateSiswa(id: Int, dataSiswa: DataSiswa) {
        serviceApiSiswa.updateSiswa(id, dataSiswa)
    }

    override suspend fun deleteSiswa(id: Int) {
        serviceApiSiswa.deleteSiswa(id)
    }
}