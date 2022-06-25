package chapter05

data class Product(
    val name: String,
    var price: Double,
    var onSale: Boolean = false
)

fun namesOfProductsOnSale1(products: List<Product>) =
    products.filter { product -> product.onSale }
        .map { product -> product.name }
        .ifEmpty { listOf("none") }
        .joinToString(separator = ", ")

fun namesOfProductsOnSale2(products: List<Product>) =
    products.filter { product -> product.onSale }
        .map { product -> product.name }
        .joinToString(separator = ", ")
        .ifEmpty { "none" }

