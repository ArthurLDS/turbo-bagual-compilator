import compilator.BagualSintaxValidator
import compilator.BagualToken
import components.buttonBagual
import components.codePad
import components.validateResult
import kotlinx.browser.window
import kotlinx.css.*
import react.*
import styled.css
import styled.styledDiv

external interface AppState : RState {
    var bagualCode: String
    var kotlinCode: String
    var isCodeValid: Boolean
}

@JsExport
class App : RComponent<RProps, AppState>() {

    override fun AppState.init() {
        bagualCode = ""
        kotlinCode = ""
        isCodeValid = false
    }

    override fun RBuilder.render() {
        styledDiv {
            css {
                width = 582.px
                textAlign = TextAlign.left
                display = Display.inlineBlock
            }
            styledDiv {
                css {
                    textAlign = TextAlign.left
                    marginLeft = 10.px
                    marginBottom = 4.px
                }
                buttonBagual {
                    label = "Converter"
                    color = "#e4dc02"
                    onClick = {
                        if (state.isCodeValid) {
                            setState {
                                kotlinCode = BagualToken.parseCode(state.bagualCode)
                            }
                        }
                    }
                }
                buttonBagual {
                    label = "Capa fora"
                    color = "#F11"
                    onClick = {
                        if (state.isCodeValid) {
                            setState {
                                kotlinCode = ""
                                bagualCode = ""
                            }
                        }
                    }
                }
            }
        }
        buttonBagual {
            label = "▷ Bora dale!"
            color = "#00cc00"
            onClick = {
                if (state.isCodeValid) {
                    window.alert("Result")
                }
            }
        }

        codePad {
            code = state.bagualCode
            placeholder = "Digite seu código Bagual"
            onChange = {
                setState {
                    bagualCode = it
                    isCodeValid = BagualSintaxValidator.validate(it).isEmpty()
                }
            }
        }

        codePad {
            code = state.kotlinCode
            placeholder = "Resultado em Kotlin"
            disabled = true
            onChange = { setState { kotlinCode = it } }
        }

        styledDiv {
            css {
                textAlign = TextAlign.left
            }
            validateResult {
                errorList = BagualSintaxValidator.validate(state.bagualCode)
            }
        }

    }
}