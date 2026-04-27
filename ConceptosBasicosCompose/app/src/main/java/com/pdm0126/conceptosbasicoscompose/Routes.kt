package com.pdm0126.conceptosbasicoscompose

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes : NavKey{
    @Serializable
    data object Home : Routes()
    @Serializable
    data object Pantalla1 : Routes()
    @Serializable
    data object Pantalla2 : Routes()
}
