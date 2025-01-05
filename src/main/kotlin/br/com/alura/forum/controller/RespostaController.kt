package br.com.alura.forum.controller

import br.com.alura.forum.mapper.form.NovaRespostaForm
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.service.RespostaService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/topicos/{id}/respostas")
class RespostaController(
    private val service: RespostaService) {

    @GetMapping
    fun consultarRespostas(@PathVariable id: Long): List<Resposta> {
        return this.service.consultarRespostas(id)
    }

    @PostMapping
    fun cadastrarResposta(@PathVariable id: Long, @RequestBody @Valid form: NovaRespostaForm) {
        service.cadastrarResposta(id, form)
    }

}