package br.com.alura.forum.controller

import br.com.alura.forum.mapper.form.AtualizacaoTopicoForm
import br.com.alura.forum.mapper.form.NovoTopicoForm
import br.com.alura.forum.mapper.view.TopicoView
import br.com.alura.forum.service.TopicoService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder


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
    fun cadastrarTopico(@RequestBody @Valid dto: NovoTopicoForm,
                        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicoView>{
        val topicoView = service.cadastrarTopico(dto)
        val uri = uriBuilder.path("/topicos/${topicoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(topicoView)
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid form: AtualizacaoTopicoForm): ResponseEntity<TopicoView> {
        val topicoView = service.atualizarTopico(form)
        return ResponseEntity.ok(topicoView)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long){
        service.deletarTopico(id)

    }
}