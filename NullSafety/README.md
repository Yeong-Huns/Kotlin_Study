# Null safety

<br>

## 1. ?

* NullPointerException 을 없애기 위해 kotlin 의 변수 타입은 null 할당을 허용하지 않음
* null 이 필요한 경우 타입 뒤에 ?를 붙여서 nullable 로 생성
* null 허용 타입은 이후 코드에서 null 인 경우를 고려하면서 사용해야함(safe call, elvis operator ...)

<br>

### 기본 형식
```kotlin
val 변수명 : 타입? = 초기값
```
```kotlin
val str: String? = null
```
> #### 📌 nullable 로 만들면 이후 처리할때 고려할 사항이 늘어나기 때문에 필요한 경우만 사용 권장

<br>

### smart casting

```kotlin
val str: String? = "ABCDE"
if(str != null){
    println("length = ${str.length}")    // length = 5
} else {
    println("str is null")
}
```
* null 추적이 가능해서 한번 null이 아님을 체크하면 그것이 포함된 블럭 안에서는 null 을 고려하지 않아도 됨

<br>

### Boolean 에서 null 체크

```kotlin
val bool : Boolean? = null // false
if (bool == true) {
    println("true")
} else {
    println("false of null")
}
```
* Boolean 에 null 을 허용하면 true, false, null 3가지의 경우가 생김

> #### 📌 Boolean은 null 을 허용하지 않고 사용하기를 권장

---

<br>

## 2. ?.

* safe call operator
* 명시적으로 null 을 확인할 필요없이 null 허용 값을 처리하는 간결한 방법
* ?. 앞의 값이 null 이 아니면 뒤에 명령어 실행, null 이면 null 반환

<br> 

### 기본 형식
```kotlin
변수?.프로퍼티
변수?.메소드
```
```kotlin
person?.name
str?.length
```

<br>

### Safe call operator
```kotlin
val str1: String? = "ABC"
println(str1?.length)    //3
val str2: String? = null
println(str2?.length)   //null
```

<br>

### null 이 아닌 경우 블록을 실행
```kotlin
val strNotNull: String? = "ABC"
strNotNull?.let{
    println("strNotNull")     // str
}
val strNull: String? = null
strNull?.let{
    println("strNull")      //실행되지 않음
}
```
* scope function 과 함께 사용하면 if 문을 사용하지 않고 if 문의 효과를 냄

<br>

### toString()의 null 비교
```kotlin
val str3: String? = null
println("str3.toString() : ${str3.toString()}")     //null
println("str3.toString() == null : ${str3.toString() == null}")     //false
println("str?.toString() == null : ${str3?.toString() == null}")    //true
```
* toString()의 경우 리시버가 null 인 경우 "null"(문자열)을 반환
* null 을 받으려면 ?.사용해서 앞의 값이 null 인 경우 toString() 을 실행하지 않고 바로 null 반환  

---

<br>

## 3. ?:
* Elvis operator
* null 허용 표현식을 처리할 때 기본값을 제공하는 간결한 방법
* ?: 왼쪽의 표현식이 null 이  아니면 그것을 반환하고 null 인 경우 오른쪽 표현식을 반환
* throw, return 은 kotlin 에서 표현식(expression)이여서 elvis operator 오른쪽에 사용가능

<br>

### 기본 형식
```kotlin
표현식 ?: 표현식
```
```kotlin
age ?: 0
```
<br>

### Elvis operator

```kotlin
val nullableStr: String? = "ABC"
val elvisStr = nullableStr ?: ""    //?: 옆으로 누운 엘비스 머리모양
println("elvisStr = $elvisStr")     // elvisStr = ABC

val nullableStr2: String? = null
val elvisStr2 = nullableStr2 ?: ""
println("elvisStr2 = $elvisStr2")       // elvisStr2 = 
```
<br>

### null 인 경우 디폴트값
```kotlin
val age1: Int? = null
val result1: Int = age1 ?: 0
println("age1 = $result1")    // age = 0
```

<br>

### return 으로 함수 반환

```kotlin
val age2: Int? = null
val result2: Int = age2 ?: return
println("age2 = $result2")
```

<br>

### throw exception

```kotlin
val age3: Int? = null
val result3: Int = age3 ?: throw Exception("null 발생")
println("age = $result3")
```
```kotlin
Exception in thread "main" java.lang.Exception: null 발생
	at MainKt.main(Main.kt:66)
	at MainKt.main(Main.kt)
```
---

<br>

## 4. !!
* 값이 null 이 아님을 보장하는 방법
* !!로 해줬는데 실행시 null 인 경우 NullPointerException 발생

<br>

### 기본 형식
```kotlin
변수!!
```
```kotlin
str!!
```

<br>

### null 허용하는 변수를 null 이 아님을 보장
```kotlin
val nullableStr3: String? = "ABC"
println(nullableStr3!!.length)   // 3

val nullableStr4: String? = null
println(nullableStr4!!.length)  // NullPointerException
```
```kotlin
Exception in thread "main" java.lang.NullPointerException
	at MainKt.main(Main.kt:74)
	at MainKt.main(Main.kt)
```
> #### 📌 !!은 문제가 있을시 개발자에게 알릴 수 있는 아주 간단한 방법이지만 좋은 방법은 아님. <br> 최소한으로만 사용하는 것을 권장
