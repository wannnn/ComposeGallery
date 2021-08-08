package com.claire.composegallery.ui.photographer

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.claire.composegallery.R
import com.claire.composegallery.ui.theme.ComposeGalleryTheme

@Composable
fun PhotographerPage() {

    Scaffold(
        topBar = { MyAppBar() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            PhotographerInfo()
        }
    }
}

@Composable
fun MyAppBar() {
    TopAppBar(
        elevation = 8.dp,
        content = {
            Text(
                text = "Tory Hallenburg",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                modifier = Modifier.padding(start = 12.dp)
            )
        }
    )
}

@Composable
fun PhotographerInfo() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        Image(
            painter = rememberImagePainter(
                data = "https://picsum.photos/id/103/200",
                builder = {
                    transformations(CircleCropTransformation())
                }
            ),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )

        ConnectedBox(listOf(
            R.drawable.ic_round_person_add_24,
            R.drawable.ic_round_mail_24,
            R.drawable.ic_round_link_24))
    }

    ImgText(R.drawable.ic_round_location_on_24, "Salt Lake City")

    Spacer(Modifier.size(16.dp))

    Text(text = "Download free, beautiful high-quality photos curated by Nick.")
}

@Composable
fun ConnectedBox(icons: List<Int>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        icons.forEach {
            OutlinedButton(
                onClick = {  },
                border = BorderStroke(1.dp, Color.LightGray),
                shape = RoundedCornerShape(8),
                modifier = Modifier.shadow(3.dp)
            ) {
                Image(
                    painter = painterResource(it),
                    contentDescription = null,
                    modifier = Modifier.size(26.dp)
                )
            }
        }
    }
}

@Composable
fun ImgText(img: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(img),
            contentDescription = null,
            modifier = Modifier.size(20.dp)
        )
        Spacer(Modifier.size(5.dp))
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeGalleryTheme {
        PhotographerPage()
    }
}