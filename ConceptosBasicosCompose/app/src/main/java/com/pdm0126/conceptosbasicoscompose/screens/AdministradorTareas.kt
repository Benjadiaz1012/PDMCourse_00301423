package com.pdm0126.conceptosbasicoscompose.screens

import android.R.attr.fontWeight
import android.R.id.bold
import android.support.v4.os.IResultReceiver2
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pdm0126.conceptosbasicoscompose.R
import kotlin.io.encoding.Base64
import kotlin.random.Random


@Composable
fun adminTarea(onNext: () -> Unit) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ImageCheck(modifier = Modifier)
            Text(
                text = stringResource(R.string.all_tasks_completed),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            )
            Text(
                text = stringResource(R.string.nice_work),
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Button(onClick = onNext) { Text(text = "Avanzar") }
        }
    }
}

@Composable
fun ImageCheck(modifier: Modifier) {
    val check = painterResource(R.drawable.ic_task_completed)
    Image(
        painter = check,
        contentDescription = null,
        modifier = Modifier,
    )
}