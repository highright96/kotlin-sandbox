package chapter04

import java.io.Serializable

interface State : Serializable

interface View {
    fun getCurrentState(): State
}