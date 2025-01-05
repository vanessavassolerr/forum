package br.com.alura.forum.controller

import br.com.alura.forum.mapper.form.AtualizacaoTopicoForm
import br.com.alura.forum.mapper.form.NovoTopicoForm
import br.com.alura.forum.mapper.view.TopicoView
import br.com.alura.forum.service.TopicoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {
    @GetMapping
    fun listarTopicos(): List<TopicoView>{
        return service.listarTopicos()
    }

    @GetMapping("/{id}")
    fun buscarPorTopicoId(@PathVariable id: Long) : TopicoView {
        return service.buscarTopicoPorId(id)
    }

    @PostMapping
    fun cadastrarTopico(@RequestBody @Valid dto: NovoTopicoForm) {
        service.cadastrarTopico(dto)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: AtualizacaoTopicoForm) {
        service.atualizarTopico(form)
    }
}