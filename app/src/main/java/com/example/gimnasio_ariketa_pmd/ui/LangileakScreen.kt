package com.example.gimnasio_ariketa_pmd.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.navigation.NavController
import com.example.gimnasio_ariketa_pmd.ui.data.GimnasioRepository
import com.example.gimnasio_ariketa_pmd.ui.model.Kargua
import com.example.gimnasio_ariketa_pmd.ui.model.Langilea

/*
 * CRUD de trabajadores.
 *
 * Solo el SuperAdministrador puede acceder aquí.
 */
@Composable
fun LangileakScreen(
    navController: NavController
) {

    var nan by remember {
        mutableStateOf("")
    }

    var izenAbizenak by remember {
        mutableStateOf("")
    }

    var kontaktua by remember {
        mutableStateOf("")
    }

    var erabiltzailea by remember {
        mutableStateOf("")
    }

    var pasahitza by remember {
        mutableStateOf("")
    }

    var orduak by remember {
        mutableStateOf("")
    }

    /*
     * Para simplificar el ejercicio, inicialmente
     * utilizamos ZUZENDARIA como valor por defecto.
     */
    var kargua by remember {
        mutableStateOf(Kargua.ZUZENDARIA)
    }

    var mezua by remember {
        mutableStateOf("")
    }


    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ) {

        Text("Langileak")


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
                Text("Kontaktua")
            }
        )


        OutlinedTextField(
            value = erabiltzailea,
            onValueChange = {
                erabiltzailea = it
            },
            label = {
                Text("Erabiltzailea")
            }
        )


        OutlinedTextField(
            value = pasahitza,
            onValueChange = {
                pasahitza = it
            },
            label = {
                Text("Pasahitza")
            }
        )


        OutlinedTextField(
            value = orduak,
            onValueChange = {
                orduak = it
            },
            label = {
                Text("Eguneko orduak")
            }
        )


        /*
         * Botones para seleccionar el puesto.
         */
        Row(
            horizontalArrangement =
                Arrangement.spacedBy(5.dp)
        ) {

            Button(
                onClick = {
                    kargua = Kargua.ZUZENDARIA
                }
            ) {
                Text("Zuzendaria")
            }

            Button(
                onClick = {
                    kargua = Kargua.MONITOREA
                }
            ) {
                Text("Monitorea")
            }

            Button(
                onClick = {
                    kargua = Kargua.IDAZKARIA
                }
            ) {
                Text("Idazkaria")
            }
        }


        Spacer(
            modifier = Modifier.padding(5.dp)
        )


        /*
         * Crear trabajador.
         */
        Button(

            onClick = {

                if (
                    nan.isBlank() ||
                    izenAbizenak.isBlank() ||
                    erabiltzailea.isBlank() ||
                    pasahitza.isBlank() ||
                    orduak.isBlank()
                ) {

                    mezua =
                        "Informazioa falta da"

                } else {

                    val orduKopurua =
                        orduak.toIntOrNull()

                    if (orduKopurua == null) {

                        mezua =
                            "Ordu kopurua ez da zuzena"

                    } else {

                        val langilea = Langilea(

                            nan = nan,
                            izenAbizenak = izenAbizenak,
                            generoa = null,
                            kontaktua = kontaktua,
                            erabiltzailea =
                                erabiltzailea,
                            pasahitza =
                                pasahitza,
                            egunekoOrduak =
                                orduKopurua,
                            kargua = kargua
                        )

                        GimnasioRepository.gehituLangilea(
                            langilea
                        )

                        mezua =
                            "Langilea ondo sortu da"

                        nan = ""
                        izenAbizenak = ""
                        kontaktua = ""
                        erabiltzailea = ""
                        pasahitza = ""
                        orduak = ""
                    }
                }
            }

        ) {

            Text("GEHITU")

        }


        Text(mezua)


        /*
         * Lista de trabajadores.
         */
        LazyColumn {

            items(
                GimnasioRepository.langileak
            ) { langilea ->

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Text(
                        text =
                            langilea.bistaratu(),
                        modifier =
                            Modifier.weight(1f)
                    )

                    Button(
                        onClick = {

                            GimnasioRepository
                                .ezabatuLangilea(
                                    langilea
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