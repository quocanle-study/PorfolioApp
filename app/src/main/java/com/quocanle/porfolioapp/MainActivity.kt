package com.quocanle.porfolioapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quocanle.porfolioapp.ui.theme.PorfolioAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PorfolioAppTheme {
                val status = remember() {
                    mutableStateOf(false)
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
//                    Column {
//                        CreateImageProfile()
//                        CreateInfo()
//                        Porfolio(data = listOf("Project 1", "Project 2", "Project 3"))
//                    }
                    Card(
                        modifier = Modifier
                            .padding(13.dp)
                            .fillMaxSize(),
                        shape = RoundedCornerShape(
                            corner = CornerSize(15.dp)
                        ),
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Top,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CreateImageProfile()
                            CreateInfo()
                            Button(onClick = {
                                status.value = !status.value
                            }) {
                                Text(
                                    text = "Porfolio",
                                    style = MaterialTheme.typography.bodyMedium
                                    )
                            }
                            Divider()
                            if (status.value) {
                                Porfolio(data = listOf("Project 1", "Project 2", "Project 3"))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CreateInfo() {
    Column(
        modifier = Modifier.padding(3.dp)) {
        Text(
            text = "Quoc An Le",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary)
        Text(
            text = "Android Developer",
            modifier = Modifier.padding(3.dp))
        Text(
            text = "@themeCompose",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(3.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun CreateImageProfile() {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, color = Color.LightGray),
        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f)

    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_account_circle_24),
            contentDescription = "Profile Image",
            modifier = Modifier.size(135.dp))
    }
}

@Composable
fun Porfolio(data: List<String>) {
    LazyColumn {
        items(data) {
            item ->
            Card(
                modifier = Modifier
                    .padding(13.dp)
                    .fillMaxSize(),
                shape = RoundedCornerShape(
                    corner = CornerSize(15.dp)
                ),

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                        .background(
                            color = MaterialTheme.colorScheme.surface
                        )
                ) {
                    CreateImageProfile()
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(7.dp)
                            .align(alignment = Alignment.CenterVertically)
                    ) {
                        Text(
                            text = item,
                            fontWeight = FontWeight.Bold)
                        Text(
                            text = "A greate project",
                            style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun GreetingPreview() {
    PorfolioAppTheme {
        Greeting("Android")
    }
}