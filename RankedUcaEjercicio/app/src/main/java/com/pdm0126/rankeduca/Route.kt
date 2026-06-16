package com.pdm0126.rankeduca

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface Routes : NavKey {

    @Serializable
    data object Questions : Routes

    @Serializable
    data class Options(
        val questionId: Int
    ) : Routes
}