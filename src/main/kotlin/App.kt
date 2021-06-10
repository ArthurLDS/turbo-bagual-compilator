import components.buttonCompile
import components.codePad
import react.*

external interface AppState : RState {
    var bagualCode: String
    var kotlinCode: String
}

@JsExport
class App : RComponent<RProps, AppState>() {

    override fun AppState.init() {
        bagualCode = "Codigo Bagual"
        kotlinCode = "Codigo Kotlin"
    }

    override fun RBuilder.render() {
        codePad {
            code = state.bagualCode
            onChange = { setState { bagualCode = it } }
        }

        codePad {
            code = state.kotlinCode
            onChange = { setState { kotlinCode = it } }
        }

        buttonCompile {
            label = "Bora dale!"
            onClick = {
                setState {
                    bagualCode = "init bagual code"
                    kotlinCode = "init kotlin code"
                }
            }
        }

        +"Bagual: ${state.bagualCode}\n"
        +"Kotlin: ${state.kotlinCode}"
    }
}