package com.example.navegacioncontresapps.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navegacioncontresapps.ContentDesc
import com.example.navegacioncontresapps.views.DYView
import com.example.navegacioncontresapps.views.LotoView


@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = "Home"){
        composable("Home"){

        }

        composable("DY"){
            DYView(navController)
        }

        composable("Descuentos"){
            ContentDesc(navController)
        }

        composable("Loto"){
            LotoView(navController)
        }


    }
}