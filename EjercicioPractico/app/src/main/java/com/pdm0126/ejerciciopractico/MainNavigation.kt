package com.pdm0126.ejerciciopractico

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.ejerciciopractico.screens.Home.Home
import com.pdm0126.ejerciciopractico.screens.Screen1.Screen1

@Composable
fun MainNavigation() {
    val backStack = rememberNavBackStack(Route.Home)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Route.Home> {
                Home(
                    onNext = { backStack.add(Route.Screen1) }
                )
            }
            entry<Route.Screen1> {
                Screen1(
                    onBack = {backStack.removeLastOrNull()}
                )
            }
        }
    )
}