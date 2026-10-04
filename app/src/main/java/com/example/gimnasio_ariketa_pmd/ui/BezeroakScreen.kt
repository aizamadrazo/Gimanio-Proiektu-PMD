package com.example.gimnasio_ariketa_pmd.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gimnasio_ariketa_pmd.ui.data.GimnasioRepository
import com.example.gimnasio_ariketa_pmd.ui.model.Bezeroa

/*
 * Pantalla CRUD de clientes.
 */
@Composable
fun BezeroakScreen(
    navController: NavController
) {

    /*
     * Campos del formulario.
     */
    var nan by remember {
        mutableStateOf("")
    }

    var izenAbizenak by remember {
        mutableStateOf("")
    }

    var generoa by remember {
        mutableStateOf("")
    }

    var kontaktua by remember {
        mutableStateOf("")
    }

    var altaData by remember {
        mutableStateOf("")
    }

    var diruSarrera by remember {
        mutableStateOf("")
    }

    /*
     * Mensaje que mostramos al usuario.
     */
    var mezua by remember {
        mutableStateOf("")
    }


    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ) {

        Text(
            text = "Bezeroak"
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )


        /*
         * DNI.
         */
        OutlinedTextField(

            value = nan,

            onValueChange = {
                nan = it
            },

            label = {
                Text("NAN")
            },

            modifier = Modifier.fillMaxWidth()
        )


        /*
         * Nombre y apellidos.
         */
        OutlinedTextField(

            value = izenAbizenak,

            onValueChange = {
                izenAbizenak = it
            },

            label = {
                Text("Izen-abizenak")
            },

            modifier = Modifier.fillMaxWidth()
        )


        /*
         * Género.
         */
        OutlinedTextField(

            value = generoa,

            onValueChange = {
                generoa = it
            },

            label = {
                Text("Generoa")
            },

            modifier = Modifier.fillMaxWidth()
        )


        /*
         * Contacto.
         */
        OutlinedTextField(

            value = kontaktua,

            onValueChange = {
                kontaktua = it
            },

            label = {
                Text("Kontaktua")
            },

            modifier = Modifier.fillMaxWidth()
        )


        /*
         * Fecha de alta.
         */
        OutlinedTextField(

            value = altaData,

            onValueChange = {
                altaData = it
            },

            label = {
                Text("Alta-data")
            },

            modifier = Modifier.fillMaxWidth()
        )


        /*
         * Dinero.
         */
        OutlinedTextField(

            value = diruSarrera,

            onValueChange = {
                diruSarrera = it
            },

            label = {
                Text("Diru-sarrera")
            },

            modifier = Modifier.fillMaxWidth()
        )


        Spacer(
            modifier = Modifier.height(10.dp)
        )


        /*
         * Botón para crear el cliente.
         */
        Button(

            onClick = {

                /*
                 * Comprobamos que los campos obligatorios
                 * tengan información.
                 */
                if (
                    nan.isBlank() ||
                    izenAbizenak.isBlank() ||
                    altaData.isBlank() ||
                    diruSarrera.isBlank()
                ) {

                    mezua = "Informazioa falta da"

                } else {

                    /*
                     * Intentamos convertir el dinero
                     * de String a Double.
                     */
                    val dirua = diruSarrera.toDoubleOrNull()

                    if (dirua == null) {

                        mezua = "Diru-sarrera ez da zuzena"

                    } else {

                        /*
                         * Creamos el objeto Bezeroa.
                         */
                        val bezeroa = Bezeroa(

                            nan = nan,
                            izenAbizenak = izenAbizenak,
                            generoa =
                                generoa.ifBlank { null },
                            kontaktua = kontaktua,
                            altaData = altaData,
                            diruSarrera = dirua

                        )

                        /*
                         * Lo añadimos al Repository.
                         */
                        GimnasioRepository.gehituBezeroa(
                            bezeroa
                        )

                        /*
                         * Informamos al usuario.
                         */
                        mezua =
                            "Bezeroa ondo sortu da"

                        /*
                         * Limpiamos el formulario.
                         */
                        nan = ""
                        izenAbizenak = ""
                        generoa = ""
                        kontaktua = ""
                        altaData = ""
                        diruSarrera = ""
                    }
                }
            }

        ) {

            Text("GEHITU")

        }


        /*
         * Mostramos el mensaje.
         */
        Text(mezua)


        Spacer(
            modifier = Modifier.height(20.dp)
        )


        /*
         * Lista de clientes.
         */
        LazyColumn(

            verticalArrangement =
                Arrangement.spacedBy(10.dp)

        ) {

            items(
                GimnasioRepository.bezeroak
            ) { bezeroa ->

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    /*
                     * Información del cliente.
                     */
                    Text(
                        text = bezeroa.bistaratu(),
                        modifier = Modifier.weight(1f)
                    )


                    /*
                     * Botón eliminar.
                     */
                    Button(

                        onClick = {

                            GimnasioRepository.ezabatuBezeroa(
                                bezeroa
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