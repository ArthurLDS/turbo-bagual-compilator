package components

import kotlinx.css.*
import kotlinx.html.js.onChangeFunction
import org.w3c.dom.HTMLTextAreaElement
import react.*
import react.dom.value
import styled.css
import styled.styledTextarea

external interface CodePadProps : RProps {
    var code: String
    var onChange: (String) -> Unit
}

@JsExport
class CodePad : RComponent<CodePadProps, RState>() {
    override fun RBuilder.render() {
        styledTextarea {
            css {
                borderRadius = 4.px
                width = 330.px
                height = 250.px
                marginLeft = 8.px
            }
            attrs {
                value = props.code
                onChangeFunction = {
                    val target = it.target as HTMLTextAreaElement
                    props.onChange(target.value)
                }
            }
        }
    }
}

fun RBuilder.codePad(handler: CodePadProps.() -> Unit): ReactElement {
    return child(CodePad::class) {
        this.attrs(handler)
    }
}