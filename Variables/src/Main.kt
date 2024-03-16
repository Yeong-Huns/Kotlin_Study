/**
 *packageName    : ${PACKAGE_NAME}
 * fileName       : ${NAME}
 * author         : Yeong-Huns
 * date           : 2024-03-13
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-13        Yeong-Huns       최초 생성
 */
fun main() {

    var age1 : Int = 40; // var 변수명 : 타입 = 초기값
    var shortAge = 40 // 타입 추론이 가능한 형태면 변수형을 생략 가능하다.
    age1 = 30 // var 이기 때문에 값을 변경가능하다.
    println("age : $age1\n") // = 30
    // ===========================================================
    val finalAge : Int = 40;
    // finalAge = 30; // Val cannot be reassigned(val를 선언하면 값 변경 불가)
    println("finalAge : $finalAge\n")
    val age2 : Int
    age2 = 40; // 값을 나중에 지정해 줘도 되지만, 그러기 위해서는 타입을 명시해줘야한다.(타입지정 안할시 컴파일 에러)
    // ===========================================================
    val a: Int = 1
    val b: Long = 2L
    val c: Long = a + b
    println("1 + 2L = $c")
    println(c::class) // long
    println()
    // ===========================================================
    val Int_a : Int = 1
    val Double_b : Double = 2.0
    val Double_c : Double = Int_a / Double_b
    // val Double_c: Double = Int_a.toDouble() / Double_b
    println("1 / 2.0 = $Double_c\n") // 0.5
    // ===========================================================
    val Long_value : Long = 1_000_000L
    println("Long_Value = $Long_value\n")
    // ===========================================================
    val chr : Char = '1'
    println("digitToInt() = 문자를 숫자로 변환 : ${chr.digitToInt()}\n")
    // ===========================================================
    val str : String = "ABCD"
    println("문자열 : $str\n")
    // ===========================================================
    val text: String = """
        for(chr int str){
            println(chr)
        }
    """.trimIndent()
    println("여러줄 문자열: $text\n")
    // ===========================================================
    val version : String = "1.9.10"
    println("Kotlin Version $version") // Kotlin Version 1.9.10

    val age : Int = 30
    println("My age is $age\n") // My age is 30
    // ===========================================================
    val s = "ABC"
    println("s = " + s::class) // s = String

    val i = 1
    println("i = " + i::class) // i = int

    val l = 1L
    println("l = " + l::class) // l = long

    val d = 1.0
    println("d = " + d::class) // d = double

    val f = 1.0F
    println("f = " + f::class + "\n") // f = float
    // ===========================================================
    println("PI : $PI\n")
}
const val PI : Double = 3.14159265359

