package com.jssdvv.ar_maintassist.machines.presentation.machines_list.components

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
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jssdvv.ar_maintassist.R
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.MachineDataDestination
import com.jssdvv.ar_maintassist.machines.domain.models.MachineEntity

@Composable
fun MachineCard(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    machineEntity: MachineEntity,
    onNavigateToMachineData: @Composable () -> Unit
) {
    ElevatedCard(
        modifier = modifier,
        onClick = { }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.compresor),
                contentDescription = stringResource(R.string.machine_image_content_description),
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16 / 9f)
                    .clip(CardDefaults.shape),
                contentScale = ContentScale.Crop,
            )
            Spacer(
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = machineEntity.category,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = machineEntity.name,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(
                modifier = Modifier.padding(16.dp)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = machineEntity.description,
                textAlign = TextAlign.Justify,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(
                modifier = Modifier.padding(8.dp)
            )

            Row {
                FilledTonalButton(
                    onClick = { navHostController.navigate(MachineDataDestination) },
                ) {
                    Text(text = stringResource(R.string.activity_button_label))
                }
                OutlinedButton(onClick = {

                }) {
                    Text(text = stringResource(R.string.technical_sheet_button_label))
                }

            }
        }
    }
}