package components

import kotlinx.css.*
import kotlinx.html.classes
import kotlinx.html.js.onClickFunction
import react.*
import styled.css
import styled.styledButton

external interface ButtonCompileProps : RProps {
    var label: String
    var onClick: () -> Unit
}

@JsExport
class ButtonCompile : RComponent<ButtonCompileProps, RState>() {
    override fun RBuilder.render() {
        styledButton {
            css {
                marginTop = 20.px
                paddingTop = 16.px
                paddingBottom = 16.px
                borderRadius = 8.px
                fontWeight = FontWeight.bold
                borderColor = Color("#00cc00")
                width = 98.pct
                textTransform = TextTransform.uppercase
                color = Color.white
                cursor = Cursor.pointer
                backgroundColor = Color("#00cc00")
            }
            attrs {
                onClickFunction = { props.onClick() }
            }
            +props.label
        }
    }
}

fun RBuilder.buttonCompile(handler: ButtonCompileProps.() -> Unit): ReactElement {
    return child(ButtonCompile::class) {
        this.attrs(handler)
    }
}