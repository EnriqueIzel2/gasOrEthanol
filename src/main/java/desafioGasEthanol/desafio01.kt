package desafioGasEthanol

fun main() {
    println("Input the gas price:")
    print("R$: ")
    val gasPrice = readlnOrNull()?.toDoubleOrNull()

    println("Input the ethanol price:")
    print("R$: ")
    val ethanolPrice = readlnOrNull()?.toDoubleOrNull()

    if (gasPrice == null || ethanolPrice == null) {
        println("The values aren't valid")
        return
    }

    val ratioFuel = ethanolPrice / gasPrice

    println(when {
        ratioFuel < 0.7 -> "Ethanol is cheaper"
        ratioFuel > 0.7 -> "Gasoline is cheaper"
        else -> "They are both equally worth it"
    })
}