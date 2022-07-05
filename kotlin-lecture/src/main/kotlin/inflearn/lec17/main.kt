package inflearn.lec17

fun main() {
    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_200),
        Fruit("사과", 1_500),
        Fruit("바나나", 3_000),
        Fruit("바나나", 3_200),
        Fruit("바나나", 4_000),
        Fruit("바나나", 5_200),
        Fruit("수박", 3_000),
        Fruit("수박", 10_000),
    )

    /*
    이름없는 함수, 람다
    : (Fruit) -> Boolean ==> 타입, 생략 가능
    */

    //방법 1
    val isApple: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
        return fruit.name == "사과"
    }

    //방법 2 ---> 더 간결하고 함수에 직접 넣어줄 때 많이 사용하는 방법
    val isApple2: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" }

    //호출 방법 1
    isApple(fruits[0])

    //호출 방법 1
    isApple.invoke(fruits[1])

    filterFruits(fruits, isApple)
    filterFruits(fruits, isApple2)

    filterFruits(fruits, { fruit: Fruit -> fruit.name == "사과" })
    filterFruits(fruits) { fruit: Fruit -> fruit.name == "사과" }  //마지막 파라미터가 함수인 경우, 소괄호 밖에 람다 사용이 가능하다.
    filterFruits(fruits) { fruit -> fruit.name == "사과" } //리턴타입은 추론이 가능하기 때문에 생략이 가능하다.
    filterFruits(fruits) { it.name == "사과" } //파라미터가 하나인 경우 it을 사용할 수 있다.
    filterFruits(fruits) {
        println("사과만 받는다..!!")
        it.name == "사과"
    }
}

private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> {
    return fruits.filter(filter)
}