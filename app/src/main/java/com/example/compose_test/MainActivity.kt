package com.example.compose_test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scrollState = rememberScrollState()
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
//                ListView(scrollState)
//                LazyColumnView()
                ImageCard()
            }
        }
    }
}

//ListView (Flutter : ListView)
@Composable
fun ListView(scrollState: ScrollState) {
    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .fillMaxWidth()
    ) {
        for (i in 1..50) {
            Text("Item $i")
        }
    }
}

//lazyColumn (Flutter : ListView.builder)
@Composable
fun LazyColumnView() {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text("Header")
        }
        items(50) { index ->
            Text("Item $index")
        }
        item {
            Text("Footer")
        }
    }
}

// Column, Row, Box
@Composable
fun ColumnView() {
    Column {
        Text("Item 1")
        Text("Item 2")
        Text("Item 3")
    }
}

@Composable
fun RowView() {
    Row {
        Text("Item 1")
        Text("Item 2")
        Text("Item 3")
    }
}

@Composable
fun BoxView() {
    Box {
        Text("Item 1")
        Text("Item 2")
        Text("Item 3")
    }
}

// image card
@Composable
fun ImageCard() {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .border(1.dp, Green, shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
    ) {
        Text("This is Image Card")
    }
}

//@Composable
//fun MarsPhotoCard(photo: MarsPhoto, modifier: Modifier = Modifier) {
//    AsyncImage(
//        model = ImageRequest.Builder(context = LocalContext.current)
//            .data(photo.imgSrc)
//            .crossfade(true)
//            .build(),
//        error = painterResource(R.drawable.ic_broken_image),
//        placeholder = painterResource(R.drawable.loading_img),
//        contentDescription = stringResource(R.string.mars_photo),
//        contentScale = ContentScale.Crop
//    )
//}
