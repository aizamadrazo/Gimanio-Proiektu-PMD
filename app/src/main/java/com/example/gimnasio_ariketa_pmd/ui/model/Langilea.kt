package com.example.gimnasio_ariketa_pmd.ui.model

class Langilea(

    /*
     * Datos heredados de Persona.
     */
    nan: String,
    izenAbizenak: String,
    generoa: String?,
    kontaktua: String,

    /*
     * Datos propios de un trabajador.
     */
    val erabiltzailea: String,
    val pasahitza: String,

    /*
     * Número de horas que trabaja al día.
     */
    val egunekoOrduak: Int,

    /*
     * Puesto del trabajador.
     *
     * Solo puede ser:
     * ZUZENDARIA
     * MONITOREA
     * IDAZKARIA
     */
    val kargua: Kargua

) : Persona(
    nan,
    izenAbizenak,
    generoa,
    kontaktua
) {

    /*
     * Implementamos el método abstracto de Persona.
     *
     * "override" significa que estamos sobrescribiendo
     * el método definido en la clase padre.
     */
    override fun bistaratu(): String {

        return "$izenAbizenak - $kargua"
    }
}