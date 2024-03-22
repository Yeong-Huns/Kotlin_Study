/**
 *packageName    :
 * fileName       : Function2
 * author         : Yeong-Huns
 * date           : 2024-03-21
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-21        Yeong-Huns       최초 생성
 */
fun main(){
    /*
    infix fun 클래스.중위함수명(파라미터: 타입): 리턴타입 {
    // 본문
    return 본문
    }
    */
    println("4 plus2 6 : infix  = ${4 plus2 6}\n")  // 10
    //* ===========================================================
    val ip: String = "192.0.0.1"
    val port: String = "8080"
    val address: String = ip and port
    println("ip and port : infix = $address\n")
    //* ===========================================================
    val pair: Pair<String, Int> = "kim" to 30
    println("Pair<String, Int> = 'kim' to 30 ->  $pair\n")
    //* ===========================================================
    val kim: Instagram = Instagram("kim")
    val park: Instagram = Instagram("park")
    val lee: Instagram = Instagram("lee")

    kim follow park
    kim follow lee
    println("kims followList : ")
    for(follow in kim.followList){
        println(follow.Id)
    }
    println()
    //* ===========================================================
    val book1: Book = Book(0)
    println("+book1 = ${+book1}")   // Book(price=100)
    println("-book1 = ${-book1}")   // Book(price=0)
    //* ===========================================================
    var a: Int = 10
    println("a++ = ${a++}") // 10
    println("a = $a")   // 11
    println("++a = ${++a}") // 12
    println("a = $a") // 12
    /*
    a++ -> a에 1을 증가시키지만, 실행 직후 원래 a 값을 반환,
    ++a -> a에 1을 증가시키고, 증가시킨 값을 반환
     */
    //* ===========================================================
    val book2: Book = Book(0)
    println(book2)  //Book(price=0)
    println(book2 + 1_000)  //Book(price=1000)
    println(book2 - 500)    //Book(price=500)
    //* ===========================================================
    println("2 * hello -> ${2 * "hello "}") //hello hello
}
infix fun Int.plus2(value: Int): Int = this + value

infix fun String.and(str: String) : String = "$this:$str"

class Instagram(val Id: String){
    val followList: MutableList<Instagram> = mutableListOf<Instagram>()
    infix fun follow(other: Instagram){
        followList.add(other)
    }
}

data class Book(var price: Int) {
    operator fun plus(increasePrice: Int): Book{
        this.price += increasePrice
        return this
    }
}
operator fun Book.unaryPlus(): Book {
    this.price += 100
    return this
}
operator fun Book.unaryMinus(): Book{
    this.price -= 100
    return this
}
operator fun Book.minus(decreasePrice: Int): Book{
    this.price -= decreasePrice
    return this
}

operator fun Int.times(str: String) = str.repeat(this)