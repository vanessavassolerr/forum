package br.com.alura.forum.mapper.form

import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.mapper.Mapper
import br.com.alura.forum.model.Topico
import br.com.alura.forum.service.CursoService
import br.com.alura.forum.service.UsuarioService
import org.springframework.stereotype.Component

// transforma um objeto do tipo NovoTopicoForm (formulário) em um objeto do modelo Topico
@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService)
    :Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor)

        )
    }


}
