package com.example.primerprogramakotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.primerprogramakotlin.ui.theme.PrimerProgramaKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        ejercicio01()
        ejercicio02()
        ejercicio03()
        ejercicio04()
        ejercicio05()
        ejercicio06()
        ejercicio07()

        setContent {
            PrimerProgramaKotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
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

fun ejercicio01() {
    println("1")
    println("2")
    println("3")
}

fun ejercicio02() {
    println("I'm")
    println("learning")
    println("Kotlin!")
}

fun ejercicio03() {
    println("Monday")
    println("Tuesday")
    println("Wednesday")
    println("Thursday")
    println("Friday")
}

fun ejercicio04() {
    println("Tomorrow is rainy")
}

fun ejercicio05() {
    println("There is a chance of snow")
}

fun ejercicio06() {
    println("Cloudy")
    println("Partly Cloudy")
    println("Windy")
}

fun ejercicio07() {
    println("How's the weather today?")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrimerProgramaKotlinTheme {
        Greeting("Android")
    }
}