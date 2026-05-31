package com.pdm0126.ejerciciopractico

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Route : NavKey{
    @Serializable
    data object Home : Route()
    @Serializable
    data object  Screen1 : Route()
}