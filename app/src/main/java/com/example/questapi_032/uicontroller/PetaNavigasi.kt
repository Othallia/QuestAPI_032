package com.example.questapi_032.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questapi_032.uicontroller.route.DestinasiEntry
import com.example.questapi_032.uicontroller.route.DestinasiHome
import com.example.questapi_032.uicontroller.view.EntrySiswaScreen
import com.example.questapi_032.uicontroller.view.HomeScreen

@Composable
fun DataSiswaApp(navController: NavHostController = rememberNavController(),
                 modifier: Modifier = Modifier) {
    HostNavigasi(navController = navController)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                // Perbaikan: Ganti onDetailClick menjadi navigateToItemUpdate
                navigateToItemUpdate = { id ->
                    // Nanti kita isi bagian ini saat membuat Halaman Edit
                    // navController.navigate("${DestinasiUpdate.route}/$id")
                }
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(
                navigateBack = { navController.navigate(DestinasiHome.route) }
            )
        }
    }
}