package com.example.recursos

  class novo {

    lateinit var nome :String
    lateinit var idade :String
    lateinit var cpf :String
    lateinit var diaSemana :String

     fun calcularPrecoCorrida(km:Int){
        var calculoBasico = km * 3.5
        println(" O preco da corrida é de $calculoBasico")
    }

}