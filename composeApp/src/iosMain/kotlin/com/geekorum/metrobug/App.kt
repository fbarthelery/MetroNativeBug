package com.geekorum.metrobug

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import dev.zacsweers.metro.createGraph

@Composable
fun App() {
    val graph = remember {
        createGraph<AppGraph>()
    }
    println("injected string ${graph.injectedString}")
    BasicText("injected string ${graph.injectedString}", Modifier.fillMaxSize().wrapContentSize())
}