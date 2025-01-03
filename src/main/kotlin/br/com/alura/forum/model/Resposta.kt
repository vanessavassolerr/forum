package br.com.alura.forum.model

import java.time.LocalDateTime
import java.util.*

data class Resposta(
    var id: Long? = null,
    val mensagem: String,
    val data: LocalDateTime = LocalDateTime.now(),
    val autor: Usuario,
    var topico: Topico,
    val solucao: Boolean,
    )
