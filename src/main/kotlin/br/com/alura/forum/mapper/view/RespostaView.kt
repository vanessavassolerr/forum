package br.com.alura.forum.mapper.view

import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import java.time.LocalDateTime

data class RespostaView(
    var id: Long? = null,
    val mensagem: String,
    val data: LocalDateTime = LocalDateTime.now(),
    val autor: Usuario,
    var topico: Topico,
    val solucao: Boolean,
)