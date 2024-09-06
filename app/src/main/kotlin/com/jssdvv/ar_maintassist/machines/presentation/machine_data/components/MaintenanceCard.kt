package com.jssdvv.ar_maintassist.machines.presentation.machine_data.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.ArCameraDestination

@Composable
fun MaintenanceCard(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    imgId: Int,
    title: String,
    description: String,
) {
    ElevatedCard(
        modifier = modifier,
        onClick = {

        }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = imgId),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16 / 9f)
                    .clip(CardDefaults.shape),
                contentScale = ContentScale.Crop,
            )
            Spacer(
                modifier = Modifier.padding(4.dp)
            )
            Spacer(
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = title,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(
                modifier = Modifier.padding(16.dp)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = description,
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(
                modifier = Modifier.padding(8.dp)
            )

            Row {
                FilledTonalButton(onClick = { navHostController.navigate(ArCameraDestination) }) {
                    Text(text = "Iniciar sesión RA")
                }
            }
        }
    }
}