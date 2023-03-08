package br.senai.jandira.sp.zero_wasteapplication.model

data class User(

    var id: Long = 0,
    var name: String = "",
    var cpf: String = "",
    var email: String = "",
    var phone: String = "",
    var cep: String,
    var resNumber: String = "",
    var complement: String = "",
    var logradouro: String = "",
    var bairro: String = "",
    var localidade: String = "",
    var uf: String = "",
    val endereco: Array<String> = arrayOf<String>(
        cep,
        resNumber,
        complement,
        logradouro,
        bairro,
        localidade,
        uf
    ),
    var birthDay: String = "",
    var password: String = "",

    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false
        if (name != other.name) return false
        if (cpf != other.cpf) return false
        if (email != other.email) return false
        if (phone != other.phone) return false
        if (cep != other.cep) return false
        if (resNumber != other.resNumber) return false
        if (complement != other.complement) return false
        if (logradouro != other.logradouro) return false
        if (bairro != other.bairro) return false
        if (localidade != other.localidade) return false
        if (uf != other.uf) return false
        if (!endereco.contentEquals(other.endereco)) return false
        if (birthDay != other.birthDay) return false
        if (password != other.password) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + cpf.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + phone.hashCode()
        result = 31 * result + cep.hashCode()
        result = 31 * result + resNumber.hashCode()
        result = 31 * result + complement.hashCode()
        result = 31 * result + logradouro.hashCode()
        result = 31 * result + bairro.hashCode()
        result = 31 * result + localidade.hashCode()
        result = 31 * result + uf.hashCode()
        result = 31 * result + endereco.contentHashCode()
        result = 31 * result + birthDay.hashCode()
        result = 31 * result + password.hashCode()
        return result
    }
}
