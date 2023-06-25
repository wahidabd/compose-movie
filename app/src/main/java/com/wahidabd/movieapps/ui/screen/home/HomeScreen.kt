package com.wahidabd.movieapps.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.wahidabd.movieapps.R
import com.wahidabd.movieapps.ui.theme.AppOnPrimaryColor
import com.wahidabd.movieapps.ui.theme.Dark


/**
 * Created by Wahid on 6/23/2023.
 * Github github.com/wahidabd.
 */


@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator?
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Dark)
    ) {
        ProfileAndSearchBar(navigator = navigator)
    }
}

@Composable
fun ProfileAndSearchBar(
    navigator: DestinationsNavigator?,
    // viewmodel
) {
    Row(
        modifier = Modifier
            .padding(top = 12.dp, end = 8.dp, start = 8.dp, bottom = 4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Box(
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(53.dp)
                    .clip(CircleShape)
            )
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(AppOnPrimaryColor)
            )
            IconButton(onClick = {
                // OnClick
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_person_profile),
                    tint = AppOnPrimaryColor,
                    modifier = Modifier.size(32.dp),
                    contentDescription = null,
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Movie"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navigator = null)
}