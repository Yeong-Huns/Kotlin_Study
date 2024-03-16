# Variables(변수)

## 1. var

* 변경 가능한 저장소
* 클래스에서 변경 가능 프로퍼티(Field + Getter + Setter) 선언

---

## 2. val
* 읽기 전용 저장소
* 클래스에서 읽기 전용 프로퍼티(Field + Getter) 선언

> #### 📌 1. var 보다는 val을 사용해서 읽기 전용 변수를 사용하고 필요한 경우 var로 변경하는 것을 권장
> #### 2. 변수는 읽기 전까지만 초기화되면 문제없지만 정의와 동시에 초기화하는 방식을 권장
> #### 3. 변수의 스코프는 좁게 가져가는 것을 권장(추적이 쉬워서 가독성이 좋음)

---

## 3. 타입
|         타입         |     담는 정보      |  사이즈   | 범위                                                         |
|:------------------:|:--------------:|:------:|:-----------------------------------------------------------|
|      **Byte**      |    부호 있는 정수    | 1 byte | -128 ~ 127                                                 |
|     **Short**      |    부호 있는 정수    | 2 byte | -32,768 ~ 32,767                                           |
|   <U>**Int**</U>   |    부호 있는 정수    | 4 byte | -2,147,483,648 ~ <br>2,147,483,647                         |
|  <U>**Long**</U>   |    부호 있는 정수    | 8 byte | -9,223,372,036,854,775,808 ~ <br>9,223,372,036,854,775,807 |
|     **Float**      |     소수점 숫자     | 4 byte |                                                            |
| <U>**Double**</U>  |     소수점 숫자     | 8 byte |                                                            |
|      **Char**      |     문자 1개      | 2 byte |                                                            |
| <U>**String**</U>  |      문자열       |   가변   |                                                            |
| <U>**Boolean**</U> |  true / false  | 1 byte |                                                            |
|     **Array**      |       배열       |   가변   |                                                            |
|  <U>**List**</U>   |   순서가 지정된 항목   |   가변   |                                                            |
|   <U>**Set**</U>   |    key의 모음     |   가변   |                                                            |
|   <U>**Map**</U>   | key, value로 구성 |   가변   |

### Int와 Long 연산
```kotlin
val a: Int = 1
val b: Long = 2L
val c: Long = a + b
println("1 + 2L = $c")
println(c::class) // long
```
* 더 큰 사이즈인 Long으로 변환

### 소수점 계산
```kotlin
val Int_a : Int = 1
val Double_b : Double = 2.0
val Double_c : Double = Int_a / Double_b
// val Double_c: Double = Int_a.toDouble() / Double_b
println("1 / 2.0 = $Double_c") // 0.5
```
* 정수끼리 나누면 소숫점 이하 버림 처리, 소수와 함께 계산해야 소수점 계산
* 정수에 toDouble 함수를 사용해서 형변환 하는 방법도 있음

### 언더바(_)로 천단위 표시
```kotlin
val value : Long = 1_000_000L
println("Long_Value = $Long_value")
```
* 언더바(_)로 천단위 표시를 함으로써 가독성을 올릴 수 있음

### 문자 하나는 Char
```kotlin
val chr : Char = `1`
println("digitToInt() = 문자를 숫자로 변환 : ${chr.digitToInt()}") // 1
```
* 문자 하나는 작은 따옴표('')로 표기
* character 문자를 그대로 숫자로 변환할 때 digitToInt() 사용

### 문자열은 String
```kotlin
val str : String = "ABCD"
println("문자열 : $str")
```
* 문자열은 쌍따옴표("")로 표기
* 문자열을 초기화하면 변경 불가, 문자열을 바꾸면 변경하지 않고 새 String 객체를 반환

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

### 문자열과 변수 연결
```kotlin
val version : String = "1.9.10"
println("Kotlin Version $version")
```
* 문자열 템플릿($)을 사용해서 변수에 있는 값을 다른 문자열과 함께 간편하게 출력
```kotlin
val age : Int = 30
println("My age is $age") // My age is 30
```
* 숫자에도 동일하게 적용

---
## 4. 타입 추론(type inferred)
* 코틀린은 강력한 타입 추론을 제공
* 변수의 타입을 작성하지 않으면 컴파일러가 타입을 추론해서 작업을 수행한다. (컴파일 시점)
* 오른쪽에 있는 값에 맞게 타입을 설정
* Int 범위를 초과하지 않는 정수는 Int로 추론
* Long을 명시적으로 지정하려면 접미사 L을 값에 추가
* 소수로 초기화된 경우 Double로 유추
* Float을 명시적으로 지정하려면 접미사 F를 값에 추가
* 유형이 명확히 보이는 것들은 타입 추론이 유용
```kotlin
val s = "ABC"
println("s = " + s::class) // s = String

val i = 1
println("i = " + i::class) // i = int

val l = 1L
println("l = " + l::class) // l = long

val d = 1.0
println("d = " + d::class) // d = double

val f = 1.0F
println("f = " + f::class) // f = float
```
> #### 📌 유형이 명확히 보이지 않는 것들은 타입 추론이 되더라도 직접 타입을 명시하는 것을 권장

---
## 5. 상수
* 컴파일 타임 상수 : 컴파일 타임에 정해지고 런타임 중에는 변경되지 않는 값
### 기본 형식
```kotlin
const val 상수명 : 타입 = 상수값
```
```kotlin
const val PI : Double = 3.14159265359
```
### const를 활용한 상수 선언
```kotlin
const val PI: Double = 3.14159265359

fun main(){
    println(PI) // 3.14159265359
}
```

* const를 쓰면 JAVA로 디컴파일시 참조에 대한 실제 값으로 대체

```java
//val PI: Double = 3.14159265359
public final class Mainkt2 {
    private static final double PI = 3.14159265359;

    public static final double getPI(){
        return PI;
    }

    public static final void main(){
        double var0 = PI; // 3.14159265359
        System.out.println(var0);
    }
    // $FF: synthetic method
    public static void main(String[] var0){
        main();
    }
}
```
### val과 const val 비교
|               | val           | const val                                               |
|:-------------:|:--------------|:--------------------------------------------------------|
|      종류       | 읽기 전용 변수      | 컴파일 타임 상수                                               |
|    값 할당 시점    | 런타임           | 컴파일 타임                                                  |
|     선언 위치     | 다양한 범위에서 사용가능 | 최상위 속성이나 companion object에 사용 가능<br>변수나 클래스 프로퍼티에 사용 불가 |
| custom getter | 가능            | 불가능                                                     |
|      위임       | 가능            | 불가능                                                     |
|    null 타입    | 가능            | 불가능                                                     |
* 컴파일 타임 상수로 해당 값을 부르는 위치에 해당 값이 바로 들어감