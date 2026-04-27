package com.pdm0126.conceptosbasicoscompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pdm0126.conceptosbasicoscompose.R
import com.pdm0126.conceptosbasicoscompose.Routes

@Composable
fun articuloCompose(onNext: () -> Unit) {
    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            BgImage(
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = stringResource(R.string.title_text),
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                fontSize = 24.sp
            )
            Text(
                text = stringResource(R.string.main_text),
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            )
            Text(
                text = stringResource(R.string.last_text),
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp)
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center,
            ) {
                Button(
                    onClick = onNext,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Avanzar"
                    )
                }
            }
        }
    }
}

@Composable
fun BgImage(modifier: Modifier = Modifier) {
    val bg = painterResource(R.drawable.bg_compose_background)
    Image(
        painter = bg,
        contentDescription = null,
        modifier = modifier
    )
}