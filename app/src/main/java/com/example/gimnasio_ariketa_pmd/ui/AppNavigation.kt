package com.example.gimnasio_ariketa_pmd.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

/*
 * Esta función controla la navegación de toda la aplicación.
 *
 * Aquí definimos todas las pantallas y las rutas.
 */
@Composable
fun AppNavigation() {

    /*
     * NavController es el encargado de movernos
     * entre las diferentes pantallas.
     */
    val navController = rememberNavController()


    /*
     * NavHost contiene todas las rutas.
     */
    NavHost(

        navController = navController,

        /*
         * La primera pantalla que aparecerá
         * será Login.
         */
        startDestination = "login"

    ) {


        /*
         * -------------------------
         * LOGIN
         * -------------------------
         */
        composable("login") {

            LoginScreen(
                navController = navController
            )
        }


        /*
         * -------------------------
         * HOME
         * -------------------------
         *
         * Recibimos el rol:
         *
         * SUPER
         * o
         * LANGILEA
         */
        composable(

            route = "home/{rol}",

            arguments = listOf(

                navArgument("rol") {

                    type = NavType.StringType

                }
            )

        ) { backStackEntry ->

            /*
             * Obtenemos el rol de la URL.
             */
            val rol =
                backStackEntry
                    .arguments
                    ?.getString("rol")
                    ?: "LANGILEA"


            HomeScreen(

                navController =
                    navController,

                rol = rol
            )
        }


        /*
         * -------------------------
         * CLIENTES
         * -------------------------
         */
        composable("bezeroak") {

            BezeroakScreen(
                navController =
                    navController
            )
        }


        /*
         * -------------------------
         * TRABAJADORES
         * -------------------------
         */
        composable("langileak") {

            LangileakScreen(
                navController =
                    navController
            )
        }


        /*
         * -------------------------
         * CONTACTOS
         * -------------------------
         */
        composable("personas") {

            PersonasScreen()

        }
    }
}