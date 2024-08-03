package com.example.details_screen.ui.screens


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.details_screen.R


@Composable
fun Item(text: String, icon: @Composable (() -> Unit)) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium
        )
        icon()
    }

}

@Composable
fun DetailsScreen(
    repo: Repo,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = repo.imageUrl),
            modifier = Modifier.size(150.dp),
            contentDescription = repo.name
        )
        Text(
            text = repo.name,
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.ExtraBold),
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Item(
                text = repo.stars.toString(),
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.star),
                        tint = Color.Yellow,
                        contentDescription = repo.stars.toString() + " stars",
                        modifier = Modifier.size(40.dp)
                    )
                }
            )
            Item(
                text = repo.language,
                icon = {
                    Canvas(modifier = Modifier.size(22.dp)) {
                        drawCircle(color = Color.Blue, radius = size.minDimension / 2)
                    }
                }
            )
            Item(
                text = repo.forks.toString(),
                icon = {
                    Icon(
                        painter = painterResource(id = R.drawable.repo_forked),
                        contentDescription = repo.forks.toString() + " forks",
                        modifier = Modifier.size(40.dp)
                    )
                }
            )
        }
        Text(
            text = repo.description,
            style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp),
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth(.9f)
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { /*TODO*/ },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth(.9f)
        ) {
            Text(
                text = stringResource(R.string.show_issues),
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.ExtraBold)
            )

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(
        repo = Repo(
            imageUrl = R.drawable.google,
            name = "language",
            language = "Python",
            stars = 1525,
            forks = 347,
            description = "Shared repository for open-sourced projects from the Google AI Language team."
        )
    )
}