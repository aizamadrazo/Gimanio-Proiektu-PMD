package com.example.gimnasio_ariketa_pmd.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

/*
 * Pantalla principal después del login.
 */
@Composable
fun HomeScreen(
    navController: NavController,
    rol: String
) {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),

        verticalArrangement = Arrangement.spacedBy(15.dp)

    ) {

        /*
         * Título.
         */
        Text(
            text = "Txurdiko Gimnasioa"
        )


        /*
         * Indicamos qué tipo de usuario ha iniciado sesión.
         */
        Text(
            text = "Rol: $rol"
        )


        /*
         * Todo el mundo puede acceder a clientes.
         *
         * Tanto SUPER como LANGILEA.
         */
        Button(
            onClick = {

                navController.navigate("bezeroak")

            }
        ) {

            Text("Bezeroak")

        }


        /*
         * Solo SUPER puede gestionar trabajadores.
         */
        if (rol == "SUPER") {

            Button(
                onClick = {

                    navController.navigate("langileak")

                }
            ) {

                Text("Langileak")

            }


            /*
             * Solo SUPER puede gestionar contactos.
             */
            Button(
                onClick = {

                    navController.navigate("personas")

                }
            ) {

                Text("Kontaktuak")

            }
        }


        /*
         * Cerrar sesión.
         */
        Button(
            onClick = {

                /*
                 * Volvemos al login.
                 *
                 * popUpTo elimina la pantalla anterior
                 * de la pila de navegación.
                 */
                navController.navigate("login") {

                    popUpTo("login") {
                        inclusive = true
                    }
                }
            }
        ) {

            Text("Amaitu saioa")

        }
    }
}