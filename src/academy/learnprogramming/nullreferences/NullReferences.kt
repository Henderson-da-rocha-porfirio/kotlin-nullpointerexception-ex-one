// Para ver a excecao funcionando, desmarque esta e marque a corrigida abaixo:
//package academy.learnprogramming.nullreferences
//
//fun main(args: Array<String>) {
//
//    val str: String? = null
//    val str4 = str!!.toUpperCase()
//
//
//    println("What happens when we do this: ${str?.toUpperCase()}")
//
//    val str2 = str ?: "This is the default value"
//    println(str2)
//
//    //val whatever = bankBranch?.address?.country ?: "US"
//
//    val something: Any = arrayOf(1, 2, 3, 4)
//    val str3 = something as? String
//    println(str3)
//
//    println(str3?.toUpperCase())
//}
//
//
//
//

package academy.learnprogramming.nullreferences

fun main(args: Array<String>) {
    // Variável nula tratada sem Elvis
    val str: String? = null

    // Chamada com ?. sem valor padrão
    println("What happens when we do this: ${str?.toUpperCase()}")

    // Usando Elvis apenas para uma mensagem padrão
    val str2 = str ?: "This is the default value"
    println(str2)

    // Tentativa de cast seguro
    val something: Any = arrayOf(1, 2, 3, 4)
    val str3 = something as? String
    println(str3) // Resultado: null

    // Chamada com ?. sem valor padrão
    println(str3?.toUpperCase()) // Resultado: null
}

