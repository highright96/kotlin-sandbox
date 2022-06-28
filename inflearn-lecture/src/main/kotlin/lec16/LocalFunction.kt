package lec16

fun createPerson1(firstName: String, secondName: String): Int {
    if (firstName.isEmpty()) {
        throw IllegalArgumentException("에러 발생!")
    }

    if (secondName.isEmpty()) {
        throw IllegalArgumentException("에러 발생!")
    }

    return 10
}

fun createPerson2(firstName: String, secondName: String): Int {
    fun validateName(name: String, fieldName: String) {
        if (name.isEmpty()) {
            throw IllegalArgumentException("${fieldName}은 비어있을 수 없습니다! 현재 값 : $name")
        }
    }

    validateName(firstName, "firstname")
    validateName(secondName, "secondName")

    return 10
}