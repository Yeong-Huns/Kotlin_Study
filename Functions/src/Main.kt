/**
 *packageName    : ${PACKAGE_NAME}
 * fileName       : ${NAME}
 * author         : Yeong-Huns
 * date           : 2024-03-20
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-03-20        Yeong-Huns       최초 생성
 */
fun main() {
    fun add1(a: Int, b: Int): Int{
        return  a + b
    }
    fun add2(a: Int, b: Int): Int = a + b // 함수 본문이 단일 표현식 -> 중괄호 생략 후 = 뒤에 본문 작성
    // ===========================================================
    println("callAdd(1, 2) = ${callAdd(1,2)}\n") // 3 -> 함수
    println("Calculator().callAdd(3, 4) = ${Calculator().callAdd(3, 4)}\n") // 7 -> 메소드(멤버함수)
    // 함수 -> 함수명 호출 , 메소드 -> 인스턴스를 만들어서 호출(Calculator().callAdd())
    // ===========================================================
    fun printAdd(a: Int, b: Int): Unit {
        println("printAdd = $a + $b = ${a + b}\n")
    }
    printAdd(4, 7)
    // ===========================================================
    println(info("kim", 30))
    println(info(name = "kim", age = 30))
    println(info(age = 30, name = "kim")) // 변수명 직접 명시시, 순서를 바꿔도 상관 x
    println()
    // ===========================================================
    println(info2(name = "park")) // 명시하지 않은 파라미터는 기본값으로 설정 -> name : park , age : 0
    println(info2(age = 30)) // -> name : empty, age : 30
    println()
    // ===========================================================
    printAll("kim", "park", "lee")  // vararg -> 전달된 값은 배열로 처리
    // ===========================================================
    printAll2("student", "kim","park","lee") // 일반 파라미터(subject)를 앞에 배치해서 순서대로 전달하고 남은 아규먼트를 모두 vararg 에 전달
    // ===========================================================
    val plus: Int = calculator(1,2,{x , y -> x + y})
    val multiply: Int = calculator(1,2){x , y -> x * y}
    // operator((x, y) -> x * y)
    // operator((a, b) -> a * b)
    println("plus = $plus") //plus = 3
    println("multiply = $multiply") // multiply = 2
    println()
    // ===========================================================
    val testString : String = "테스트할 문자열입니다"
    println(testString.info()) //테스트할 문자열입니다 Length = 11
    // ===========================================================
    val amount: Long = 100L
    println(amount.formatDollar()) //$100
    // ===========================================================
    val mutableList: MutableList<String> = mutableListOf("kim", "park", "lee")
    println("mutableList = $mutableList")
    mutableList.swap(0,2)
    println("mutableList.swap(0, 2) =  $mutableList\n")
    // ===========================================================
    val person: Person = Person("kim", 20)
    println("person.info() = ${person.info()}\n")   //[class] -> 클래스의 멤버함수(메서드)가 먼저 호출된다
    // ===========================================================
    println("person.info('ABC') = ${person.info("ABC")}\n") //[extension] ABC -> 시그니처가 일치하는 함수 호출
    // ===========================================================
    Person2.printInfo() // Person companion -> companion object 에 있는 함수는 인스턴스 없이 클래스로 바로 호출(Person2.Companion.printInfo())
    // ===========================================================
    val inlineAddTest: Int = 4
    println("inlineAddTest = ${inlineAddTest.plus(6)}\n")
    // ===========================================================
    inlined()   // -> 함수에서 호출되는 함수로 위치를 이동하는 과정 생략
    println("===========================================================")
    noInlined()

    /*
    자바로 디컴파일 해보면 인라인 함수 위치에 직접 코드가 들어간 것을 확인 할 수 있음
    ```java
    public final class MainKt {
        public static final void main(){
            int $i$f$inlined = false;
            String var1 = "inline function"; // inlined() 가 있던 위치
            System.out.println(var1);
            String var2 = "==============";
            System.out.println(var2);
            noInlined();
        }
        //$FF: synthetic method
        public static void main(String[] var0){
            main();
        }
        public static final void inlined(){
            int $i$f$inlined = 0;
            String var1 = "inlined function";
            System.out.println(var1);
        }
        public static final void noInlined(){
            String var0 = "noInline function";
            System.out.println(var0);
        }
    }
    ```
    */
}
fun callAdd(a: Int, b: Int): Int = a +  b

class Calculator {
    // 메소드(멤버함수)
    fun callAdd(a: Int, b: Int): Int = a + b
}

fun info(name: String, age: Int): String{
    return "info = {name : $name, age : $age}"
}

fun info2(name: String = "empty", age: Int = 0): String{
    return "info2 = {name : $name, age : $age}"
}

fun printAll(vararg names: String){
    print("printAll = ")
    for(name in names){
        print("$name ")
    }
    println("\n")
}

fun printAll2(subject: String, vararg names: String) {
    println("---$subject---")
    print("printAll2 = ")
    for(name in names){
        print("$name ")
    }
    println("\n")
}

fun calculator (a: Int, b: Int, operator: (Int, Int) -> Int): Int {
    return operator(a, b)
}

fun String.info(): String {
    return "$this Length = ${this.length}\n"
}

fun Long.formatDollar(): String {
    return "\$$this\n"
}

fun <T> MutableList<T>.swap(idx1: Int, idx2: Int){
    val temp = this[idx1]
    this[idx1] = this[idx2]
    this[idx2] = temp
}

class Person(
    val name: String,
    val age: Int
){
    fun info(): String{
        return "[class]"
    }
}
fun Person.info(str: String): String {
    return "[extension] $str"
}

class Person2{
    companion object{}
}
fun Person2.Companion.printInfo(){
    println("Person companion\n")
}

inline fun Int.plus(value: Int): Int = this + value

inline fun inlined(){
    println("inlined function")
}
fun noInlined(){
    println("noInlined function\n")
}