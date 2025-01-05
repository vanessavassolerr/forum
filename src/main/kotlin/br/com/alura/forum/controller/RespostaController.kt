package br.com.alura.forum.controller

import br.com.alura.forum.mapper.form.NovaRespostaForm
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.service.RespostaService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/topicos/{id}/respostas")
class RespostaController(
    private val service: RespostaService) {

    @GetMapping
    fun consultarRespostas(@PathVariable id: Long): List<Resposta> {
        return this.service.consultarRespostas(id)
    }

    @PostMapping
    fun cadastrarResposta(@PathVariable id: Long, @RequestBody @Valid dto: NovaRespostaForm) {
        service.cadastrarResposta(id, dto)
    }

}