package com.example.robertosanchez.examenej1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.robertosanchez.examenej1.ui.theme.ExamenEJ1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            ExamenEJ1Theme {
                ListaVideojuegos();
            }
        }
    }
}

data class Videojuegos(
    val name: String,
    val price: Int,
    val imageUrl: String
)

fun getVideojuegos() = (1..10).map{
    Videojuegos(
        name = "Videojuego $it",
        price = it * 100,
        imageUrl = "https://loremflickr.com/400/400/seville?lock=$it"
    )
}

@Composable
fun ListarVideojuego(videojuego: Videojuegos) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = videojuego.imageUrl,
            contentDescription = videojuego.name,
        )

        Text(videojuego.name, fontSize = 30.sp)

        Text("Precio: ${videojuego.price}€")
    }
}


@Composable
fun ListaVideojuegos() {
    LazyColumn {
        items(getVideojuegos()) { item ->
            ListarVideojuego(item)
        }
    }
}