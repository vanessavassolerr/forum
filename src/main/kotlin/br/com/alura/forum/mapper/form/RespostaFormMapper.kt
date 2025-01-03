package br.com.alura.forum.mapper.form

import br.com.alura.forum.dto.NovaRespostaForm
import br.com.alura.forum.mapper.Mapper
import br.com.alura.forum.model.Resposta
import br.com.alura.forum.service.TopicoService
import br.com.alura.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class RespostaFormMapper(
    private val usuarioService: UsuarioService,
    private val topicoService: TopicoService)
    : Mapper<NovaRespostaForm, Resposta> {
    override fun map(r: NovaRespostaForm): Resposta {
        return Resposta(
            mensagem = r.mensagem,
            autor = usuarioService.buscarPorId(r.idAutor),
            topico = topicoService.obterTopico(r.idTopico),
            solucao = r.solucao
        )
    }
}
