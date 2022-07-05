package inflearn.lec18

fun main() {
    val fruitsInLIst: List<List<Fruit>> = listOf(
        listOf(
            Fruit(1, "사과", 1_000),
            Fruit(1, "사과", 1_200),
            Fruit(1, "사과", 1_500),
            Fruit(1, "바나나", 3_000),
        ),
        listOf(
            Fruit(1, "사과", 1_000),
            Fruit(1, "사과", 1_200),
            Fruit(1, "사과", 1_500),
        )
    )

    //출고가와 현재가가 동일한 과일
    //flatMap : 중첩 리스트를 여러 조건을 포함한 단일 리스트로 변경
    val samePriceFruits1 = fruitsInLIst.flatMap { list ->
        list.filter { fruit -> fruit.factoryPrice == fruit.currentPrice }
    }
    val samePriceFruits2 = fruitsInLIst.flatMap { list -> list.samePriceFilter }

    //flatten : 중첩 리스트를 단일 리스트로 변경
    val flattenList = fruitsInLIst.flatten()

}

val List<Fruit>.samePriceFilter: List<Fruit>
    get() = this.filter(Fruit::isSamePrice)