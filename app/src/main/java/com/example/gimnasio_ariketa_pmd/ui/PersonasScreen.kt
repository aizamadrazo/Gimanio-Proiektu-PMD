package com.example.gimnasio_ariketa_pmd.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.gimnasio_ariketa_pmd.ui.data.GimnasioRepository
import com.example.gimnasio_ariketa_pmd.ui.model.Kontaktua

/*
 * Pantalla para gestionar contactos.
 */
@Composable
fun PersonasScreen() {

    var nan by remember {
        mutableStateOf("")
    }

    var izenAbizenak by remember {
        mutableStateOf("")
    }

    var kontaktua by remember {
        mutableStateOf("")
    }

    var mezua by remember {
        mutableStateOf("")
    }


    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ) {

        Text(
            text = "Kontaktuak"
        )


        OutlinedTextField(

            value = nan,

            onValueChange = {
                nan = it
            },

            label = {
                Text("NAN")
            }
        )


        OutlinedTextField(

            value = izenAbizenak,

            onValueChange = {
                izenAbizenak = it
            },

            label = {
                Text("Izen-abizenak")
            }
        )


        OutlinedTextField(

            value = kontaktua,

            onValueChange = {
                kontaktua = it
            },

            label = {
                Text("Email")
            }
        )


        /*
         * Crear contacto.
         */
        Button(

            onClick = {

                if (
                    nan.isBlank() ||
                    izenAbizenak.isBlank() ||
                    kontaktua.isBlank()
                ) {

                    mezua =
                        "Informazioa falta da"

                } else {

                    val kontaktuBerria = Kontaktua(

                        nan = nan,
                        izenAbizenak =
                            izenAbizenak,
                        generoa = null,
                        kontaktua = kontaktua
                    )


                    /*
                     * Comprobamos que el email
                     * tenga un formato mínimo válido.
                     */
                    if (
                        !kontaktuBerria
                            .kontaktuaBaliozkoa()
                    ) {

                        mezua =
                            "Email formatua ez da zuzena"

                    } else {

                        GimnasioRepository
                            .gehituKontaktua(
                                kontaktuBerria
                            )

                        mezua =
                            "Kontaktua ondo sortu da"

                        nan = ""
                        izenAbizenak = ""
                        kontaktua = ""
                    }
                }
            }

        ) {

            Text("GEHITU")

        }


        Text(mezua)


        /*
         * Lista de contactos.
         */
        LazyColumn {

            items(
                GimnasioRepository.kontaktuak
            ) { kontaktua ->

                Row(
                    modifier =
                        Modifier.fillMaxWidth()
                ) {

                    Text(
                        text =
                            kontaktua.bistaratu(),
                        modifier =
                            Modifier.weight(1f)
                    )


                    Button(
                        onClick = {

                            GimnasioRepository
                                .ezabatuKontaktua(
                                    kontaktua
                                )
                        }
                    ) {

                        Text("EZABATU")

                    }
                }
            }
        }
    }
}