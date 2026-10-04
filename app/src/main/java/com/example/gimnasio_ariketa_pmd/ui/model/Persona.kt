package com.example.gimnasio_ariketa_pmd.ui.model

abstract class Persona(
    nan: String,
    val izenAbizenak: String,
    val generoa: String?,
    val kontaktua: String
) {
    val nan: String = nan.uppercase()

    abstract fun bistaratu(): String
}