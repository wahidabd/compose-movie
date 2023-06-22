package com.wahidabd.movieapps.ui.screen.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wahidabd.movieapps.ui.components.SearchBar
import kotlinx.coroutines.delay


/**
 * Created by Wahid on 6/22/2023.
 * Github github.com/wahidabd.
 */


@Composable
fun MovieScreen(
    modifier: Modifier = Modifier,
    setSearchMovie: (String) -> Unit,
    navigate: (String) -> Unit
) {
    val searchItems = remember { mutableStateOf("") }

    LaunchedEffect(searchItems.value) {
        delay(3000)
        setSearchMovie(searchItems.value)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 20.dp, end = 20.dp, start = 20.dp)
    ) {
        SearchBar(query = searchItems)
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun MovieScreenPreview() {
    MovieScreen(
        setSearchMovie = {},
        navigate = {}
    )
}