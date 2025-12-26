package com.example.questapi_032.apiservice

import com.example.questapi_032.modeldata.DataSiswa
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query

interface ServiceApiSiswa {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )

    @GET("bacaTeman.php")
    suspend fun getSiswa(): List<DataSiswa>

    @POST("insertTM.php")
    suspend fun insertSiswa(@Body dataSiswa: DataSiswa): Response<Void>

    // Menyesuaikan modul: menggunakan Query id
    @GET("bacalTeman.php")
    suspend fun getSatuSiswa(@Query("id") id: Int): DataSiswa

    @PUT("editTM.php")
    suspend fun editSatuSiswa(
        @Query("id") id: Int,
        @Body dataSiswa: DataSiswa
    ): Response<Void>

    @DELETE("deleteTM.php")
    suspend fun hapusSatuSiswa(@Query("id") id: Int): Response<Void>
}