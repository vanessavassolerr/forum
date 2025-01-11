package br.com.alura.forum.mapper.view

import br.com.alura.forum.mapper.Mapper
import br.com.alura.forum.model.Resposta
import org.springframework.stereotype.Component

// converte objetos do tipo Topico para o tipo TopicoView
// cria e retorna um novo objeto do tipo TopicoView,
// /extraindo os campos necessários do objeto Topico e os atribui diretamente ao novo objeto TopicoView
@Component
class respostaViewMapper: Mapper<Resposta, RespostaView> { //implementa a interface mapper
    override fun map(r: Resposta): RespostaView {
        return RespostaView(
            id = r.id,
            mensagem = r.mensagem,
            data = r.data,
            autor = r.autor,
            topico = r.topico,
            solucao = r.solucao
        )
    }
}