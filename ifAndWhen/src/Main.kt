/**
 *packageName    : ${PACKAGE_NAME}
 * fileName       : ${NAME}
 * author         : Yeong-Huns
 * date           : 2024-03-18
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-18        Yeong-Huns       최초 생성
 */
fun main() {
    val maxA: Int = 10
    val maxB: Int = 20
    val max: Int

    if(maxA > maxB) {
        max = maxA
    } else {
        max = maxB
    }
    println("max = $max\n")   // max = 20
// ===========================================================
    val maxA2: Int = 10
    val maxB2: Int = 20
    val max2 = if(maxA2 > maxB2) maxA2 else maxB2
    println("max2 = $max2\n")      // max2 = 20
// ===========================================================
    println("maxOf(10, 20) = ${maxOf(10, 20)}\n")
// ===========================================================

    val maxA3: Int = 10
    val maxB3: Int = 20
    val max3: Int = if(maxA3 > maxB3) {
        println("maxA3가 maxB3보다 더 큼")
        maxA3
    } else {
        println("maxB3가 maxA3보다 더 크거나 같음")
        maxB3
    }
    println("max3 = $max3\n")     // max3 = 20
// ===========================================================
    val index1: Int = 5
    if(index1 in 1..10) { //1 ~ 10
        println("contain 5\n")
    }
// ===========================================================
    val index2: Int = 5
    if(index2 !in 6..10) {      //6 ~ 10
        println("not contain 5\n")
    }
// ===========================================================
    val memberList: List<String> = listOf("kim", "park", "lee")
    if("kim" in memberList) {
        println("contain kim\n")
    }
// ===========================================================
    val age: Int = 30
    if(age in arrayOf(30, 40, 50)) {
        println("contain age(30)\n")
    } else {
        println("not contain age(30)\n")
    }
// ===========================================================
    val string: String? = "ABCDE"
    val length: Int? = getStringLength(string)
    println("ABCDE?.length = $length\n")

// ===========================================================
    val whenAge: Int = getAge("park")
    println("whenAge = $whenAge\n")
// ===========================================================
    val whenAge2: Int = getAge2("park")
    println("whenAge2 = $whenAge2\n")     // whenAge2= 20
// ===========================================================
    val score: Int = 90
    var grades: String

    if ((score > 90) && (score <= 100)) {
        grades = "A"
    } else if (score > 80) {
        grades = "B"
    } else if (score > 70) {
        grades = "C"
    } else if (score > 60) {
        grades = "D"
    } else {
        grades = "F"
    }

    println("grades = $grades\n")    // B
// ===========================================================
    val score2: Int = 90
    var grades2: String = when (score2) {
        in 91..100 -> "A"
        in 81..90 -> "B"
        in 71..80 -> "C"
        in 61..70 -> "D"
        else -> "F"
    }

    println("grades2 = $grades2\n") // B
// ===========================================================
    typePrint("ABC\n") // 3
// ===========================================================
    println(analyze(1L) + "\n") // Long
// ===========================================================
    val personSet1: Set<String> = setOf("Kim", "park", "lee")
    val personSet2: Set<String> = setOf("park", "lee", "Kim")
    if(personSet1 == personSet2) {      //true(equal) -> 정보를 비교
        println("equal\n")
    } else {
        println("not equal\n")
    }
    if(personSet1 === personSet2) { // false(not Same) -> 주소를 비교
        println("same\n")
    } else {
        println("not Same\n")
    }

}
/*
fun maxOf(a: Int, b: Int): Int{
    if(a > b) {
        return a
    } else {
        return b
    }
}
 */
fun maxOf(a: Int, b: Int): Int = if (a > b) a else b

fun getStringLength(obj: Any?): Int?{
    return if(obj is String){   // is 연산자로 타입 체크 & 블록내에서 해당 타입으로 간주
        obj.length
    } else {
        null
    }
}

fun getStringLength2(obj: Any?): Int?{
    return if(obj !is String){
        null
    } else {
        obj.length
    }
}

fun getStringLength3(obj: Any?): Int?{
    return if(obj is String && obj.length > 0){
        obj.length
    } else {
        null
    }
}

fun getAge(name: String): Int{
    return when(name){
        "kim" -> 10
        "park" -> 20
        "lee" -> 30
        else -> 0
    }
}

fun getAge2(name: String): Int{
    return when(name){
        "kim" -> {
            println("kim")
            10
        }
        "park" -> {
            println("park")
            20
        }
        "lee" -> {
            println("lee")
            30
        }
        else -> {
            println("else")
            0
        }
    }
}
fun typePrint(value: Any) {
    when(value){
        is Int -> println("Int : ${value + 1}\n")
        is String -> println("String : ${value.length}\n")
        is IntArray -> println("IntArray : ${value.sum()}\n")
        // else -> 반환값이 없어서 else 가 필요없다
    }
}
fun analyze(obj: Any): String{
    return when(obj){
        0 -> "Zero"
        in 1..10 -> "1 ~ 10"
        "ABC" -> "String ABC"
        is Long -> "Long"
        !is String -> "Not String"
        else -> throw IllegalArgumentException("Invalid parameter")
    }
}