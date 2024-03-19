# for (반복문)

<br>

## 1. for
* 반복문, 같은 작업을 반복할때 사용

<br>

### 기본 형식
```kotlin
for(변수 in 반복할 컬렉션) {
    반복할 작업
}
```
```kotlin
for(name in names) {
    println(name)
}
```
<br>

### 리스트에 있는 값을 하나씩 사용

```kotlin
val memberList: List<String> = listOf("kim", "park", "lee")
print("리스트에 있는 값을 하나씩 사용 : ")
for (member in memberList) {
    print(member)
}
println("\n")
```

<br>

### 리스트의 인덱스를 가져와서 사용

```kotlin
val memberList: List<String> = listOf("kim", "park", "lee")
print("리스트의 인덱스를 가져와서 사용")
for (index in memberList.indices) {
    print("index = $index, value = ${memberList[index]} ")
}
println("\n")
```

<br>

### 리스트의 인덱스와 값을 같이 가져와서 사용
```kotlin
val memberList: List<String> = listOf("kim", "park", "lee")
print("리스트의 인덱스와 값을 같이 가져와서 사용")
for((index, value) in memberList.withIndex()){
    println("index= $index, value= $value ")
}
println("\n")
```
* 인덱스와 값을 모두 사용하는 경우 가장 권장되는 방법

<br>

### ..을 사용해서 숫자 범위로 for문 실행
```kotlin
for(i in 1..10) { // 1 ~ 10
    println(i)
}
```
* kotlin 에서 범위를 나타내는 range operator(..)

<br>

### ..< 를 사용해서 마지막 숫자를 포함하지 않음
```kotlin
for(i in 1..10) { // 1 ~ 9 
    println(i)
}
```
* 1.9.0 이전 버전에서는 until 사용

<br>

### step 을 사용해서 숫자를 2씩 증가
```kotlin
for(i in 1..10 step 2){ // 1, 3, 5, 7, 9 숫자를 2씩 증가
    println(i)
}
```

<br>

### downTo 를 사용하면 역순도 가능
```kotlin
for(i in 10 downTo 1) { // 10 ~ 1 역순
    println(i)
}
```

<br>

### 문자도 지원하는 Range
```kotlin
for (c in 'a'..'e') { // a ~ e
    println(c)
}   

for(c in 'e' downTo 'a' step 2){ // e, c, a
    println(c)
}
```

<br>

## 2. Jump

<br>

### return
```kotlin
fun main() {
    loopReturn()
}
fun loopReturn() {
    for(i in 0..3) {
        for (j in 0..3){
            if (j == 2) return
            println("i = $i, j = $j")
        }
    }
}
```
* 기본적으로 가장 가까운 함수 또는 익명 함수에서 반환

<br>

### break
```kotlin
fun main() {
    loopBreaK()
}
fun loopBreak() {
    for(i in 0..3) {
        for (j in 0..3){
            if (j == 2) break
            println("i = $i, j = $j")
        }
    }
}
```
* 가장 가까운 반복문을 종료

### continue
```kotlin
fun main() {
    loopContinue()
}
fun loopContinue() {
    for(i in 0..3) {
        for (j in 0..3){
            if (j == 2) continue
            println("i = $i, j = $j")
        }
    }
}
```
* 가장 가까운 반복문을 다음단계로 진행

<br>

### label
```kotlin
fun main(){
    loopLabel()
}
fun loopLabel() {
    loop@ for(i in 0..3) {
        for (j in 0..3){
            if (j == 2) break@loop
            println("i = $i, j = $j")
        }
    }
}
```
* 라벨이 표시된 위치를 종료