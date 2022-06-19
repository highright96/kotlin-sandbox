package chapter2

/*
레시피 2.1 널 허용 타입 사용하기

코틀린 컴파일러는 가능한 모든 널 값을 제거한다. 즉, 해당 변수에 널이 아닌 값을 요구한다.
 */

class Person(
    val first: String,
    val middle: String?,
    val last: String
)

fun main() {
    val p1 = Person(first = "SangWoo", middle = null, last = "Nam")
    if(p1.middle != null) {
        //p1 이 val 로 선언됐기 때문에, String? 타입에서 String 타입으로 스마트 캐스팅 수행
        val length = p1.middle.length
    }

    var p2 = Person(first = "SangWoo", middle = null, last = "Nam")
    if(p2.middle != null) {
        /*
        p2 이 var 로 선언됐기 때문에, 스마트 캐스팅을 수행하지 않는다.
        중간에 값이 변경될 수 있기 때문에!
        널 아님 단언 연산자 !!를 사용하면 되는데, 이건 NPE 를 발생시킬 수 있다.
        */
        val length = p2.middle!!.length
    }

    var p3 = Person(first = "SangWoo", middle = null, last = "Nam")
    val length = p3.middle?.length ?: 0

    var p4 = Person(first = "SangWoo", middle = null, last = "Nam")
    val type = p4 as? Person

}