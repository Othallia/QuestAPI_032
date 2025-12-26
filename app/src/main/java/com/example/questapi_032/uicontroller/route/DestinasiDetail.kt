package com.example.questapi_032.uicontroller.route

interface DestinasiNavigasi {
    val route: String
    val titleRes: String
}

object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = "Home"
}

object DestinasiEntry : DestinasiNavigasi {
    override val route = "entry"
    override val titleRes = "Tambah Siswa"
}

object DestinasiDetail : DestinasiNavigasi {
    override val route = "detail"
    override val titleRes = "Detail Siswa"
    const val itemIdArg = "id"
    val routeWithArgs = "$route/{$itemIdArg}"
}

object DestinasiUpdate : DestinasiNavigasi {
    override val route = "update"
    override val titleRes = "Update Siswa"
    const val itemIdArg = "id"
    val routeWithArgs = "$route/{$itemIdArg}"
}