package chapter07

class PersonA(
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {
    var age: Int = age
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange(
                "age", oldValue, newValue
            )
        }
    var salary: Int = salary
        set(newValue) {
            val oldValue = field
            field = newValue
            changeSupport.firePropertyChange(
                "salary", oldValue, newValue
            )
        }
}

fun main() {
    val p = PersonA("Dmitry", 34, 2000)
    p.addPropertyChangeListener { event ->
            println("Property ${event.propertyName} changed from ${event.oldValue} to ${event.newValue}")
        }
}