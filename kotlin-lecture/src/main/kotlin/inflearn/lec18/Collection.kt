package inflearn.lec18

fun main() {
    val fruits = listOf(
        Fruit(1, "사과", 1_000),
        Fruit(1, "사과", 1_200),
        Fruit(1, "사과", 1_500),
        Fruit(1, "바나나", 3_000),
        Fruit(1, "바나나", 3_200),
        Fruit(1, "바나나", 4_000),
        Fruit(1, "바나나", 5_200),
        Fruit(1, "수박", 3_000),
        Fruit(1, "수박", 10_000),
    )

    //필터
    //사과만 주세요
    val apples1 = fruits.filter { fruit -> fruit.name == "사과" }

    //필터에서 인덱스가 필요하다면
    val apples2 = fruits.filterIndexed { idx, fruit ->
        println(idx)
        fruit.name == "사과"
    }

    //맵
    //사과의 가격들을 알려주세요
    val applePrices1 = fruits.filter { fruit -> fruit.name == "사과" }
        .map { fruit -> fruit.currentPrice }

    //맵에서 인덱스가 필요하다면?
    val applePrices2 = fruits.filter { fruit -> fruit.name == "사과" }
        .mapIndexed { idx, fruit ->
            println(idx)
            fruit.currentPrice
        }

    //매핑의 결과가 null이 아닌 것만 가져오고 싶다면?!
    val values = fruits.filter { fruit -> fruit.name == "사과" }
        .mapNotNull { fruit -> fruit.nullOrValue() }

    /*
    다양한 컬렉션 처리 기능
    */

    //all : 조건을 모두 만족하면 true 그러지 않으면 false
    val isAllApple = fruits.all { fruit -> fruit.name == "사과" }

    //none : 조건을 모두 불만족하면 true 그렇지 않으면 false
    val isAllNoApple = fruits.none { fruit -> fruit.name == "사과" }

    //any : 조건을 하나라도 만족하면 true 그렇지 않으면 false
    val isNoApple = fruits.any { fruit -> fruit.factoryPrice >= 10_000 }

    //count : 개수를 센다
    val fruitCount = fruits.count()

    //sortedBy : (오름차순) 정렬을 한다
    val sortedFruits = fruits.sortedBy { fruit -> fruit.currentPrice }

    //distinctBy : 변형된 값을 기준으로 중복을 제거한다
    val distinctFruitNames = fruits.distinctBy { fruit -> fruit.name }
        .map { fruit -> fruit.name }

    //first : 첫번째 값을 가져온다 (무조건 null이 아니여야 함)
    fruits.first()

    //firstOrNull : 첫번째 값 또는 null을 가져온다.
    fruits.firstOrNull()

    /*
    List를 Map으로
     */

    //이름 -> 과일 리스트
    val map1: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }

    //이름 -> 과일
    val map2: Map<String, Fruit> = fruits.associateBy { fruit -> fruit.name }

    //이름 -> 과일 출고가 리스트
    val map3: Map<String, List<Long>> = fruits.groupBy({ fruit -> fruit.name }, { fruit -> fruit.factoryPrice })

    //이름 -> 과일 출고가
    val map4: Map<String, Long> = fruits.associateBy({ fruit -> fruit.name }, { fruit -> fruit.factoryPrice })
}