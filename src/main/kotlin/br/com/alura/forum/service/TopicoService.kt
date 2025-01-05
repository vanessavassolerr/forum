package br.com.alura.forum.service

import br.com.alura.forum.mapper.form.NovoTopicoForm
import br.com.alura.forum.mapper.view.TopicoView
import br.com.alura.forum.mapper.form.TopicoFormMapper
import br.com.alura.forum.mapper.view.TopicoViewMapper
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
    private var topicos: MutableList<Topico> = mutableListOf(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper
) {


    // transforma uma lista de objetos da classe Topico em uma lista de objetos da classe TopicoView, usando o mapeador TopicoViewMapper
    fun listarTopicos(): List<TopicoView> {
        return topicos.stream()
            .map { // converte a lista de tópicos em um stream (API de processamento de coleções do Java)
                    topico ->
                topicoViewMapper.map(topico) //  pega cada elemento topico do stream e  aplica o método map do TopicoViewMapper, transformando o objeto Topico em um objeto TopicoView
            }.collect(Collectors.toList()) // converte o stream processado de volta em uma lista.
    }


    // busca um topico especifico pelo seu id dentro de uma colecao de topicos, retorna um topico no formato do TopicoView
    fun buscarTopicoPorId(id: Long): TopicoView {
        val topico = topicos.stream().filter { // converte a colecao de topicos em um stream
                topico ->
            topico.id == id //aplica um filtro pelo id que chega pelo parametro dqa funcao
        }.findFirst().get() // pega o primeiro elemento que satisfaz a condicao
        return topicoViewMapper.map(topico) //converte o resultado  em um objeto TopicoView usando o mapeador topicoViewMapper
    }


    // Recebe um objeto do tipo NovoTopicoForm que representa os dados enviados pelo usuario ao criar um novo topico
    // Retorna um objeto TopicoView que é a representacao de um topico cadastrado que vai ser devolvido na resposta da API
    fun cadastrarTopico(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form) // converte o objeto que veio do form em um objeto do definido pelo DTO
        topico.id = topicos.size.toLong() + 1 // cria um id para o topico que esta sendo cadastrado
        topicos.add(topico) // adiciona o topico na lista de topicos
        return topicoViewMapper.map(topico) // converte o objeto recem criado em um objeto topicoview
    }

    fun obterTopico(id: Long): Topico {
        return topicos.stream()
            .filter { topico ->
                topico.id == id
            }.findFirst().orElseThrow {
                throw NotFoundException("Tópico com ID $id não encontrado")
            }
    }
}