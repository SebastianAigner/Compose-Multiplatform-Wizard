package ui

import csstype.Position
import csstype.px
import mui.icons.material.*
import mui.material.Box
import mui.material.IconButton
import mui.material.Stack
import mui.material.StackDirection
import mui.system.responsive
import mui.system.sx
import react.FC
import react.Props
import react.useRequiredContext
import web.window.window

val TopMenu = FC<Props> {
    var showVersions by useRequiredContext(ShowVersionContext)
    var theme by useRequiredContext(ThemeContext)
    Box {
        sx {
            position = Position.relative
        }
        Stack {
            direction = responsive(StackDirection.row)
            sx {
                position = Position.absolute
                right = 0.px
                top = 0.px
            }

            IconButton {
                onClick = {
                    showVersions = !showVersions
                }
                if (showVersions) {
                    Code()
                } else {
                    CodeOff()
                }
            }

            IconButton {
                onClick = {
                    window.open("https://developer.android.com/jetpack/compose/documentation")
                }
                MenuBook()
            }

            IconButton {
                onClick = {
                    window.open("https://github.com/terrakok/Compose-Multiplatform-Wizard")
                }
                GitHub()
            }

            IconButton {
                onClick = {
                    theme = if (theme == Themes.Light) Themes.Dark else Themes.Light
                }
                if (theme == Themes.Light) {
                    Brightness7()
                } else {
                    Brightness4()
                }
            }
        }
    }
}