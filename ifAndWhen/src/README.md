# if, when (분기문)

<br>

## 1. if
* 분기문, 조건에 따라 참 / 거짓을 판별할때 사용
* expression 으로 값 자체를 리턴할 수 있음

<br>

### 기본형식
```kotlin
if (참, 거짓을 판별할 수 있는 조건) {
    참일 경우 작업
} else {
    거짓인 경우 작업
}
```
```kotlin
if (a > b) {
    max = a
} else {
    max = b
}
```

<br>

### 두개의 수 중에 큰 수 찾기
```kotlin
val maxA: Int = 10
val maxB: Int = 20
val max: Int

if(maxA > maxB) {
    max = maxA
} else {
    max = maxB
}
println("max = $max")   // max = 20
```

<br>

### 코틀린에는 삼항연산자는 없고 if...else... 로 표현
```kotlin
val maxA2: Int = 10
val maxB2: Int = 20
val max2 = if(maxA2 > maxB2) maxA2 else maxB2
println("max2 = $max2")      // max2 = 20
```
* if 문은 expression 이여서 값 자체를 리턴할 수 있음, 그래서 삼항연산자가 필요없음

<br>

### function 에 if 문으로 값을 던지는 경우 expression 으로 변경

```kotlin
fun maxOf(a: Int, b: Int): Int {
    if(a > b) {
        return a
    } else {
        return b
    }
}

// expression 으로 변경
fun maxOf(a: Int, b: Int): Int = if(a > b) a else b
```
<br>

### if 문의 블록의 마지막 표현이 반환되는 값

```kotlin
val maxA3: Int = 10
val maxB3: Int = 20
val max3: Int = if(maxA3 > maxB3) {
    println("maxA3가 maxB3보다 더 큼")
    maxA3
} else {
    println("maxB3가 maxA3보다 더 크거나 같음")
    maxB3
}
println("max3 = $max3")     // max3 = 20
```
* 값을 반환하거나 변수에 할당하기 위해 if 문을 사용하는 경우 else 는 필수

<br>

### Range 와 in 을 사용해서 해당 범위안에 값의 포함 여부 확인 가능
```kotlin
val index1: Int = 5
if(index1 in 1..10) { //1 ~ 10
    println("contain 5")
}
```
```kotlin
val index2: Int = 5
if(index2 !in 6..10) {      //1 ~ 10
    println("not contain 5")
}
```
* kotlin 에서 범위를 나타내는 range operator(..)

<br>

### List 와 In 을 사용해서 list 안에 값의 포함 여부 확인 가능
```kotlin
val memberList: List<String> = listOf("kim", "park", "lee")
if("kim" in memberList) {
    println("contain kim")
}
```

<br>

### array 와 In 을 사용해서 array 안에 값의 포함 여부 확인 가능
```kotlin
val age: Int = 30
if(age in arrayOf(30, 40, 50)) {
    println("contain")
} else {
    println("not contain")
}
```

<br>

### is 연산자로 타입 체크 / 자동 타입 캐스팅

```kotlin
fun main() {
    val string: String? = "ABCDE"
    val length: Int? = getStringLength(string)
    println(length)
}

fun getStringLength(obj: Any?): Int?{
    return if(obj is String){
        obj.length
    } else {
        null
    }
}

fun getStringLength2(obj: Any?): Int?{
    return if(obj !is String){
        null
    } else {
        obj.length
    }
}

fun getStringLength3(obj: Any?): Int?{
    return if(obj is String && obj.length > 0){
        obj.length
    } else {
        null
    }
}
```
* is 연산자로 타입을 체크해서 true 일때 타입 캐스팅이 되어 해당 블럭 안에서 체크한 타입으로 사용

---

<br>

## 2. when
* 분기문, 변수의 값에 따라 다르게 처리
* switch 와 유사하지만 kotlin 에는 switch 가 없음
* expression 으로 값 자체를 리턴할 수 있음
* 조건식은 if 문의 조건식과 동일

<br>

