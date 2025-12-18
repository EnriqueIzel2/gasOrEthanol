package desafioIMC

import kotlin.math.pow

fun main() {
    println("Informe o seu peso em quilos")
    val peso = readlnOrNull()?.toDoubleOrNull()

    println("Informe sua altura em metros")
    val altura = readlnOrNull()?.toDoubleOrNull()

    if (peso == null || altura == null) {
        return
    }

    val imc = peso / altura.pow(2)

    when {
        imc < 18.5 -> println("Abaixo do peso")
        imc in 18.5..24.9 -> println("Peso normal")
        imc in 25.0..29.9 -> println("Sobrepeso")
        imc in 30.0..34.9 -> println("Obesidade grau I")
        imc in 35.0..39.9 -> println("Obesidade grau II")
        imc > 40 -> println("Obesidade grau III")
        else -> println("Desconhecido")
    }
}