package com.example.questapi_032.repositori

import com.example.questapi_032.apiservice.ServiceApiSiswa
import com.example.questapi_032.modeldata.DataSiswa
import java.io.IOException

// 1. INTERFACE (Kontrak Menu)
interface RepositoryDataSiswa {
    suspend fun getSiswa(): List<DataSiswa>

    // Perhatikan: id tipe datanya Int (Bukan String)
    suspend fun getSiswaById(id: Int): DataSiswa

    suspend fun insertSiswa(siswa: DataSiswa)

    suspend fun updateSiswa(id: Int, siswa: DataSiswa) // Ini juga Int

    suspend fun deleteSiswa(id: Int) // Ini juga Int
}

// 2. IMPLEMENTASI (Koki yang memasak)
class JaringanRepositoryDataSiswa(
    private val serviceApiSiswa: ServiceApiSiswa
) : RepositoryDataSiswa {

    override suspend fun getSiswa(): List<DataSiswa> = serviceApiSiswa.getSiswa()

    // Ubah id: String menjadi id: Int
    override suspend fun getSiswaById(id: Int): DataSiswa {
        return serviceApiSiswa.getSiswaById(id)
    }

    override suspend fun insertSiswa(siswa: DataSiswa) {
        serviceApiSiswa.insertSiswa(siswa)
    }

    // Ubah id: String menjadi id: Int
    override suspend fun updateSiswa(id: Int, siswa: DataSiswa) {
        serviceApiSiswa.updateSiswa(id, siswa)
    }

    // Ubah id: String menjadi id: Int
    override suspend fun deleteSiswa(id: Int) {
        try {
            val response = serviceApiSiswa.deleteSiswa(id)
            if (!response.isSuccessful) {
                throw IOException("Gagal menghapus data. Kode: ${response.code()}")
            }
        } catch (e: Exception) {
            throw e
        }
    }
}