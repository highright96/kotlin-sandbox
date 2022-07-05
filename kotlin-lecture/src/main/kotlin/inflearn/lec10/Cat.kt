package inflearn.lec10

/*
타입은 :(콜론)을 바로 붙여주고 상속은 :(콜론)을 한칸 띄우고 붙여준다. (컨벤션)
 */
class Cat(
    species: String
) : Animal (species, 4){

    override fun move() {
        println("사뿐사뿐")
    }
}