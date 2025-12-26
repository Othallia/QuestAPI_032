package com.example.questapi_032.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.questapi_032.uicontroller.route.DestinasiDetail
import com.example.questapi_032.uicontroller.route.DestinasiEdit
import com.example.questapi_032.uicontroller.route.DestinasiEntry
import com.example.questapi_032.uicontroller.route.DestinasiHome
import com.example.questapi_032.uicontroller.view.HomeScreen
import com.example.questapi_032.view.DetailSiswaScreen
import com.example.questapi_032.view.EditSiswaScreen
import com.example.questapi_032.view.EntrySiswaScreen

@Composable
fun DataSiswaApp(navController: NavHostController = rememberNavController(), modifier: Modifier = Modifier) {
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
        composable(route = DestinasiHome.route) {
            HomeScreen(
                // Ubah 'navigateToEntry' menjadi 'navigateToItemEntry'
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },

                // Ubah 'onItemClick' atau 'onDetailClick' menjadi 'navigateToItemUpdate'
                navigateToItemUpdate = { idSiswa ->
                    navController.navigate("${DestinasiDetail.route}/$idSiswa")
                }
            )
        }
        composable(DestinasiEntry.route) {
            EntrySiswaScreen(navigateBack = { navController.navigate(DestinasiHome.route) })
        }
        composable(
            route = DestinasiDetail.routeWithArgs,
            arguments = listOf(navArgument(name = DestinasiDetail.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            DetailSiswaScreen(
                // Sesuaikan nama parameter menjadi navigateToEditItem
                navigateToEditItem = { idSiswa ->
                    navController.navigate("${DestinasiEdit.route}/$idSiswa")
                },
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
        composable(
            DestinasiEdit.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEdit.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            EditSiswaScreen(
                navigateBack = { navController.navigate(DestinasiHome.route) },
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}