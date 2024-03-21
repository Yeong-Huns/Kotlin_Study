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
}
infix fun Int.plus2(value: Int): Int = this + value

infix fun String.and(str: String) : String = "$this:$str"

class Instagram(val Id: String){
    val followList: MutableList<Instagram> = mutableListOf<Instagram>()
    infix fun follow(other: Instagram){
        followList.add(other)
    }
}