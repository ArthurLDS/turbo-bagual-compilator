package components

import kotlinx.css.*
import kotlinx.html.js.onClickFunction
import react.*
import styled.css
import styled.styledButton

external interface ButtonCompileProps : RProps {
    var label: String
    var onClick: () -> Unit
    var color: String
}

@JsExport
class ButtonBagual : RComponent<ButtonCompileProps, RState>() {
    override fun RBuilder.render() {
        styledButton {
            css {
                paddingTop = 5.px
                paddingBottom = 5.px
                borderRadius = 5.px
                marginLeft = 4.px
                width = 100.px
                fontSize = 8.pt
                fontWeight = FontWeight.bold
                borderColor = Color(props.color)
                textTransform = TextTransform.uppercase
                color = Color.white
                display = Display.inline
                cursor = Cursor.pointer
                backgroundColor = Color(props.color)
            }
            attrs {
                onClickFunction = { props.onClick() }
            }
            +props.label
        }
    }
}

fun RBuilder.buttonBagual(handler: ButtonCompileProps.() -> Unit): ReactElement {
    return child(ButtonBagual::class) {
        this.attrs(handler)
    }
}