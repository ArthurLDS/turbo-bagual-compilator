package components

import kotlinx.css.*
import react.*
import react.dom.div
import styled.css
import styled.styledDiv

external interface ValidateResultProps : RProps {
    var errorList: List<String>
}

@JsExport
class ValidateResult : RComponent<ValidateResultProps, RState>() {
    override fun RBuilder.render() {
        styledDiv {
            css {
                color = Color("#F00")
                marginLeft = 14.px
                fontSize = 8.pt
                fontFamily = "monospace"
            }
            props.errorList.forEach {
                div {
                   +"Erro: $it"
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