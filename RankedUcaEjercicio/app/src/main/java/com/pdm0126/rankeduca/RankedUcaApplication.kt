package com.pdm0126.rankeduca

import android.app.Application
import com.pdm0126.rankeduca.data.AppProvider

class RankedUcaApplication : Application() {
    val appProvider by lazy { AppProvider(this) }
}