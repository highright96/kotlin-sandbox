package chapter06

fun sendEmailTo(email: String) {
    println("Send to $email")
}

fun main() {
    var email: String? = "email"
    email?.let { sendEmailTo(email) }
}