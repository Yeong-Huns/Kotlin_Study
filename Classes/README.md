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

<br>

null 불가 변수에 바로 값 초기화 하지 않기
```kotlin
fun main(){
    val person: Person = Person()
  person.name = "kim"
  println("name = ${person.name}")  // name = kim
}
class Person{
    lateinit var name: String
}
```
* backing fields 가 존재하는 프로퍼티는 인스턴스화 될 때 초기화가 바로 이루어져야함
* 프로퍼티에 값을 나중에 초기화 하기위해 lageinit var 사용
* 초기화 전에 해당 변수 호출하면 UninitializedPropertyAccessException 발생
* 초기화된 프로퍼티는 초기화 전 상태로 변경 불가

<br>

### 부 생성자 사용
```kotlin
fun main(){
    val person: Person = Person("kim")
  println("age = ${person.age}")    // age = 0
}
class Person(val name: String, val age: Int){
    constructor(name: String) : this(name, 0)
}
```
* 부 생성자는 값을 받아 주 생성자를 호출

<br>

init과 constructor 실행 순서
```kotlin
class Person(val name: String, val age: Int){
    init{
        println("init 주 생성자의 일부")
    }
  constructor(name: String) : this(name, 0){
      println("부 생성자")
  }
}
```
* 부 생성자로 호출을 했어도 그것이 바로 this에 의해 주 생성자에게 위임
* init 은 주 생성자의 일부분이여서 먼저 처리
* 생성자를 선언하지 않으면 인수 없이 생성된 주 생성자를 가짐

<br>

### Default Parameters
```kotlin
fun main(){
    val person: Person = Person("kim")
  println("age = ${person.age}")    //age = 0
}
class Person(val name: String, val age: Int = 0)
```

<br>

### Named Arguments
```kotlin
fun main(){
    val person1: Person = Person(name = "kim" , gender = "남")
    val person2: Person = Person(name = "park", age = 30, gender = "여")
  
    println("person1: ${person1.name} / ${person1.age} / ${person1.gender}")
  // person1 : kim / 1 / 남
    println("person2: ${person2.name} / ${person2.age} / ${person2.gender}")
  // person2 : park / 30 / 여
}
class Person(
  val name: String = "",
  val age: Int = 1,
  val gender: String = "남",  
)
```
* arguments 에 parameter 명을 명시해서 전달
* default parameters 통해 생성자를 다양한 방식으로 활용

<br>

### 정적 팩토리 함수
```kotlin
fun main(){
    val person: Person = Person.of("kim", 30)
  println("name = ${person.name}, age = ${person.age}")
  // name = kim , age = 30
}
class Person private constructor(val name: String, val age: Int){
    companion object {
        fun of(name: String, age: Int): Person = Person(name, age)
    }
}
```
* 생성자는 잠그고 companion object 를 활용해서 정적 팩토리 함수로 인스턴스 생성

<br>

### 클래스 간의 상속은 (:) 로 선언
```kotlin
open class Parent
class Child(
    val name: String,
    val age: Int,
) : Parent()
```
* kotlin 클래스는 기본적으로 final 이여서 상속을 허용하려면 open 키워드 필요
* 상속은 부모클래스의 모든 것을 가져오기 때문에 객체의 계층구조를 나타낼때 굉장히 좋지만 일부분만 재사용하기에는 적합하지 않음(이런 경우 컴포지션을 사용)
* 컴포지션은 객체를 프로퍼티로 갖고 함수를 호출하는 형태로 재사용 하는 방법

<br>

### 클래스 상속 처리
```kotlin
fun main(){
    val greenCar: GreenCar = GreenCar()
  greenCar.color()  // Green
}
open class Car{
    open fun color(){
        println("Red")
    }
}
class GreenCar : Car(){
    override fun color(){
        println("Green")
    }
}
```
* 메소드도 기본적으로 final 이여서 override 하려면 open 키워드 필요
* 메소드를 재정의 할때 override 키워드 사용

<br> 

### override 를 다시 override
```kotlin
fun main(){
    val bus: Bus = Bus()
  bus.color() // Blue
}
open class Car{
    open fun color(){
        println("Red")
    }
}
open class GreenCar : Car(){
    override fun color(){// final overrside fun color()
        println("Green")
    }
}
class Bus : GreenCar(){
    override fun color(){
        println("Blue")
    }
}
```
* override 된 함수는 open 되어있어서 이후 서브클래스에서 재정의 하지 않기위해서는 final 을 붙여줘야함

