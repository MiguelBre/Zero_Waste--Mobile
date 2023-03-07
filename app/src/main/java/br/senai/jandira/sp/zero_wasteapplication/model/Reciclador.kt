package br.senai.jandira.sp.zero_wasteapplication.model

data class Reciclador(

    var id: Long = 0,
    var name: String = "",
    var cpf: String = "",
    var email: String = "",
    var phone: String = "",
    var cep: String = "",
    var resNumber: String = "",
    var complement: String = "",
    var birthDay: String = "",
    var password: String = "",

)
