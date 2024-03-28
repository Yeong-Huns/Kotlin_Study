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
    val Person2: Person = Person.of("park", 24);
    println("Person2 name = ${Person2.name} Person2 age = ${Person2.age}")
    val test: Test = Test("song", 19)
    println(test.info())
    val test2: Test2 = Test2()
    test2.testSetter = "wonderLand"
    println(test2.testSetter)
    val person2: Person2 = Person2("park", 27)
    val lazy: lazyClass = lazyClass()
    lazy.name = "john"
    println("lazyName: ${lazy.name}")
    lazy.name = "Doe"
    println("lazyName: ${lazy.name}")
    val subConstructorTest: subConstructor = subConstructor("강")
    println("subConstructorTest : ${subConstructorTest.age}")

}

class Person constructor(name:String, age: Int){
    val name: String
    var age: Int

    init {
        println("Person name = $name, age = $age")
        // Person name = kim, age = 30
        this.name = name
        this.age = age
    }

    constructor(name:String): this(name, 0)

    fun addAge(increment: Int){
        this.age += increment
    }

    companion object {
      fun of(name:String, age:Int): Person = Person(name, age)
    }
}

class Test (private val name: String, private val age: Int){

    fun info(): String = "name : ${this.name} age : ${this.age}"
}
class Test2{
    var testSetter : String = ""
        set(value){
            field = "value : $value"
        }
}
class Person2 constructor(name: String,age: Int){
    val name: String = name
    val age: Int = age
    init {
        println("name : $name, age : $age")
    }
}
class lazyClass{
    lateinit var name: String
}
class subConstructor(val name: String, val age: Int){
    constructor(name: String): this(name, 0)
}