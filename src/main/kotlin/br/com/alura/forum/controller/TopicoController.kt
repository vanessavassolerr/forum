package br.com.alura.forum.controller

import br.com.alura.forum.mapper.form.NovoTopicoForm
import br.com.alura.forum.mapper.view.TopicoView
import br.com.alura.forum.service.TopicoService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


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
}