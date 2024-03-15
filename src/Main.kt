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
    ## 1.var
    * 변경 가능한 저장소
    * 클래스에서 변경 가능 프로퍼티(Field + Getter + Setter) 선언
    */
    var age : Int = 40; // var 변수명 : 타입 = 초기값
    var shortAge = 40 // 타입 추론이 가능한 형태면 변수형을 생략 가능하다.
    age = 30 // var 이기 때문에 값을 변경가능하다.
    println("age : $age") // = 30
    // ===========================================================
    /*
    ## 2.val
    * 읽기 전용 저장소
    * 클래스에서 읽기 전용 프로퍼티(Field + Getter) 선언
     */
    val finalAge : Int = 40;
    // finalAge = 30; // Val cannot be reassigned(val를 선언하면 값 변경 불가)
    println("finalAge : $finalAge")
    val age2 : Int
    age2 = 40; // 값을 나중에 지정해 줘도 되지만, 그러기 위해서는 타입을 명시해줘야한다.(타입지정 안할시 컴파일 에러)

    /*
    ```
    1. var 보다는 val을 사용해서 읽기 전용 변수를 사용하고 필요한 경우 var로 변경하는 것을 권장
    2. 변수는 읽기 전까지만 초기화되면 문제없지만 정의와 동시에 초기화하는 방식을 권장
    3. 변수의 스코프는 좁게 가져가는 것을 권장(추적이 쉬워서 가독성이 좋음)
    ```
    ## 3. 타입
    |타입|담는 정보|사이즈|범위|
    |:---:|:---:|:---:|:---|
    |**Byte**|부호 있는 정수| 1 byte | -128 ~ 127
    |**Short**|부호 있는 정수|2 byte|-32,768 ~ 32,767|
    |<U>**Int**</U>|부호 있는 정수|4 byte|-2,147,483,648 ~ <br>2,147,483,647|
    |<U>**Long**</U>| 부호 있는 정수| 8 byte|-9,223,372,036,854,775,808 ~ <br>9,223,372,036,854,775,807|
    |**Float** |소수점 숫자 |4 byte||
    |<U>**Double**</U>| 소수점 숫자| 8 byte||
    |**Char**| 문자 1개| 2 byte||
    |<U>**String**</U>| 문자열| 가변||
    |<U>**Boolean**</U>| true / false| 1 byte||
    |**Array**| 배열| 가변||
    |<U>**List**</U>| 순서가 지정된 항목| 가변||
    |<U>**Set**</U>| key의 모음 |가변||
    |<U>**Map**</U>| key, value로 구성| 가변||

    ### Int와 Long 연산
    ```kotlin
    val a: Int = 1
    val b: Long = 2L
    val c: Long = a + b
    println("1 + 2L = $c")
    println(c::class) // long
    ```
    * 더 큰 사이즈인 Long으로 변환
    */
    val a: Int = 1
    val b: Long = 2L
    val c: Long = a + b
    println("1 + 2L = $c")
    println(c::class) // long
    /*
    ### 소수점 계산
    ```
    val Int_a : Int = 1
    val Double_b : Double = 2.0
    val Double_c : Double = Int_a / Double_b
    // val Double_c: Double = Int_a.toDouble() / Double_b
    println("1 / 2.0 = $Double_c") // 0.5
    ```
    * 정수끼리 나누면 소숫점 이하 버림 처리, 소수와 함께 계산해야 소수점 계산
    * 정수에 toDouble 함수를 사용해서 형변환 하는 방법도 있음
    */
    val Int_a : Int = 1
    val Double_b : Double = 2.0
    val Double_c : Double = Int_a / Double_b
    // val Double_c: Double = Int_a.toDouble() / Double_b
    println("1 / 2.0 = $Double_c") // 0.5

    /*
    ### 언더바(_)로 천단위 표시
    ```kotlin
    val value : Long = 1_000_000L
    println("Long_Value = $Long_value")
    ```
    * 언더바(_)로 천단위 표시를 함으로써 가독성을 올릴 수 있음
     */
    val Long_value : Long = 1_000_000L
    println("Long_Value = $Long_value")
    /*
    ### 문자 하나는 Char
    ```kotlin
    val chr : Char = `1`
    println("digitToInt() = 문자를 숫자로 변환 : ${chr.digitToInt()}") // 1
    ```
    * 문자 하나는 작은 따옴표('')로 표기
    * character 문자를 그대로 숫자로 변환할 때 digitToInt() 사용
    */
    val chr : Char = '1'
    println("digitToInt() = 문자를 숫자로 변환 : ${chr.digitToInt()}")
    /*
    ### 문자열은 String
    ```kotlin
    val str : String = "ABCD"
    println("문자열 : $str")
    ```
    * 문자열은 쌍따옴표("")로 표기
    * 문자열을 초기화하면 변경 불가, 문자열을 바꾸면 변경하지 않고 새 String 객체를 반환
    */
    val str : String = "ABCD"
    println("문자열 : $str")

    /*
    ### 여러줄 문자열
    ```kotlin
    val text : String = """
    for (chr in str){
        println(chr)
        }
    """.trimIndent()
    println("여러줄 문자열: $text")
    ```
    * 여러줄 문자열은 삼중따옴표(""")로 구분
     */
    val text: String = """
        for(chr int str){
            println(chr)
        }
    """.trimIndent()
    println("여러줄 문자열: $text")
}