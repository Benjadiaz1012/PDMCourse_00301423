package com.example.conceptosbasicoskotlin

import android.os.Bundle
import android.widget.Switch
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
import com.example.conceptosbasicoskotlin.ui.theme.ConceptosBasicosKotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ejercicio01()
            ejercicio02()
            ejercicio03()
            ejercicio04()
            ejercicio05()
            ejercicio06()
            ejercicio07()
        }
    }
}

fun ejercicio01() {
    val morningNotification = 51
    val eveningNotification = 135

    printNotificationSummary(morningNotification)
    printNotificationSummary(eveningNotification)
}

fun printNotificationSummary(numberOfMessages: Int) {
    if (numberOfMessages < 100) {
        println("You have ${numberOfMessages} notifications.")
    } else {
        println("Your phone is blowing up! You have 99+ notifications.")
    }
}

fun ejercicio02() {
    val child = 5
    val adult = 28
    val senior = 87

    val isMonday = true

    println("The movie ticket price for a person aged $child is \$${ticketPrice(child, isMonday)}.")
    println("The movie ticket price for a person aged $adult is \$${ticketPrice(adult, isMonday)}.")
    println(
        "The movie ticket price for a person aged $senior is \$${
            ticketPrice(
                senior,
                isMonday
            )
        }."
    )
}

fun ticketPrice(age: Int, isMonday: Boolean): Int {
    var precio = 0;
    if (isMonday) {
        precio = when (age) {
            in (0..12) -> {
                15
            }

            in (13..60) -> {
                25
            }

            in (61..100) -> {
                20
            }

            else -> {
                -1
            }
        }
    } else {
        precio = when (age) {
            in (0..5) -> {
                15
            }

            in (13..60) -> {
                30
            }

            in (61..100) -> {
                20
            }

            else -> {
                -1
            }
        }
    }
    return precio;
}

fun ejercicio03() {
    printFinalTemperature(27.0, "Celsius", "Fahrenheit", ({ (9.0 / 5.0) * it + 32.0 }))
    printFinalTemperature(350.0, "Kelvin", "Celsius", ({ it - 273.15 }))
    printFinalTemperature(10.0, "Fahrenheit", "Kelvin", ({ ((5.0 / 9.0) * (it - 32)) + 273.15 }))
}

fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement))
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}

fun ejercicio04() {
    Musica()
}

fun Musica() {
    class Cancion(val titulo: String, val artista: String, val anio: Int, val visita: Int) {
    }

    val Gorillaz = Cancion("Orange County", "Gorillaz", 2026, 1500)
    if (Gorillaz.visita <= 1000) {
        println("${Gorillaz.titulo}, interpretada por ${Gorillaz.artista}, se lanzo el año ${Gorillaz.anio}")
        println("La cancion NO es popular")
    } else {
        println("${Gorillaz.titulo}, interpretada por ${Gorillaz.artista}, se lanzo el año ${Gorillaz.anio}")
        println("La cancion SI es popular")
    }
}

fun ejercicio05() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        if (referrer == null) {
            println("Likes to $hobby. Doesn't have a referrer")
        } else {
            println("Likes to play $hobby. Has a referrer named ${referrer.name}, who likes to ${referrer.hobby}")
        }
    }
}

open class Phone(var isScreenLightOn: Boolean = false) {
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }

}

class FoldablePhone(var isFolded: Boolean = true) : Phone() {
    override fun switchOn() {
        if (isFolded) {
            isScreenLightOn = false
        } else {
            isScreenLightOn = true
        }
    }

    fun fold() {
        isFolded = true
    }

    fun unfold() {
        isFolded = false
    }
}

fun ejercicio06() {
    val s23FE = FoldablePhone()
    s23FE.switchOn()
    s23FE.checkPhoneScreenLight()
    s23FE.unfold()
    s23FE.switchOn()
    s23FE.checkPhoneScreenLight()
}

fun ejercicio07() {
    val winningBid = Bid(5000, "Private Collector")
    println("Item A is sold at ${auctionPrice(winningBid, 2000)}.")
    println("Item B is sold at ${auctionPrice(null, 3000)}.")
}

class Bid(val amount: Int, val bidder: String)

fun auctionPrice(bid: Bid?, minimumPrice: Int): Int {
    return bid?.amount ?: minimumPrice
}