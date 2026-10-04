package com.example.gimnasio_ariketa_pmd.ui.data

import com.example.gimnasio_ariketa_pmd.ui.model.Bezeroa
import com.example.gimnasio_ariketa_pmd.ui.model.Kargua
import com.example.gimnasio_ariketa_pmd.ui.model.Kontaktua
import com.example.gimnasio_ariketa_pmd.ui.model.Langilea

/*
 * Repository
 *
 * Esta clase se encarga de guardar y gestionar
 * los datos de nuestro gimnasio.
 *
 * De momento utilizamos listas en memoria.
 *
 * IMPORTANTE:
 * Si cierras la aplicación, estos datos desaparecen.
 *
 * Más adelante podemos sustituir esto por Room/SQLite.
 */
object GimnasioRepository {

    /*
     * Lista de trabajadores.
     */
    val langileak = mutableListOf<Langilea>()

    /*
     * Lista de clientes.
     */
    val bezeroak = mutableListOf<Bezeroa>()

    /*
     * Lista de contactos.
     */
    val kontaktuak = mutableListOf<Kontaktua>()


    /*
     * Trabajador que utilizaremos para hacer pruebas.
     *
     * De esta forma podemos entrar en la aplicación
     * sin tener que crear primero un trabajador.
     */
    init {

        langileak.add(

            Langilea(
                nan = "11111111A",
                izenAbizenak = "Admin Gimnasioa",
                generoa = null,
                kontaktua = "admin@gmail.com",
                erabiltzailea = "admin",
                pasahitza = "1234",
                egunekoOrduak = 8,
                kargua = Kargua.ZUZENDARIA
            )

        )
    }


    /*
     * Comprueba el login.
     *
     * Primero comprobamos si es el SuperAdministrador.
     *
     * Después buscamos si existe un trabajador con ese
     * usuario y contraseña.
     *
     * Devuelve:
     *
     * "SUPER"  -> si es SuperAdministrador
     * "LANGILEA" -> si es trabajador
     * null -> si los datos son incorrectos
     */
    fun login(
        erabiltzailea: String,
        pasahitza: String
    ): String? {

        /*
         * SuperAdministrador.
         *
         * Estos son los datos que aparecen en el enunciado.
         */
        if (
            erabiltzailea == "super@super.gmail" &&
            pasahitza == "super"
        ) {
            return "SUPER"
        }

        /*
         * Buscamos un trabajador con esos datos.
         */
        val langilea = langileak.find {

            it.erabiltzailea == erabiltzailea &&
                    it.pasahitza == pasahitza

        }

        /*
         * Si encontramos un trabajador devolvemos LANGILEA.
         */
        if (langilea != null) {
            return "LANGILEA"
        }

        /*
         * Si no hemos encontrado nada,
         * el login es incorrecto.
         */
        return null
    }


    /*
     * Añadir un nuevo cliente.
     */
    fun gehituBezeroa(bezeroa: Bezeroa) {

        bezeroak.add(bezeroa)
    }


    /*
     * Eliminar un cliente.
     */
    fun ezabatuBezeroa(bezeroa: Bezeroa) {

        bezeroak.remove(bezeroa)
    }


    /*
     * Añadir un nuevo trabajador.
     */
    fun gehituLangilea(langilea: Langilea) {

        langileak.add(langilea)
    }


    /*
     * Eliminar un trabajador.
     */
    fun ezabatuLangilea(langilea: Langilea) {

        langileak.remove(langilea)
    }


    /*
     * Añadir un contacto.
     */
    fun gehituKontaktua(kontaktua: Kontaktua) {

        kontaktuak.add(kontaktua)
    }


    /*
     * Eliminar un contacto.
     */
    fun ezabatuKontaktua(kontaktua: Kontaktua) {

        kontaktuak.remove(kontaktua)
    }
}