<br>

### 부모 클래스와 자식 클래스의 생성 순서
```kotlin
fun main(){
    val greenCar: GreenCar = GreenCar()
}
open class Car{
    init{
        println("Make Car")
    }
}
class GreenCar : Car(){
    init{
        println("Make GreenCar")
    }
}
```
* 부모 클래스 초기화 후 자식 클래스 초기화

<br>

### 부모 클래스 생성자에 인수 전달

```kotlin
fun main() {
  val greenCar: GreenCar = GreenCar("Green")
  greenCar.color()    //Green
}
open class Car(
  val color: String
) {
  fun color() {
    println("$color")
  }
}
class GreenCar(
    color: String
) : Car(color)
```

<br>

### 부모 클래스 호출(super)
```kotlin
fun main(){
    val greenCar: GreenCar = GreenCar()
  greenCar.color()
  // Red
  // override Green
}
open class Car {
    open fun color(){
        println("Reds")
    }
}
class GreenCar : Car(){
    override fun color(){
        super.color()
      println("override Green")
    }
}
```
* super 를 사용하여 부모 클래스 호출

<br>

### 상속 및 구현된 메소드의 명칭이 동일할 경우 super<...> 로 구분
```kotlin
fun main(){
    val greenCar: GreenCar = GreenCar()
  greenCar.color()
  //Red
  // override Green
}
open class Car{
    open fun color(){
        println("Red")
    }
}
interface Seat{
    fun color() {
        println("Black")
    }
}
class GreenCar : Car(), Seat{
    override fun color(){
        super<Car>.color()
      println("override Green")
    }
}
```

# 4. Classes(클래스) - data class

## 1. data class 
* 데이터 저장이 목적인 클래스를 쉽게 만들 수 있는 방법
* Spring 에서 DTO 만들때 사용
* 주 생성자에 있는 프로퍼티로 아래의 함수들을 만들어줌
  * getter, setter(var 로 선언된 프로퍼티)
  * equals()
  * hashCode()
  * toString()
  * copy()
  * componentN()
* 주 생성자에는 최소한 하나의 프로퍼티가 있어야함 (var 나 val 로 선언)
* 데이터 클래스는 abstract, open, sealed, inner 를 할 수 없음

<br>

### 기본 형식
```kotlin
data class 클래스명(val 프로퍼티: 타입)
```
```kotlin
data class Person(val name: String, val age: Int)
```

<br>

### 인스턴스 생성
```kotlin
fun main(){
    val person: Person = Person("kim", 30)
    println(person) // Person(name = kim, age = 30)
}
data class Person(
    val name: String, 
    val age: Int
)
```

<br>

### 인스턴스 비교(equals)
```kotlin
fun main(){
    val person: Person = Person("kim", 30)
    val person2: Person = Person("kim", 30)
    val Person3: Person = Person("park", 40)
  
  println("person == person2 : ${person == person2}")   // true
  println("person == person3 : ${person == person3}")   // fakse
}
data class Person(
    val name: String,
    val age: Int
)
```

<br>

### 인스턴스 복사
```kotlin
fun main(){
    val person: Person = Person("kim", 30)
    val person2: Person = person.copy("park")
    val person3: Person = person.copy(age = 40)
  
  println(person2)
  println(person3)
}
data class Person(
    val name: String,
    val age: Int
)
```

<br>

### 순서 기반 프로퍼티값 호출(componentN)

```kotlin
fun main(){
    val person: Person = Person("kim", 30)
    println(person.component1()) // kim
    println(person.component2()) // 30
}
data class Person(
    val name: String,
    val age: Int
)
```
* component1 : 첫번째 프로퍼티의 값 불러오기
* component2 : 두번째 프로퍼티의 값 불러오기
* 구조분해에서 사용

## 2. VIsibility modifiers(가시성 제어자)
| 가시성 제어자         | 범위                                                      |
|-----------------|---------------------------------------------------------|
| private         | 클래스 내부에서만 볼 수 있음                                        |
| protected       | private 와 동일한 가시성을 가지고 추가로 해당 클래스를 상속받은 하위 클래스에서 볼 수 있음 |
| internal        | 동밀한 모듈 내부에서 볼 수 있음                                      |
| public(default) | 모든 곳에서 볼 수 있음                                           |
* 동일한 모듈은 함께 컴파일된 kotlin 파일 들이라고 보면 됨

