package br.com.alura.forum.service


import br.com.alura.forum.dto.NovaRespostaForm
import br.com.alura.forum.mapper.respostaViewMapper
import br.com.alura.forum.mapper.form.RespostaFormMapper
import br.com.alura.forum.model.Resposta
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class RespostaService(
    private var respostas: MutableList<Resposta> = mutableListOf(),
    private val topicoService: TopicoService,
    private val respostaFormMapper: RespostaFormMapper,
    private val respostaViewMapper: respostaViewMapper
) {

    fun consultarRespostas(idTopico: Long): List<Resposta> {
        return this.respostas.stream().filter {
            resposta -> resposta.topico.id == idTopico
        }.collect(Collectors.toList())
        }

    fun cadastrarResposta(idTopico: Long, form: NovaRespostaForm) {
        val resposta = respostaFormMapper.map(form)
        resposta.id = respostas.size.toLong() + 1
        resposta.topico = topicoService.obterTopico(idTopico)
        respostas.add(resposta)

    }

}


