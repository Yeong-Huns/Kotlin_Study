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
    /*
    # 1.var
    * 변경 가능한 저장소
    * 클래스에서 변경 가능 프로퍼티(Field + Getter + Setter) 선언
    */
    var age : Int = 40; // var 변수명 : 타입 = 초기값
    var shortAge = 40 // 타입 추론이 가능한 형태면 변수형을 생략 가능하다.
    age = 30 // var 이기 때문에 값을 변경가능하다.
    println("age : $age") // = 30
    // ===========================================================
    /*
    # 2.val
    * 읽기 전용 저장소
    * 클래스에서 읽기 전용 프로퍼티(Field + Getter) 선언
     */
    val finalAge : Int = 40;
    // finalAge = 30; // Val cannot be reassigned(val를 선언하면 값 변경 불가)
    println("finalAge : $finalAge")
    val age2 : Int
    age2 = 40; // 값을 나중에 지정해 줘도 되지만, 그러기 위해서는 타입을 명시해줘야한다.(타입지정 안할시 컴파일 에러)

}