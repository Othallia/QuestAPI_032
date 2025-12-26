package com.example.questapi_032.uicontroller.route

import com.example.questapi_032.R

object DestinasiEdit : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}