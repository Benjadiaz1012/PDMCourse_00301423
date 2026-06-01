package com.pdm0126.appmovienew

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.pdm0126.appmovienew.screens.Home.HomeScreen
import com.pdm0126.appmovienew.screens.MovieList.MovieListScreen

@Composable
fun MainNavigation(){
    val backStack = rememberNavBackStack(Routes.Home)
    NavDisplay(
        backStack = backStack,
        onBack =  {backStack.removeLastOrNull()},
        entryProvider = entryProvider {
            entry<Routes.Home>{
                HomeScreen(onNext ={backStack.add(Routes.MovieList)})
            }
            entry<Routes.MovieList> {
                MovieListScreen()
            }
        }
    )
}