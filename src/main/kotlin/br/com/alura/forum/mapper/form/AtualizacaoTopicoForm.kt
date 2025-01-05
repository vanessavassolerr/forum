package br.com.alura.forum.mapper.form

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class AtualizacaoTopicoForm(
    @field: NotNull
    val id: Long,
    @field: NotEmpty @field:Size(min=5, max=100)
    val titulo: String,
    val mensagem: String
)
