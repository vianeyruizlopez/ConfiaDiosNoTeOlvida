package com.example.confiadiosnoteolvida.Tarjeta.presentation.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.confiadiosnoteolvida.Tarjeta.presentation.componentes.TarjetasCard
import com.example.confiadiosnoteolvida.Tarjeta.presentation.viewmodels.TarjetasViewModel
import com.example.confiadiosnoteolvida.Tarjeta.presentation.viewmodels.TarjetasViewModelFactory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TarjetasScreen(factoryTarjetas: TarjetasViewModelFactory) {
    val viewModel: TarjetasViewModel = viewModel(factory = factoryTarjetas)
    val uiEstado by viewModel.uiEstado.collectAsStateWithLifecycle()

    var buscarText by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Column {
                TopAppBar(
                    title = { Text("Confia") },
                )
                OutlinedTextField(
                    value = buscarText,
                    onValueChange = {
                        buscarText = it
                        viewModel.filtrarTarjetas(it)
                    },
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    placeholder = { Text("Buscar categoría o texto...") },
                    leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) }
                )
                Row(Modifier.horizontalScroll(rememberScrollState()).padding(8.dp)) {
                    Button(onClick = { viewModel.filtrarTarjetas("Ansiedad") }) { Text("Ansiedad") }
                    Spacer(Modifier.width(8.dp))
                    Button(onClick = { viewModel.filtrarTarjetas("Felicidad") }) { Text("Felicidad") }
                    Spacer(Modifier.width(8.dp))
                    Button(onClick = { viewModel.filtrarTarjetas("Tristeza") }) { Text("Tristeza") }
                    Spacer(Modifier.width(8.dp))
                    Button(onClick = { viewModel.filtrarTarjetas("Agradecida") }) { Text("Agradecida") }
                    Spacer(Modifier.width(8.dp))
                    Button(onClick = { viewModel.filtrarTarjetas("Administrar") }) { Text("Administrar") }

                }
            }

        }
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(uiEstado.Tarjetas) { tarjeta ->
                TarjetasCard(
                    id = tarjeta.id,
                    texto = tarjeta.texto,
                    cita = tarjeta.cita,
                    categoria = tarjeta.categoria
                )
            }
        }
    }
}
