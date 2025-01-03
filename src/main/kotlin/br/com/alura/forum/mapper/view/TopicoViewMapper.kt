package br.com.alura.forum.mapper.view

import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.mapper.Mapper
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Component

// converte objetos do tipo Topico para o tipo TopicoView
// cria e retorna um novo objeto do tipo TopicoView,
// /extraindo os campos necessários do objeto Topico e os atribui diretamente ao novo objeto TopicoView
@Component
class TopicoViewMapper: Mapper<Topico, TopicoView> { //implementa a interface mapper
    override fun map(t: Topico): TopicoView {
        return TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status
        )
    }
}