package br.com.alura.forum.mapper


// Contrato genérico usado para definir a estrutura de um mapeador
// converte (ou "mapear") um objeto de um tipo (T) para outro (U).
// T é o tipo do objeto de entrada que será mapeado
// U é o tipo do objeto de saída após o mapeamento.
// Não há implementação concreta aqui, pois isso é responsabilidade das classes que implementarem a interface.
interface Mapper<T, U> {

    fun map(t: T): U

}
