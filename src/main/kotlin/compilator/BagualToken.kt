package compilator

enum class BagualToken(val bagualToken: String, val kotlinToken: String) {

    //COMMANDS
    FUNCTION("VAMO DALE", "fun"),
    IF("SE PÁ", "if"),
    ELSE("MAS BEM CAPAZ", "else"),
    KEY_OPEN("TCHÊ", "{"),
    KEY_CLOSE("FEITORIA", "}"),
    PRINT("TÁ NA MÃO", "print"),
    LOOP("TE PASSO O LAÇO", "for"),
    IN("ATÉ", "in"),
    CONTINUE_LOOP("SEGUE O BAILE", "continue"),

    //TYPES
    STRING("CHIMARRÃO", "String"),
    INTEGER("COSTELA", "Int"),
    LONG("COSTELÃO", "Long"),
    BOOLEAN("BERGAMOTA", "Boolean");

    companion object {

        fun parseCode(bagualCode: String): String {
            var code: String = bagualCode

            values().forEach {
                code = code.replace(it.bagualToken, it.kotlinToken)
            }
            return removeInvertedCommas(code)
        }

        private fun removeInvertedCommas(code: String): String {
            return code.replace("“", "\"").replace("”", "\"")
        }
    }

}