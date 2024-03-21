# 1. Functions (함수) - Function, Extension, inline

<br>

## 1. Function

* 함수는 특정 작업을 수행하는 재사용 가능한 코드 블록
* 파라미터를 받고 처리 후 결과를 리턴
* 파라미터로 전달된 값은 불변

<br>

### 기본 형식

```kotlin
fun 함수명(파라미터: 타입): 리턴타입 {
    //본문
    return 리턴값
}
```
```kotlin
fun add1(a: Int, b: Int): Int {
    return a + b
}
```

<br>

### 단일 표현식
```kotlin
fun add2(a: Int, b: Int): Int = a + b
```
* 함수 본문이 단일 표현식으로 구성된 경우 중괄호를 생략하고 = 뒤에 본문 작성

<br>

### 함수와 메소드(멤버함수) 호출
```kotlin
fun main() {
    println(callAdd(1,2)) // 3
    println(Calculator().callAdd(3, 4)) // 7
    // 함수 -> 함수명 호출 , 메소드 -> 인스턴스를 만들어서 호출(Calculator().callAdd())
}
fun callAdd(a: Int, b: Int): Int = a +  b

class Calculator {
    // 메소드(멤버함수)
    fun callAdd(a: Int, b: Int): Int = a + b
}
```
* 함수는 바로 함수명으로 호출하고 메소드는 인스턴스를 만들어서 호출

<br>

### return 값이 없는 함수(Unit)
```kotlin
fun printAdd(a: Int, b: Int): Unit {
    println("$a + $b = ${a + b}")
}
```
* 값을 리턴하지 않는 경우 return type 을 Unit 으로 선언(Unit 생략 가능)

> #### 📌 Unit 을 리턴하면서 생략하는 경우가 있으니 다른 리턴 타입들은 함수에 명시 권장

<br>

### 아규먼트에 파라미터 이름을 붙여서 호출(named Arguments)
```kotlin
fun main(){
    println(info("kim", 30))
    println(info(name = "kim", age = 30))
    println(info(age = 30, name = "kim")) 
    //변수명을 직접 명시하면 순서를 바꿔도 괜찮다.
}
fun info(name: String, age: Int): String{
    return "name = $name, age = $age"
}
```
* 이름을 명시하면 아규먼트가 많아도 명확하게 구분 가능

<br>

### Default Parameters
```kotlin
fun info2(name: String = "empty", age: Int = 0): String{
    return "name = $name, age = $age"
}
```
* 파라미터에 기본값을 설정할 수 있음. 이렇게 하면 overload 되는 함수의 수를 줄일 수 있음

<br>

### 가변 파라미터(vararg)
```kotlin
fun main(){
    printAll1("kim", "park", "lee")
}
fun printAll1(vararg names: String) {
    for(name in names) {
        println(name)
    }
}
```
* vararg 는 동일한 유형의 여러 아규먼트를 허용할 수 있는 함수를 정의하는 데 사용되는 키워드
* 이렇게 전달된 값은 배열로 처리

<br>

### 일반 파라미터와 가변 파라미터 혼용
```kotlin
fun main(){
    printAll2("student", "kim", "park", "lee")
}
fun printAll2(subject: String, vararg names: String){
    println("---$subject---") // student
    for(name in names){ //kim, park, lee
        println(name)
    }
}
```
* 일반 파라미터를 앞에 배치해서 순서대로 전달하고 남은 아규먼트들은 모두 vararg 에 전달

<br>

### 함수를 파라미터로 전달(고차함수)
```kotlin
fun main(){
    val plus: Int = calculator(1,2,{x , y -> x + y})
    val multiply: Int = calculator(1,2){x , y -> x * y}
}
fun calculator(a: Int, b: Int, operator: (Int, Int) -> Int): Int {
    return operator(a, b)
}
```
* operator: (Int, Int) -> Int: Int 2개를 받아서 Int 1개를 리턴하는 함수
* 함수타입이 파리미터의 마지막에 배치될때는 괄호 밖으로 뺄 수 있음


---

<br>

## 2. 확장함수

<br>

### 기본 형식
```kotlin
fun 클래스, 확장함수명(파라미터: 타입): 리턴타입 {
    //본문
    return 리턴값
}
```
```kotlin
fun String.info(): String {
    return "$this, Length = ${this.length}"
}
val testString : String = "테스트할 문자열입니다."
println(testString.info())
//테스트할 문자열입니다., Length = 12
```

<br>

