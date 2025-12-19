package com.example.questapi_032.service_api

import com.example.questapi_032.modeldata.DataSiswa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ServiceApiSiswa {

    // Mengambil data (sesuai file bacateman.php)
    @GET("bacateman.php")
    suspend fun getSiswa(): List<DataSiswa>

    // Menambah data (sesuai file insertTM.php)
    @POST("insertTM.php")
    suspend fun insertSiswa(@Body dataSiswa: DataSiswa): Response<Void>

    // Mengupdate data (sesuai file editTM.php)
    @PUT("editTM.php")
    suspend fun updateSiswa(@Query("id") id: Int, @Body dataSiswa: DataSiswa): Response<Void>

    // Menghapus data (sesuai file deleteTM.php)
    @DELETE("deleteTM.php")
    suspend fun deleteSiswa(@Query("id") id: Int): Response<Void>
}