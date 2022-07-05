package inflearn.lec01

fun main() {

    //가변 변수
    var number1 = 10L;
    number1 = 100L;

    //불변 변수
    val number2 = 10L;
    //number2 = 100L;

    //타입명시
    var number3: Long = 10L;

    //초기화하지 않을 때 타입 명시 필수
    var number4: Long;
    //println(number4);

    //val 컬렉션에 요소를 추가할 수 있다.
    val arr = ArrayList<String>();
    arr.add("apple");

    /*
    nullable 변수
    */
    var number5 = 1_000L;
    //number5 = null;

    var number6: Long? = 1_000L;
    number6 = null;

    /*
    객체 인스턴스화
    */
    val person = _root_ide_package_.inflearn.lec01.Person("최태현");
}