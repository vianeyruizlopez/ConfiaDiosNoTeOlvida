package com.example.confiadiosnoteolvida.Tarjeta.presentation.componentes

import android.R
import android.R.attr.text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun TarjetasCard(
    id:Int,
    texto:String,
    cita:String,
    categoria:String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
       Row(
           modifier = Modifier.fillMaxWidth(),
           verticalAlignment = Alignment.CenterVertically
       ) {
           Text(
               text = "$id",
               style = MaterialTheme.typography.displayLarge
           )
           Column(modifier = Modifier
               .padding(horizontal = 16.dp)
               .fillMaxWidth()
           ){
               Text(
                   text = texto,
                   style = MaterialTheme.typography.titleLarge,
                   fontWeight = FontWeight.Bold,
                   maxLines = 1,
                   overflow = TextOverflow.Ellipsis
               )

               Spacer(modifier = Modifier.height(4.dp))
               Text(
                   text = cita,
                   style = MaterialTheme.typography.titleLarge,
                   fontWeight = FontWeight.Bold,
                   maxLines = 1,
                   overflow = TextOverflow.Ellipsis
               )

               Spacer(modifier = Modifier.height(4.dp))
               Text(
                   text = categoria,
                   style = MaterialTheme.typography.titleLarge,
                   fontWeight = FontWeight.Bold,
                   maxLines = 1,
                   overflow = TextOverflow.Ellipsis
               )

               Spacer(modifier = Modifier.height(4.dp))
           }

       }
    }
}
