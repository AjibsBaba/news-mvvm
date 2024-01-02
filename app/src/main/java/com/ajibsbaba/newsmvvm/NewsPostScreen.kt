package com.ajibsbaba.newsmvvm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState

@Composable
fun NewsPostScreen(viewModel: NewsPostViewModel) {
    val newsPosts by viewModel.newsPosts.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchNewsPosts()
    }

    Column {
        if (newsPosts.isEmpty()) {
            Text("Loading")
        } else {
            LazyColumn {
                items(newsPosts) {
                    newsPost ->
                    Text(newsPost.title)
                    Text(newsPost.description)
                }
            }
        }
    }
}