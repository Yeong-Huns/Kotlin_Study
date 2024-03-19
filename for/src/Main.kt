/**
 *packageName    : ${PACKAGE_NAME}
 * fileName       : ${NAME}
 * author         : Yeong-Huns
 * date           : 2024-03-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-19        Yeong-Huns       최초 생성
 */
fun main() {
    val memberList: List<String> = listOf("kim", "park", "lee")
    println("리스트에 있는 값을 하나씩 사용")
    for (member in memberList) {
        println(member)
    }
    println()
 // ===========================================================
    println("리스트의 인덱스를 가져와서 사용(indices)")
    for (index in memberList.indices) {
        println("index = $index, value = ${memberList[index]}")
    }
    println()
 // ===========================================================
    println("리스트의 인덱스와 값을 같이 가져와서 사용(withIndex)")
    for((index, value) in memberList.withIndex()){
        println("index= $index, value= $value")
    }
    println()
 // ===========================================================
    println("range operator(..)을 사용")
    for(i in 1..10) { // 1 ~ 10
        println(i)
    }
    println()
 // ===========================================================
    println("step 을 사용하여 2씩 증가")
    for(i in 1..10 step 2){ // 1, 3, 5, 7, 9 숫자를 2씩 증가
        println(i)
    }
    println()
 // ===========================================================
    println("downTo 를 사용하여 역순")
    for(i in 10 downTo 1) { // 10 ~ 1 역순
        println(i)
    }
    println()
 // ===========================================================
    println("range operator(..) 문자 사용")
    for (c in 'a'..'e') { // a ~ e
        println(c)
    }
    println()
    println("range operator(..) 문자+역순+step 사용")
    for(c in 'e' downTo 'a' step 2){ // e, c, a
        println(c)
    }
    println()

 // ===========================================================
    println("return 으로 반복문 컨트롤 하는 방법")
    loopReturn()   // j == 2 되는 순간 반환
    println()
    // ===========================================================
    println("break 로 반복문 컨트롤 하는 방법")
    loopBreak()     // j == 2 되는 순간 가장 가까운 반복문(j in 0..3) 종료
    println()
    // ===========================================================
    println("continue 로 반복문 컨트롤 하는 방법")
    loopContinue()  // j == 2 되는 순간 다음단계 반복문 진행
    println()
    // ===========================================================
    println("label 로 반복문 컨트롤 하는 방법")
    loopLabel() // j == 2 되는 순간 라벨로 표시된 반복문 종료
    println()
    // ===========================================================
}
fun loopReturn() {
    for(i in 0..3) {
        for (j in 0..3){
            if (j == 2) return
            println("i = $i, j = $j")
        }
    }
}
fun loopBreak() {
    for(i in 0..3) {
        for (j in 0..3){
            if (j == 2) break
            println("i = $i, j = $j")
        }
    }
}
fun loopContinue() {
    for(i in 0..3) {
        for (j in 0..3){
            if (j == 2) continue
            println("i = $i, j = $j")
        }
    }
}
fun loopLabel() {
    loop@ for(i in 0..3) {
        for (j in 0..3){
            if (j == 2) break@loop
            println("i = $i, j = $j")
        }
    }
}