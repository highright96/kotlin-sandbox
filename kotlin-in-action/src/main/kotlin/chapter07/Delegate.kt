package chapter07

import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

fun loadEmails(): List<String> {
    println("load emails...")
    return listOf("email1, email2")
}

class Person(val name: String) {
    private var _emails: List<String>? = null
    val emails: List<String>
        get() {
            if(_emails == null) {
                _emails = loadEmails()
            }
            return _emails!!
        }
}

class Person2 {
    private val _attribute = hashMapOf<String, String>()
    fun setAttribute(attrName: String, value: String) {
        _attribute[attrName] = value
    }

    val name: String
     get() = _attribute["name"]!!
}

class Person3 {
    private val _attribute = hashMapOf<String, String>()
    fun setAttribute(attrName: String, value: String) {
        _attribute[attrName] = value
    }

    val name: String by _attribute
}

fun main() {
    val p = Person("name")
    println("call email property!")
    p.emails
}