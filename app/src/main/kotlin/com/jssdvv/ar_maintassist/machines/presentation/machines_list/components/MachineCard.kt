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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jssdvv.ar_maintassist.R
import com.jssdvv.ar_maintassist.core.presentation.navigation.graphs.MachineDataDestination

@Composable
fun MachineCard(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    onNavigateToMachineData: @Composable () -> Unit
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
                painter = painterResource(id = R.drawable.compresor),
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
            Text(
                text = "Máquinas de aprovechamiento de fluidos",
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = "Compresor FIAC de 3HP",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(
                modifier = Modifier.padding(16.dp)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Compresor reciprocante de 3 pistones de 3 HP y 3650 RPM, ubicado en el laboratorio de potencia fluida de la escuela de ingeniería mecánica de la Universidad Industrial de Santander (UIS)",
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
                    Text(text = "Mantenimientos")
                }
                OutlinedButton(onClick = {

                }) {
                    Text(text = "Ficha Técnica")
                }

            }
        }
    }
}