### 기본 형식
```kotlin
when (변수) {
    조건1 -> 참인 경우 작업
    조건2 -> 참인 경우 작업
    조건3 -> 참인 경우 작업
    else -> 어느 조건도 만족하지 않는다면 작업
} 
```
```kotlin
when (name) {
    "kim" -> 10
    "park" -> 20
    "lee" -> 30
    else -> 0
}
```

<br>

### 기본적인 변수에 따른 처리
```kotlin
fun main() {
    val whenAge: Int = getAge("park")
    println(whenAge)
}

fun getAge(name: String): Int{
    return when(name){
        "kim" -> 10
        "park" -> 20
        "lee" -> 30
        else -> 0
    }
}
```
* 모든 분기문은 하나가 만족할때까지 순차적으로 진행
* 만족하는 것이 나오면 그것만 실행하고 종료
* else 는 필수지만 컴파일러가 가능한 케이스를 알 수 있으면 생략 가능 (ex. enum class, sealed class)

<br>

### when 문 블록의 마지막 표현이 반환되는 값
```kotlin
fun main(){
    val whenAge2: Int = getAge2("park")
    println("whenAge2 = $whenAge2")     // whenAge2= 20
}

fun getAge2(name: String): Int{
    return when(name){
        "kim" -> {
            println("kim")
            10
        }
        "park" -> {
            println("park")
            20
        }
        "lee" -> {
            println("lee")
            30
        }
        else -> {
            println("else")
            0
        }
    }
}
```
* 블럭 마지막의 Int 값이 반환되는 값이다.

<br>

### if...else if...else 문을 when 문으로 변경

```kotlin
val score: Int = 90
var grades: String

if ((score > 90) && (score <= 100)) {
    grades = "A"
} else if (score > 80) {
    grades = "B"
} else if (score > 70) {
    grades = "C"
} else if (score > 60) {
    grades = "D"
} else {
    grades = "F"
}

println("greades = $grades")    // B
```

```kotlin
val score2: Int = 90
var grades2: String = when (score2) {
    in 91..100 -> "A"
    in 81..90 -> "B"
    in 71..80 -> "C"
    in 61..70 -> "D"
    else -> "F"
}

println("grades2 = $grades2") // B
```
* expression 으로 바로 값 반환

<br>

### is 연산자로 타입 캐스팅 후 타입에 따른 출력
```kotlin
fun main() {
    typePrint("ABC") // 3
}

fun typePrint(value: Any) {
  when(value){
      is Int -> println("Int : ${value + 1}")
      is String -> println("String : ${value.length}")
      is IntArray -> println("IntArray : ${value.sum()}")
  }  
}
```
* 반환값이 없기 때문에 else 가 필요 없다.

<br>

### 값, 타입 혼합해서 체크 가능
```kotlin
fun main() {
    println(analyze(1L)) // Long
}

fun analyze(obj: Any): String{
    return when(obj){
        0 -> "Zero"
        in 1..10 -> "1 ~ 10"
        "ABC" -> "String ABC"
        is Long -> "Long"
        !is String -> "Not String"
        else -> throw IllegalArgumentException("Invalid parameter")
    }
}
```

---

<br>

## 3. 비교

<br>

### 동등성 비교(==)
```kotlin
val personSet1: Set<String> = setOf("Kim", "park", "lee")
val personSet2: Set<String> = setOf("park", "lee", "Kim")
if(personSet1 == personSet2) {      //true
    println("equal")
} else {
    println("not equal")
}
```
* 객체가 가지는 **정보**를 비교
* 반대표현은 !=
* a?.equals(b)?:(b===null)로 비교 
* 모든 클래스의 슈퍼클래스인 Any 에 구현되어 있어 모든 객체에서 사용 가능

<br>

### 동일성 비교(===)
```kotlin
val personSet1: Set<String> = setOf("Kim", "park", "lee")
val personSet2: Set<String> = setOf("park", "lee", "Kim")
if(personSet1 === personSet2) { // false
    println("same")
} else {
    println("not Same")
}
```
* 객체가 참조하는 **주소**값을 비교
* 반대표현은 !==