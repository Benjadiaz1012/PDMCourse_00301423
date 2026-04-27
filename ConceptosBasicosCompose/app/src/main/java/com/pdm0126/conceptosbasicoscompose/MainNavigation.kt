package com.pdm0126.conceptosbasicoscompose

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.conceptosbasicoscompose.screens.CuandranteCompose
import com.pdm0126.conceptosbasicoscompose.screens.adminTarea
import com.pdm0126.conceptosbasicoscompose.screens.articuloCompose


@Composable
fun basicoComposable() {
    val backStack = rememberNavBackStack(Routes.Home)
    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Home> {
                articuloCompose(
                    onNext = {
                        backStack.add(Routes.Pantalla1)
                    }
                )
            }
            entry<Routes.Pantalla1> {
                adminTarea(
                    onNext = {
                        backStack.add(Routes.Pantalla2)
                    })
            }
            entry<Routes.Pantalla2> {
                CuandranteCompose(
                    onNext = {
                        backStack.add(Routes.Home)
                    }
                )
            }
        }
    )
}