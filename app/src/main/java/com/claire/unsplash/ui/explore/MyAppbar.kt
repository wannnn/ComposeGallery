package com.claire.unsplash.ui.explore

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.FilterVintage
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.claire.unsplash.R
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.insets.ui.TopAppBar

@Composable
fun MyAppbar() {

    // We use TopAppBar from accompanist-insets-ui which allows us to provide
    // content padding matching the system bars insets.
    TopAppBar(
        contentPadding = rememberInsetsPaddingValues(
            insets = LocalWindowInsets.current.statusBars
        ),
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.app_name),
                fontWeight = FontWeight.Bold
            )
        },
        backgroundColor = Color.Transparent,
        navigationIcon = {
            IconButton(onClick = {

            }) {
                Icon(Icons.TwoTone.FilterVintage, contentDescription = null)
            }
        },
        elevation = 0.dp
    )
}

@Preview("default")
@Preview("dark theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MyAppbarPreview() {
    MyAppbar()
}