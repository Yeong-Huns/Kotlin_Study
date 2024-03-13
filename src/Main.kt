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
    // var : 변경할 수 있는 변수
    // val : 변경할 수 없음 (자바의 final)
    var age : Int = 40; // var or val 변수명 : 변수형 = 초기값
    var shortAge = 40 // 타입 추론이 가능한 형태면 변수형을 생략 가능하다.
    age = 30 // var 이기 때문에 값을 변경가능하다.
    println("age : $age") // = 30
    val finalAge : Int = 40;
    // finalAge = 30; // val로 선언한 변수는 값을 변경하려 하면 컴파일 에러가 발생한다.
    println("finalAge : $finalAge")

}