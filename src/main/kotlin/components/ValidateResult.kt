package components

import kotlinx.css.*
import react.*
import styled.css
import styled.styledDiv
import styled.styledLabel

external interface ValidateResultProps : RProps {
    var errorList: List<String>
    var hasCode: Boolean
}

@JsExport
class ValidateResult : RComponent<ValidateResultProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
            css {
                marginLeft = 14.px
                fontSize = 8.pt
                fontFamily = "monospace"
                borderWidth = 1.px
                borderColor = Color("#cdcdcd")
                borderStyle = BorderStyle.solid
                borderRadius = 4.px
                padding = "6px 6px 6px 6px"
                marginLeft = 14.px
                marginRight = 5.px
                marginTop = 5.px
                backgroundColor = Color("#282828")
            }
            styledDiv {
                css {
                    color = Color("#fff")
                    marginBottom = 5.px
                }
                +"Resultado compilação:"
            }
            props.errorList.forEach {
                styledDiv {
                    css {
                        color = Color("#F00")
                    }
                    +"Erro: $it"
                }
            }
            if (props.errorList.isNullOrEmpty() && props.hasCode) {
                styledLabel {
                    css {
                        color = Color("#0F0")
                    }
                    +"Sucesso: Deu bom aí, Tchê"
                }
            }
        }
    }
}

fun RBuilder.validateResult(handler: ValidateResultProps.() -> Unit): ReactElement {
    return child(ValidateResult::class) {
        this.attrs(handler)
    }
}