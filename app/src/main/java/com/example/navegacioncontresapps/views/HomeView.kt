package com.example.navegacioncontresapps.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navegacioncontresapps.components.ActionButton
import com.example.navegacioncontresapps.components.MainButton
import com.example.navegacioncontresapps.components.Space
import com.example.navegacioncontresapps.components.TitleBar
import com.example.navegacioncontresapps.components.TitleView
import com.example.navegacioncontresapps.components.ActionButton
import com.example.navegacioncontresapps.components.MainButton
import com.example.navegacioncontresapps.components.Space
import com.example.navegacioncontresapps.components.TitleBar
import com.example.navegacioncontresapps.components.TitleView


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Home View") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                )
            )
        },
        floatingActionButton = {
            ActionButton()
        }
    ) {
        ContentHomeView(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentHomeView(navController: NavController) {
    var mExpanded by remember { mutableStateOf(false) }
    var mSelectedText by remember { mutableStateOf("Seleccione una app: ") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Home View")
        Space()

        Button(onClick = { mExpanded = !mExpanded}){

            Text(text = mSelectedText)

        }

        DropdownMenu(expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier.fillMaxWidth()) {

            val mApps = listOf("Dog Years", "Descuentos", "Loteria")

            mApps.forEach(){ option ->

                DropdownMenuItem(text = { Text(option) },
                    onClick = {
                        mSelectedText = option
                        mExpanded = false
                    })

            }

        }



        MainButton(name = "Continuar", backColor = Color.Red, color = Color.White) {
            navController.navigate(viewSelector(mSelectedText))
        }
    }
}

fun viewSelector(selectedText: String):String{
    var texto = ""

    when(selectedText){
        "Dog Years" -> texto="DY"
        "Descuentos" -> texto="Descuentos"
        "Loteria" -> texto="Loto"
        else -> texto="Home"
    }


    return texto

}
