package com.example.navegacioncontresapps

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ContentDesc(navController: NavController){
    var precio  by remember { mutableStateOf("") }
    var porcentajeDesc by remember { mutableStateOf("") }
    var descuento by remember { mutableStateOf("") }
    var total by remember { mutableStateOf("") }
    var errorMsg by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
    ){

        Spacer(modifier = Modifier.height(75.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){

            OutlinedTextField(value = precio,
                onValueChange = {precio = it
                    errorMsg=""},
                label={Text("Ingrese el precio normal")},
                isError = errorMsg.isNotEmpty(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){

            OutlinedTextField(value = porcentajeDesc,
                onValueChange = {porcentajeDesc = it
                    errorMsg=""},
                label={Text("Ingrese el descuento")},
                isError = errorMsg.isNotEmpty(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){

            ElevatedButton(onClick = { if(precio.isEmpty() || porcentajeDesc.isEmpty()){
                descuento=""
                total=""
                errorMsg="Ingrese un valor"
            }else{
                errorMsg=""
                descuento = calcularDescuento(precio.toDouble(), porcentajeDesc.toDouble()).toString()
                total = calcularTotal(precio.toDouble(), descuento.toDouble()).toString()
            }
            })
            { Text("Calcular") }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){

            ElevatedButton(onClick = { precio=""
                porcentajeDesc=""
                errorMsg=""
                total=""
                descuento=""
            })
            { Text("Limpiar") }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){

            OutlinedTextField(
                readOnly = true,
                value = descuento,
                onValueChange = {descuento = it},
                label={Text("Cantidad ahorrada.")})
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){

            OutlinedTextField(
                readOnly = true,
                value = total,
                onValueChange = {total = it},
                label={Text("Cantidad total.")})
        }

    }

}

fun calcularDescuento(precio: Double, descuento: Double):Double{
    return precio * (descuento / 100)
}

fun calcularTotal(precio: Double, descuento: Double):Double{
    return precio - descuento
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun Preview()
//{
//    con
//}
