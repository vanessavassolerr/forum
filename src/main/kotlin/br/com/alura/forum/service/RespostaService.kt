package br.com.alura.forum.service


import br.com.alura.forum.mapper.form.NovaRespostaForm
import br.com.alura.forum.mapper.form.RespostaFormMapper
import br.com.alura.forum.model.Resposta
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class RespostaService(
    private var respostas: MutableList<Resposta> = mutableListOf(),
    private val topicoService: TopicoService,
    private val respostaFormMapper: RespostaFormMapper,
    private val logger: Logger? = LoggerFactory.getLogger(RespostaService::class.java)
) {

    fun consultarRespostas(idTopico: Long): List<Resposta>{
        logger?.info("Consultando respostas para o tópico com ID: $idTopico")
        return this.respostas.stream().filter { resposta ->
            resposta.topico.id == idTopico
        }.collect(Collectors.toList())
    }


    fun cadastrarResposta(idTopico: Long, form: NovaRespostaForm) {
        val resposta: Resposta = respostaFormMapper.map(form)
        resposta.id = respostas.size.toLong() + 1
        resposta.topico = topicoService.obterTopico(idTopico)
        respostas.add(resposta)

    }

}


