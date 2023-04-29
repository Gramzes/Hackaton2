package com.gramzin.composable2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(onNavigateToMain: () -> Unit){
    val coroutineScope  = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(200.dp)
                .clip(CircleShape).align(Alignment.Center)
        )
    }

    LaunchedEffect(key1 = Unit){
        coroutineScope.launch {
            delay(2000)
            onNavigateToMain()
        }
    }
}