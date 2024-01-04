package com.ajibsbaba.newsmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.ajibsbaba.newsmvvm.ui.theme.NewsMVVMTheme

class MainActivity : ComponentActivity() {

    private val viewModel: NewsPostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           NewsMVVMTheme {
               NewsPostScreen(viewModel = viewModel)
           }
        }
    }
}