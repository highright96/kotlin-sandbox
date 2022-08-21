package chapter07

import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

class PersonC(
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {

    var age: Int by ObservableProperty(age, changeSupport)
    var salary: Int by ObservableProperty(salary, changeSupport)

    class ObservableProperty(
        var propValue: Int,
        val changeSupport: PropertyChangeSupport
    ) {
        operator fun getValue(p: PersonC, prop: KProperty<*>): Int = propValue
        operator fun setValue(p: PersonC, prop: KProperty<*>, newValue: Int) {
            val oldValue = propValue
            propValue = newValue
            changeSupport.firePropertyChange(prop.name, oldValue, newValue)
        }
    }
}