### 클래스에서 가시성 제어자를 사용해서 접근할 수 있는 범위
```kotlin
fun main(){
    val parent: Parent = Parent()
    // println("Parent.a = ${parent.a})
    // println("Parent.b = ${parent.b}")
  println("Parent.c = ${parent.c}")
  println("Parent.d = ${parent.d}")
  
  val child: Child = Child()
}
open class Parent {
    private val a = 1
  protected val b = 2
  internal  val c = 3
  val d = 4
}
class Child : Parent(){
    init {
        // println("Child.Parent.a = ${super.a}")
        println("Child.Parent.b = ${super.b}")
        println("Child.Parent.c = ${super.c}")
        println("Child.Parent.d = ${super.d}")
    }
}
```

# 5. Classes(클래스) - abstract class, interface

## 1. abstract class
* 자체적으로 인스턴스화 할 수 없고, 다른 클래스에 상속되어 구현되는 클래스
* abstract 키워드가 붙어있는 프로퍼티, 메소드는 서브클래스에서 구현되어야함
* 관련 클래스 그룹에 대한 공통 구조 정의

<br>

### 기본 형식
```kotlin
abstract class 클래스명 {
    // 추상 프로퍼티 (초기화 불가)
    abstract val 추상프로퍼티: 타입
    
    // 추상 메소드(자체구현 불가)
    abstract fun 추상메소드 (파라미터: 타입) : 리턴 타입
  
    // 실제 값을 가지고 있는 프로퍼티
  val 프로퍼티 : 타입 = 초기값
  //실제 구현되어있는 메소드
   fun 메소드(파라미터: 타입): 리턴타입 {
       //본문
       return 리턴값
   }
}
```
<br>

### 추상 클래스 상속

```kotlin
fun main() {
  val person: Person = Person("kim", 30)
  person.printInfo()  // name = kim, age = 30
}
class Person(
  val name: String,
  val age: Int
) : Info() {
  override fun printInfo() {
    println("name = $name, age = $age")
  }
}
abstract class Info {
    abstract fun printInfo()
}
```
*  추상 클래스는 자체 구현이 없음. 상속받으면 추상 클래스에 있는 추상 메소드 구현 필요
* 추상 클래스는 상속받으면 구현되어야하기 떄문에 open 키워드 필요 없음

<br>

## interface
* 여러 클래스 간에 공통 동작을 정의하여 코드 재사용성을 높이는 데 사용
* 인터페이스의 메서드는 추상(구현 없음)이거나 기본 구현을 가질 수 있음
* 하나의 클래스에서 여러 개의 인터페이스를 구현할 수 있음
* 인터페이스를 구현하는 클래스는 호출 코드에 영향을 주지 않고 쉽게 교체 가능

<br>

### 기본 형식
```kotlin
interface 인터페이스명 {
    // 추상 프로퍼티 (초기화 불가)
    val 프로퍼티 : 타입
    // 추상 메소드 (자체구현 가능)
    fun 메소드(파라미터: 타입) : 리턴타입
    
    // 기본 구현 메소드
    fun 메소드(파라미터: 타입): 리턴타입{
        // 본문
        return 리턴값
    }
}
```

<br>

### 인터페이스 구현

```kotlin
fun main() {
  val person: Person = Person("kim", 30)
  person.printInfo()  // name =kim , age = 30
}
class Person(
  private val name: String,
  private val age: Int,
) : Info {
  override fun printInfo() {
    println("name = $name , age = $age")
  }
}
interface Info {
    fun printInfo()
}
```
<br>

### 인터페이스 프로퍼티 구현
```kotlin
fun main(){
    val person: Person = Person()
    person.printInfo() // name = kim , age = 30
}
class Person: Info {
    override val name: String = "kim"
    override  fun  printInfo() {
        println("name = $name age = $age")
    }
}
interface Info {
    val name: String
    val age: Int    
      get() = 30
  fun printInfo()
}
```
* 인터페이스에서 선언된 프로퍼티는 추상이거나 접근자에 대한 구현을 제공할 수 있음