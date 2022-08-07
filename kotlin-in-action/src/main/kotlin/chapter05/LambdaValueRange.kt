package chapter05

fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0

    /*
     람다 안에서 람다 밖의 변수를 변경한다.
     람다 안에서 사용하는 외부 변수를 '람다가 포획한 변수'라고 부른다.
    */
    responses.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }

    println("ClientError : $clientErrors , ServerError : $serverErrors")
}