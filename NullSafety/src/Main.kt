/**
 *packageName    : ${PACKAGE_NAME}
 * fileName       : ${NAME}
 * author         : Yeong-Huns
 * date           : 2024-03-17
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-17        Yeong-Huns       최초 생성
 */
fun main() {
    val str: String? = "ABCDE"
    // println(str.length) -> str 을 nullable 로 생성하였기 때문에, null check 가 포함된 블럭 안에서는 null 을 고려하지 않아도 된다.
    if(str != null){
        println("length = ${str.length}") // length = 5
    } else {
        println("str is null")
    }
// ======================================================
    val bool : Boolean? = null // false
    if (bool == true) {
        println("true")
    } else {
        println("false of null")
    }
    // Boolean 에 null 을 허용하면 true, false, null 3가지의 경우가 생김
// ======================================================
    val str1: String? = "ABC"
    println(str1?.length)    //3
    val str2: String? = null
    println(str2?.length)   //null
// ======================================================
    val strNotNull: String? = "ABC"
    strNotNull?.let{
        println("strNotNull")     // str
    }
    val strNull: String? = null
    strNull?.let{
        println("strNull")      //실행되지 않음
    }
// ======================================================
    val str3: String? = null
    println("str3.toString() : ${str3.toString()}")     //null
    println("str3.toString() == null : ${str3.toString() == null}")     //false
    println("str3?.toString() == null : ${str3?.toString() == null}")    //true
// ======================================================
    // Elvis operator
    val nullableStr: String? = "ABC"
    val elvisStr = nullableStr ?: ""    //?: 옆으로 누운 엘비스 머리모양
    println("elvisStr = $elvisStr")     // elvisStr = ABC

    val nullableStr2: String? = null
    val elvisStr2 = nullableStr2 ?: ""
    println("elvisStr2 = $elvisStr2")       //
// ======================================================
    val age1: Int? = null
    val result1: Int = age1 ?: 0
    println("age1 = $result1")    // age = 0
// ======================================================
    val age2: Int? = null
    val result2: Int = age2 ?: return
    println("age2 = $result2")
// ======================================================
    val age3: Int? = null
    val result3: Int = age3 ?: throw Exception("null 발생")
    println("age3 = $result3")
// ======================================================
    //!!
    val nullableStr3: String? = "ABC"
    println(nullableStr3!!.length)   // 3

    val nullableStr4: String? = null
    println(nullableStr4!!.length)  // NullPointerException
// ======================================================
// ======================================================
}