### 포맷변경 확장함수 추가
```kotlin
fun main(){
    val amount: Long = 100L
    println("amount = ${amount.formatDollar()}")    //amount = $100
}
fun Long.formatDollar(): String {
    return "\$$this"
}
```
* this 는 receiver(.앞에 전달되는 객체)

<br>

### 제네릭과 함께 사용한 리스트 스왑 확장함수
```kotlin
fun main(){
    val mutableList: MutableList<String> = mutableListOf("kim", "park", "lee")
    println(mutableList)
    
    mutableList.swap(0, 2)
    println(mutableList)
}
fun <T> MutableList<T>.swap(idx1: Int, idx2: Int){
    val temp = this[idx1]
    this[idx1] = this[idx2]
    this[idx2] = temp
}
```

### 확장함수의 시그니처와 클래스의 멤버함수가 겹치면 멤버함수 호출
```kotlin
fun main(){
    val person: Person = Person("kim", 20)
    println(person.info())  // [class]
}
class Person(
    val name: String, 
    val age: Int,
){
    fun info(): String {
        return "[class]"
    }
}
fun Person.info(str: String): String{
    return "[extension] $str"
}
```
* 클래스의 멤버함수가 우선 호출된다.

<br>

### 시그니처가 다르면 overload
```kotlin
fun main(){
    val person: Person = Person("kim", 20)
    println(person.info("ABC")) // [extension] ABC
}
```
* 시그니처가 일치하는 함수 호출

<br>

### companion object 에 확장함수 사용
```kotlin
fun main(){
    Person2.printInfo() // Person companion
}
class Person2{
    companion object{}
}
fun Person2.Companion.printInfo(){
    println("Person companion") 
}
```
* companion object 에 있는 함수는 인스턴스 없이 클래스로 바로 호출

---

<br>

## 3. inline 함수
* 함수 호출을 실행하는 대신 함수 코드를 호출 위치에 직접 삽입하도록 컴파일러에 지시하는 함수
* 람다 또는 고차 함수로 작업할 때 성능 향상 기능
* 런타임 오버헤드를 줄이고 보다 효율적인 코드를 생성하기 위한 방법
* inline 키워드를 사용해서 함수 선언

<br>

### 기본 형식
```kotlin
inline fun 함수명(파라미터: 타입): 리턴타입{
    // 본문
    return 리턴값
}
```
```kotlin
inline fun Int.plus(value: Int): Int = this + value
```

<br>

### java 로 디컴파일시 호출위치에 inline 함수 삽입
```kotlin
fun main() {
    inlined()
    println("==============")
    noInlined()
}
inline fun inlined(){
    println("inlined function")
}
fun noInlined(){
    println("noInlined function")
}
```
* inline 함수를 사용하면 함수에서 호출되는 함수로 위치를 이동하는 과정이 생략
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
* 자바로 디컴파일 해보면 인라인 함수 위치에 직접 코드가 들어간것을 확인 할 수 있음

---
# 2. Function (함수) - infix, operator, tailrec 

<br>

## 2.1 중위함수
* 연산자와 유사한 특정 구문으로 함수를 호출할 수 있는 기능
* infix 키워드를 사용해서 함수 선언

<br>

### 기본 형식
```kotlin
infix fun 클래스.중위함수명(파라미터: 타입): 리턴타입 {
    //본문
    return 리턴값
}
```
```kotlin
infix fun Int.plus(value: Int): Int = this + value
```

<br>

### 중위함수
```kotlin
fun main(){
    val ip: String = "192.0.0.1"
    val port: String = "8080"
    val address: String ip and port
    println("address = $address")   // address = 192.0.0.1:8080
}
infix fun String.and(port: String) = "$this:$port"
```
* 메소드 호출하는 표기법만 다르다고 생각하면 됨

<br>

### Pair 를 반환하는 중위함수(to)
```kotlin
val pair: Pair<String, Int> = "kim" to 30
println(pair)   // (kim, 30)
```
* Pair 는 2개의 값 모음을 나타내는 간단한 클래스

<br>

### 중위표현은 클래스에서도 가능

```kotlin
fun main() {
    val kim: Instagram = Instagram("kim")
    val park: Instagram = Instagram("park")
    val lee: Instagram = Instagram("lee")

    kim follow park
    kim follow lee

    for (follow in kim.followList){
        println(follow.id)  //park, lee
    }
}
class Instagram(val id: String) {
    val followList: MutableList<Instagram> = mutableListOf<Instagram>()
    infix fun follow(other: Instagram) {
        followList.add(other)
    }
}
```