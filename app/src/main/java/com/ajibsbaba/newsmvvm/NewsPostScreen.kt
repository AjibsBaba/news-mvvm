package com.ajibsbaba.newsmvvm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsPostScreen(viewModel: NewsPostViewModel) {
    val newsPosts by viewModel.newsPosts.observeAsState(emptyList())
    val isLoading by viewModel.isLoading.observeAsState(initial = true)
    val error by viewModel.error.observeAsState(initial = null)

    LaunchedEffect(Unit) {
        viewModel.fetchNewsPosts()
    }

    Scaffold(topBar = {
        TopAppBar(title = { Text("NewsMVVM") })
    }) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(20.dp)) {
            when {
                isLoading -> {
                    NewsCard("Loading", "...")
                }

                error != null -> {
                    Text(text = "Error: $error")
                }

                newsPosts.isEmpty() -> {
                    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text = "No News Posts")
                    }

                }

                else -> {
                    LazyColumn {
                        items(newsPosts) { newsPost ->
                            NewsCard(newsPost.title, newsPost.description)
                        }
                    }
                }

            }
        }


    }
}


@Composable
@Preview(showBackground = true)
fun NewsCard(postTitle: String = "Post Title", postDescription: String = "Post Description") {
    Card(modifier = Modifier.height(180.dp), elevation = CardDefaults.cardElevation(
        defaultElevation = 1.dp
    )) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)) {
            Text(text = postTitle, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp))
            Text(text = postDescription, style = TextStyle(fontSize = 16.sp))
        }
    }
}