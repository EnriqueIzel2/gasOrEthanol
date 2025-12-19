package desafioEstoque

data class Produto(
    val id: Int,
    val nome: String,
    val preco: Double,
    val quantidade: Int
)

interface Estoque<T> {
    fun inserir(item: T)
    fun deletar(id: Int): Boolean
    fun atualizar(item: T): Boolean
    fun buscar(id: Int): T?
    fun buscarTodos(): List<T>
}

fun inserirProduto(): Produto {
    var id: Int? = null
    while (id == null) {
        println("Insira o ID do produto")
        print("->")
        id = readlnOrNull()?.toIntOrNull()
    }

    var nome: String? = null
    while (nome == null) {
        println("Insira o ID do produto")
        print("->")
        var nome = readlnOrNull()
    }

    var preco: Double? = null
    while (preco == null) {
        println("Insira o ID do produto")
        print("->")
        preco = readlnOrNull()?.toDoubleOrNull()
    }

    var quantidade: Int? = null
    while (quantidade == null) {
        println("Insira o ID do produto")
        print("->")
        quantidade = readlnOrNull()?.toIntOrNull()
    }

    return Produto(
        id = id,
        nome = nome,
        preco = preco,
        quantidade = quantidade
    )
}

class EstoqueProdutos : Estoque<Produto> {
    private val listaProdutos = mutableListOf<Produto>()

    override fun inserir(item: Produto) {
        listaProdutos.add(item)
    }

    override fun deletar(id: Int): Boolean {
        return listaProdutos.removeIf { it.id == id }
    }

    override fun atualizar(item: Produto): Boolean {
        if (listaProdutos.removeIf { it.id == item.id }) {
            listaProdutos.add(item)
            return true
        } else {
            return false
        }
    }

    override fun buscar(id: Int): Produto? {
        return listaProdutos.find { it.id == id }
    }

    override fun buscarTodos(): List<Produto> {
        return listaProdutos.toList()
    }
}

fun main() {
    val estoqueDeProdutos = EstoqueProdutos()
    var acao: Int? = null

    while (acao != 5) {
        println(
            """
        +--------------------------------+
        | CONTROLE DE ESTOQUE - PRODUTOS |
        +--------------------------------+
        | 1 - ADICIONAR                  |
        | 2 - ATUALIZAR                  |
        | 3 - DELETAR                    |
        | 4 - BUSCAR                     |
        | 5 - SAIR                       |
        +--------------------------------+
        """
        )

        println("LISTA ATUAL DE PRODUTOS NO ESTOQUE")
        println(
            estoqueDeProdutos.buscarTodos().joinToString(
                separator = "\n"
            ).ifEmpty { "Nenhum produto foi adicionado ao estoque" })
        println("->")
        acao = readlnOrNull()?.toIntOrNull()

        while (acao) {
            1 -> {}
            2 -> {}
            3 -> {}
            4 -> {}
            5 -> {
                println("Obrigado. Volte sempre")
            }
            else -> {
                println("Opção inválida. Tente novamente")
            }
        }
    }
}