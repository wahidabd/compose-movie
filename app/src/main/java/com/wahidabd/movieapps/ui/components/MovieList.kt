package com.wahidabd.movieapps.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


/**
 * Created by Wahid on 6/23/2023.
 * Github github.com/wahidabd.
 */


@Composable
fun MovieList(
    modifier: Modifier = Modifier,
    navigate: (Int) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.SpaceBetween,
        contentPadding = PaddingValues(bottom = 20.dp)
    ){

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MovieListPreview() {
    MovieList(
        navigate = {}
    )
}