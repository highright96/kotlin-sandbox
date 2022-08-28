package chapter08

enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)

fun getShippingCostCalculator(delivery: Delivery) : (Order) -> Double {
    if(delivery == Delivery.STANDARD) {
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return {order -> 1.5 * order.itemCount }
}