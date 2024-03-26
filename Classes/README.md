# 3. Classes (클래스) - class

<br>

## class
* 객체 지향 프로그래밍(OOP)의 기본 개념
* 객체의 구조와 동작을 정의
* 클래스를 가지고 인스턴스를 생성해서 사용

<br>

### 기본 형식
```kotlin
class 클래스명 {
    // 프로퍼티
    var 프로퍼티명: 타입
    
    //생성자
    constructor(파라미터: 타입) {
        프로퍼티명 = 파라미터
    }
    
    // 메소드
    fun 메소드명(파라미터: 타입): 리턴타입 {
        //본문
        return 리턴값
    }
}
```
```kotlin
// 주 constructor
class Person constructor(name: String, age: Int) {
    // 프로퍼티
    val name: String 
    var age: Int
    
    // init
    init{
        println("Person name = $name, age = $age")
        this.name = name
        this.age = age
    }
    // 부 constructor
    constructor(name: String): this(name, 0)
    
    // 메서드(멤버함수)
    fun addAge(inc: Int) {
        age += inc
    }
    // companion object
    companion object {
        fun of(name: String, age: Int): Person = Person(name, age)
    }
}
```
* 프로퍼티 = field + getter + setter
   * 클래스에서 프로퍼티를 생성하면 컴파일러가 자동으로 getter, setter 추가
   * 코틀린은 값에 접근할때 기본적으로 getter, setter 를 사용해서 값에 접근
   * 프로퍼티는 상태를 나타내고 함수는 행동을 나타내는게 일반적
* 메소드(멤버함수): 클래스 안에 선언되어있는 함수
* 선언 순서
  * 프로퍼티
  * init
  * 부 constructor
  * 메서드(멤버함수)
  * companion object
  
<br>

### 주 생성자
```kotlin
class Person constructor(name: String, age : Int) {
    val name: String = name
    val age: Int = age
}
```
* constructor 생략 가능

<br>

### 인스턴스 생성
```kotlin
fun main(){
    val person: Person = Person("kim", 30)
    println("name = ${person.name}")    // name = kim
}
class Person(name: String, age: Int) {
    val name: String = name
    val age: Int = age
}
```

<br>

### 프로퍼티와 주 생성자를 동시에 작성

```kotlin
class Person(val name: String, val age: Int)
```
* constructor
* private 로 생성자 만드려면 private constructor 라고 명시 필요

<br>

### var, val 선언에 대해 getter, setter 생성
```kotlin
fun main(){
    val person: Person = Person("kim", 30)
    println("name = ${person.name}")
}
class Person(
    var name: String,
    var age: Int
){
    fun getName(): String = this.name // error
}
```
* 컴파일시 getter, setter 자동으로 생성되니 동일 이름으로 메소드 만들면 error 발생

<br>

### custom getter

```kotlin
fun main() {
  val person: Person = Person("kim", 30)
  println(person.info)    // name = kim, age = 30
}
class Person(
  private val name: String,
  private val age: Int
) {
  val info: String
    get() = "name = $name, age = $age"
}
```
* 프로퍼티에는 로직이 들어가지 말고 현재 상태만을 나타내도록 사용

<br>

### Backing fields 를 활용한 custom setter
```kotlin
fun main(){
    val person: Person = Person()
    person.info = "kim / 30"
    println(person.info)    // value = kim / 30
}
class Person {
    var info: String = ""
      set(value) {
          field = "value = $value"
      }
}
```
* 값을 넣을때 setter 를 호출
* custom setter 안에서 info 이름으로 데이터를 넣으려고 하면 또 다시 setter 를 호출하면서 무한루프
* 이때 Backing fields 에 값을 입력, 프로퍼티의 접근자에서만 사용 가능

<br>

### 클래스 초기화
```kotlin
fun main(){
    val person: Person = Person("kim", 30)
    println("name = ${person.name}")    // name = kim
}
class Person constructor(name: String, age: Int){
    val name: String = name
    val age: Int = age
  init{
      println("Person name = $name, age = ${this.age}")
        // Person name = kim, age = 30
  }
}
```
* init 이 여러개인 경우 위에서부터 순서대로 실행
* 주 생성자 파라미터를 init 에서 쓰려면 바로 변수명을 적고 프로퍼티의 값을 쓰려면 this.으로 사용

