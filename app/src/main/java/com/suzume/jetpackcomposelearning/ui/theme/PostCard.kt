package com.suzume.jetpackcomposelearning.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.suzume.jetpackcomposelearning.R

@Composable
fun PostCard() {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(8.dp)) {
            PostHeader()
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = stringResource(R.string.template_text))
            Image(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
                painter = painterResource(id = R.drawable.template_post_image_dark),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            PostStatistics()
        }
    }
}

@Composable
private fun PostHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(48.dp),
            painter = painterResource(id = R.drawable.ic_icon_github),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = "/github.com/null",
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "15:00",
                color = MaterialTheme.colors.onSecondary
            )
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null,
            tint = MaterialTheme.colors.onSecondary
        )
    }
}

@Composable
private fun PostStatistics() {
    Row(

    ) {
        Row(modifier = Modifier.weight(1f)) {
            IconWithText(
                R.drawable.ic_visibility,
                "2345"
            )
        }
        Row(modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween) {
            IconWithText(R.drawable.ic_share, "123")
            IconWithText(R.drawable.ic_comment, "25")
            IconWithText(R.drawable.ic_like, "777")
        }
    }
}

@Composable
private fun IconWithText(
    iconResId: Int,
    text: String,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            tint = MaterialTheme.colors.onSecondary
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            color = MaterialTheme.colors.onSecondary
        )
    }
}

@Preview
@Composable
private fun PreviewLight() {
    JetpackComposeLearningTheme(darkTheme = false) {
        PostCard()
    }
}

@Preview
@Composable
private fun PreviewDark() {
    JetpackComposeLearningTheme(darkTheme = true) {
        PostCard()
    }
}