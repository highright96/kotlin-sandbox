package lec16

fun main() {
    val train: Train = Train()
    train.isExpensive()  //Train의 확장함수

    val srt1: Train = Train()
    srt1.isExpensive()  //Train의 확장함수

    val srt2: Srt = Srt()
    srt2.isExpensive()  //Srt의 확장함수
}

open class Train(
    val name: String = "새마을기차",
    val price: Int = 5_000
)

fun Train.isExpensive(): Boolean {
    println("Train의 확장함수")
    return true;
}

class Srt : Train("SRT", 40_000)

fun Srt.isExpensive(): Boolean {
    println("Srt의 확장함수")
    return true;
}