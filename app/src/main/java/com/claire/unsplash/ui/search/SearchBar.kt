package com.claire.unsplash.ui.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.claire.unsplash.ui.theme.*

@Composable
fun SearchBar() {

    var textState by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxWidth()
            .background(black)
    ) {
        TextField(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            value = textState,
            onValueChange = {
                textState = it
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = null,
                    tint = gray_88
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = white,
                backgroundColor = gray_4a,
                cursorColor = white,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )
    }


}

@Preview
@Composable
fun DefaultSearchBarPreview() {
    UnsplashTheme {
        SearchBar()
    }
}