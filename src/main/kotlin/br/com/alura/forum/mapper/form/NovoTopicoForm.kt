package br.com.alura.forum.mapper.form

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import kotlin.math.min
// DTO (Data Transfer Object) usado para receber os dados de entrada enviados pelo cliente ao criar um novo tópico no sistema.
// // Essa classe garante que os dados fornecidos sejam validados antes de serem processados.
data class NovoTopicoForm(
    @field: NotEmpty @field: Size(min= 5, max=100) val titulo: String,
    @field: NotEmpty val mensagem: String,
    @field: NotNull val idCurso: Long,
    @field: NotNull  val idAutor: Long
)
