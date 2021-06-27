package compilator

enum class BagualSintaxValidator(val sintax: String, val regex: Regex, val errorMessage: String) {

    MAIN_FUNCTION_OPEN("", Regex("^VAMO DALE main\\(\\) TCHÊ"), "Main function não declarada da forma correta"),
    MAIN_FUNCTION_CLOSE("", Regex("FEITORIA$"), "Main function não foi fechada corretamente"),
    FOR_METHOD("TE PASSO O LAÇO", Regex("TE PASSO O LAÇO\\([a-z] ATÉ \\d+\\.\\.\\d+\\) TCHÊ"), "Laço \"TE PASSO O\" não definido da maneira correta"),
    IF_CONDITION("SE PÁ", Regex("SE PÁ\\(\\w+ [==|<=|>=|<|>]+ .*\\) TCHÊ"), "Condição \"SE PÁ\" não declarada da forma correta"),
    PRINT_METHOD("TÁ NA MÃO", Regex("TÁ NA MÃO\\(.*\\)"), "Método \"TÁ NA MÃO\" declarado incorretamente");

    companion object {
        fun validate(codeBagual: String): List<String> {
            val errors = mutableListOf<String>()
            values().forEach {
                if ((codeBagual.contains(it.sintax) || it.sintax == "") && it.regex.containsMatchIn(codeBagual).not())
                    errors.add(it.errorMessage)
            }
            return errors
        }
    }
}