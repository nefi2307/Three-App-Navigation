package com.example.navegacioncontresapps.views



import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navegacioncontresapps.R
import com.example.navegacioncontresapps.components.MainIconButton
import com.example.navegacioncontresapps.components.TitleBar

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DYView(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Doggy Ages") },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Magenta
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        DoggyAges()
    }
}



@Composable
fun DisplayComponent( titulo:String, modifier: Modifier = Modifier, imagen:Painter)
{
    Column (
        // Por si quieres poner margen
        horizontalAlignment =Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ){
        var age by remember { mutableStateOf("") }
        var result by remember { mutableStateOf("") }
        // IMAGEN ------------------------------------------------------------------------------------------------//
        Image(
            painter = imagen,
            contentDescription =null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        ) // TEXTO --------------------------------------------------------------------------------------------//
        Text(
            text = titulo,
            fontSize = 30.sp,
            fontWeight = FontWeight.Medium,
            modifier = modifier
                .padding(
                    start = 12.dp,
                    top = 18.dp,
                    end = 12.dp,
                    bottom = 12.dp
                )
        )
        // TEXT FIELD --------------------------------------------------------------------------------------------//
        OutlinedTextField(
            value = age, // A traves de un toast
            leadingIcon = { Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "loveIcon") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                age = it
            },
            label = { Text(text = "Enter you age, human.") },
            placeholder = { Text(text = "Age") },
        )
        // Botones
        Row{
            // Boton Izq ---------------------------------------------------------------------------------------/
            Button(
                onClick = {
                    var res = 0
                    res = age.toInt() * 7
                    result = res.toString()
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                modifier = Modifier
                    .padding(
                        start = 12.dp,
                        top = 22.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    )
            ) {
                Icon(
                    Icons.Filled.Face,
                    contentDescription = "Button to convert ages",
                    modifier = Modifier.
                    size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("¡Convert your age!")
            }
            // Boton Derecho BORRAR -------------------------------------------------------------------------------//
            Button(onClick = {
                result = "".toString()
                age = "".toString()
            },
                modifier = Modifier.
                padding(
                    start = 12.dp,
                    top = 22.dp,
                    end = 16.dp,
                    bottom = 16.dp
                ),
                colors = ButtonDefaults.buttonColors(contentColor = Color.Red, containerColor = Color.Black)
            ) {
                Text(text = "Delete")
            }
        }
        // Text Field Años perrunos ---------------------------------------------------------------------------------//
        OutlinedTextField(
            value = result,
            leadingIcon = { Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = "iconAgeHuman")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                result = it
            },
            label = {Text(text="Doggy Age", )},
            placeholder = {Text(text= "IDK")},
            readOnly = true
        )
    }
}

@Composable
fun DoggyAges(){
    DisplayComponent(titulo = "Doggy Ages", imagen = painterResource(id = R.drawable.imagen) )
}

@Preview(showBackground = true, showSystemUi = true) // Mostrar la UI del sistema
@Composable
fun PreviewHomeView() {
    DoggyAges()
}

