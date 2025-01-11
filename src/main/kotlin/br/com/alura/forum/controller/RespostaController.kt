package br.com.alura.forum.controller

import br.com.alura.forum.mapper.form.NovaRespostaForm
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.service.RespostaService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/topicos/{idTopico}/respostas")
class RespostaController(
    private val service: RespostaService) {

    @GetMapping
    fun consultarRespostas(@PathVariable idTopico: Long): List<Resposta> {
        return this.service.consultarRespostas(idTopico)
    }

    @PostMapping
    fun cadastrarResposta(@PathVariable idTopico: Long, @RequestBody @Valid form: NovaRespostaForm) {
        service.cadastrarResposta(idTopico, form)
    }

}