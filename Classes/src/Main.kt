/**
 *packageName    : ${PACKAGE_NAME}
 * fileName       : ${NAME}
 * author         : Yeong-Huns
 * date           : 2024-03-24
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-24        Yeong-Huns       최초 생성
 */
fun main() {
    val person: Person = Person("kim", 30)
    println("name = ${person.name}")    //name = kim
}

class Person constructor(name: String, age: Int){
    val name: String = name
    val age: Int = age

    init {
        println("Person name = $name, age = ${this.age}")
        // Person name = kim, age = 30
    }
}