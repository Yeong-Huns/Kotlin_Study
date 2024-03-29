/**
 *packageName    :
 * fileName       : Main2
 * author         : Yeong-Huns
 * date           : 2024-03-29
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-29        Yeong-Huns       최초 생성
 */
fun main(){
    val person: Person1 = Person1("kim", 30)
    println(person)

    val person2: Person1 = Person1("kim", 30)
    val person3: Person1 = Person1("park", 24)

    println("person == person2 : ${person == person2}") //true
    println("person == person3 : ${person == person3}") // false

    val person4: Person1 = person.copy("park")
    val person5: Person1 = person.copy(age = 40)

    println(person4)
    println(person5)

    println(person4.component1())
    println(person4.component2())

    val parent: Parent = Parent()
    //println("Parent.a = ${parent.a}")
    //println("Parent.b = ${parent.b}")
    println("Parent.c = ${parent.c}")
    println("Parent.d = ${parent.d}")
    val child: Child = Child()

}
data class Person1(val name: String, val age: Int)

open class Parent{
    private val a = 1
    protected val b = 2
    internal val c = 3
    val d = 4
}

class Child : Parent(){
    init {
        //println("Child.parent.a = ${super.a}")
        println("Child.parent.b = ${super.b}")
        println("Child.parent.c = ${super.c}")
        println("Child.parent.d = ${super.d}")
    }
}