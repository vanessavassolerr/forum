package br.com.alura.forum.mapper.form

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class AtualizacaoTopicoForm(
    @field: NotNull
    val id: Long,
    @field: NotEmpty @field:Size(min=5, max=100, message = "Titulo deve ter entre 5 a 100 caracteres")
    val titulo: String,
    @field: NotEmpty @field:Size(min=5, max=100, message = "Mensagem deve ter entre 5 a 100 caracteres")
    val mensagem: String
)
