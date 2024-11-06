package com.example.ucppertama

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.belajaraja.R

@Preview(showBackground = true)
@Composable

fun DataDiri(modifier: Modifier = Modifier){
    Column (modifier = Modifier.fillMaxSize()){
        HeaderSection()
        BagianData()
    }
}

@Composable
fun HeaderSection(){
    var nama by remember { mutableStateOf("") }
    var namasv by remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color(0xFF0E91F3))
        .padding(15.dp)){
        Row (modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween){
            Column {
                Text(
                    text = "Halo, ",
                    fontSize = 30.sp,
                    color = Color.White,
                )
                Text(
                    text = "Isro Usman",
                    fontSize = 30.sp,
                    color = Color.White,
                )

            }
            Box(
                contentAlignment = Alignment.BottomStart
            ){
                Image(
                    painter = painterResource(id = R.drawable.umy),
                    contentDescription = "",
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}

@Composable
fun BagianData(){
    var nama by remember { mutableStateOf("") }
    var noTelepon by remember { mutableStateOf("") }
    var Jk by remember { mutableStateOf("") }

    var namasv by remember { mutableStateOf("") }
    var noTeleponsv by remember { mutableStateOf("") }
    var Jksv by remember { mutableStateOf("") }

    val listJK = listOf("Laki-laki", "Perempuan")

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(
            text = "Yuk lengkapi data dirimu, ",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(top = 15.dp, bottom = 15.dp)
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            value = nama,
            onValueChange = { nama = it },
            label = { Text("Masukkan Nama") }
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
            value = noTelepon,
            onValueChange = { noTelepon = it },
            label = { Text("Masukkan No Telepon") }
        )
        Text(
            text = "Jenis Kelamin",
            fontSize = 18.sp,
            color = Color.Black,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(start = 5.dp, top = 15.dp, bottom = 5.dp)
                .fillMaxWidth()
        )
        Row {
            listJK.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(
                        selected = Jk == item,
                        onClick = {
                            Jk = item
                        }
                    )
                    Text(item)
                }
            }
        }
        Button(modifier = Modifier.fillMaxWidth(),
            onClick = {
                namasv = nama
                noTeleponsv = noTelepon
                Jksv = Jk
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0E91F3),
                contentColor = Color.White
            )
        ) {
            Text(text = "Simpan")
        }
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        ElevatedCard (modifier = Modifier
            .fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFD4D4D4))){
            Text(
                text = "Nomor Handphone",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 18.dp, top = 15.dp, bottom = 1.dp)
            )
            Row {
                ElevatedCard (modifier = Modifier.padding(start = 20.dp, end = 20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF0E91F3))){
                    Row (modifier = Modifier.fillMaxWidth()){
                        Icon(imageVector = Icons.Filled.Call, contentDescription =null)
                        Text(text = ":")
                        DetailSurat(isinya = noTeleponsv)
                    }
                }
            }
            Text(
                text = "Jenis Kelamin",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.padding(start = 18.dp, top = 15.dp, bottom = 1.dp)
            )
            Row {
                ElevatedCard (modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 20.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF0E91F3))){
                    Row (modifier = Modifier.fillMaxWidth(),){
                        Icon(imageVector = Icons.Filled.Person, contentDescription =null)
                        Text(text = ":")
                        DetailSurat(isinya = Jksv)
                    }
                }
            }
        }

    }
}

@Composable
fun DetailSurat(isinya:String){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        ){
        Text(text = isinya, modifier = Modifier.weight(2f))
    }
}