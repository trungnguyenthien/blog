# Một số tính năng nổi bật của ngôn ngữ KOTLIN so với JAVA

![02](images/02.jpg)

## INTRODUCTION

Kotlin là một ngôn ngữ mới được phát triển bởi JetBrains, và đang được sử dụng rộng rãi trên cả backend và mobile. Vào ngày 7/5/2019 Google đã chính thức đưa Kotlin là một ngôn ngữ được ưu tiên khi phát triển ứng dụng Android.

Đối với các lập trình viên vốn thân thuộc với Java thì Kotlin là một ngôn ngữ khá khó chịu khi tiếp cận bởi nhiều khái niệm cũng như các syntax khác hẳn đàn anh Java.

Bài viết dưới đây sẽ giới thiệu một số tính năng nổi bật và khác biệt của Kotlin so với ngôn ngữ tiền nhiệm.

### DATA CLASS

Data Class dùng để định nghĩa kiểu đối tượng chỉ chứa field và không bao gồm các phương thức xử lý. Tương tự như POJO hay DTO trong Java, nhưng Kotlin khai báo ngắn gọn hơn rất nhiều

```kotlin
data class DataEmployee(var name: String, var age: Int)
```

Lưu ý, Data Class không chỉ là khai báo giản lược của khai báo class thường trong kotlin

```kotlin
class ClassEmployee {
    var name: String = ""
    var age: Int = 0
}
```

Từ 2 cách khai báo này, DataEmployee và ClassEmployee đều là reference type. Nhưng DataEmployee, vì là 1 dạng Value Object nên Kotlin đã `lén` generate thêm method `equals(Object o)` nên khi dùng operator `==` sẽ trả về true nếu tất cả các field y chang nhau.

### DEFAULT PARAMETER

Chúng ta có thể khai báo giá trị mặc định cho tham số khi định nghĩa hàm, class. Điều này không thể thực hiện được trong java.

```kotlin
fun haveGirlFriend(val name: String = "Computer", val age: Int = 30)
```

### OVERLOADING
Phương thức nạp chồng (overloading) khá quen thuộc với hầu hết lập trình viên Java. Ví dụ 
```java
public class Person {

    private String name;
    private int age;
    private int height; 
    
    public void addPerson(String name) {
       addPerson(name, "", "");
    }
    
    public void addPerson(String name, int age, float height) {

    }
}
```
Đối với Kotlin chúng ta có thể mặc định giá trị đầu vào cũng như thay đổi thứ tự các tham số truyền vào hàm nên việc sử dụng nạp chồng phương thức được xem như là không cần thiết nữa. Ví dụ 
```kotlin
class Person(var name: String, var age: Int, var height: Int) {
    fun addPerson(name: String = "abc", age: Int = 9, height: Int = 100)
}
```
Một số ví dụ cho việc truyền tham số đối với hàm 
```kotlin
    addPerson()
    addPerson("abc", 2, 50)
    addPerson(name="xyz")
    addPerson(age = 9)
}
```

### CONSTRUCTOR

Trong java ta có thể định nghĩa nhiều constructor dựa vào các tham số, tuy nhiên trong Kotlin chỉ có 2 constructor: **Primary constructor** và **Secondary constructor**.

```kotlin
// Primary constructor
class Person(val firstName: String, var age: Int) {
    init {
        // action want to run when create an instance
    }
 
    // Secondary constructor
    constructor(fullName: String) {
    }
    constructor(fullName: String, salary: Long) {
    }
}
```

Với một số ngôn ngữ ta thường nhầm lẫn ý nghĩa initalize() và constructor() với nhau. Kotlin có cả 2 và lý giải rõ về chức năng nhiệm vụ của init() và các constructor(). 

* Constructor() là phương thức Xây Dựng một object. Chức năng chính chỉ bao gồm đảm bảo các field đối tượng đều có value phù hợp. Trong Kotlin, đây là nhiệm vụ của Primary Constructor. Bạn không thể kèm thêm 1 xử lý ngoài lề nào vào Primary Constructor.
* Init() phương thức Khởi tạo đối tượng, thực thi ngay sau Primary Constructor. Trong init() vẫn có thể set value cho 1 số field chưa được gán giá trị trong Primary Constructor. Thường thì đây là những field được có value được suy ra từ các field trong Primary Constructor.

### LAZY LOAD

Trong Kotlin sử dụng một cơ chế khởi tạo **lazy** để giảm thời gian khởi tạo một class, các biến sẽ được khởi tạo khi nó được sử dụng lần đầu tiên. Trong java hiện chưa có chức năng này.

```kotlin
val rect: Rect by lazy {
    Rect(left, top, right, bottom)
}
```

### SINGLE-EXPRESSION FUNCTIONS

Trong Java chỉ có 1 cách define 1 function.

Với Kotlin, các hàm đơn giản chỉ gồm 1 dòng lệnh, ta có thể viết rất ngắn gọn:

```kotlin
fun sum(x: Int, y: Int) = x + y
```

### OBJECT và COMPANION OBJECT

Các bạn chắc đã quen với việc sử dụng Singleton trong Java qua từ khóa static, tuy nhiên Kotlin mindset theo 1 cách khác. Kotlin không phải là 1 ngôn ngữ hướng đối tượng tuyệt đối như Java, C#, tất cả phải được quy về Object và Class. Thật ra, khi sử dụng `static` thì đã không có tính hướng đối tượng rồi, vậy nên Kotlin đã mạnh tay bỏ luôn `static` , thay vào đó, Kotlin cho phép khai báo một global object như sau:

```kotlin
object Helper {
    private var count = 0
    fun increasedCount(): Int = count++
}

// Use:
// println(Helper.increasedCount())
```

Thì cũng tương tự static của Java thôi, có gì khác? KHÁC, tuy cách sử dụng như nhau nhưng `Helper` mới thật sự là một object, có thể kế thừa từ nhiều interface, còn static của Java thì không thể.

Trường hợp bạn cần khai báo object/method bên trong class và sử dụng như một static member trong 1 class sẵn có, cần sử dụng thêm keyword `companion` .

```kotlin
companion object {
    private const val NAME = "Name"
 
    fun makeIntent(context: Context) = Intent(context, Activity::class.java)
 
    @JvmStatic
    fun makeIntentV2(context: Context) = Intent(context, Activity::class.java)
}
```

Nếu có sử dụng hàm này trong các class java thì ta thêm **@JvmStatic** ngay trên định nghĩa hàm

### COLLECTION

Tương tự lambda được support từ Java 8, Kotlin hiển nhiên cũng cung cấp những common operation hỗ trợ xử lý array như cách viết gọn dễ hiểu hơn nhiều. Ví dụ như: **filter**, **filterNotNull** , **map**, **flatMap**, **reverse, sorted, ....**

```kotlin
var list = mutableListOf(3, 6, 6, 7, 9)
var result = list.filter { it % 3 == 0 }
print(result)
 
// result: [3, 6, 6, 9]
```

### IT vs THIS

Khi sử dụng Kotlin thì ta hay sử dụng **this** và **it**, tuy nhiên để hiểu rõ 2 keyword này thì cũng rất là khó khăn. Phần sau sẽ giải thích để các bạn có thể hiểu rõ phần nào sự khác nhau giữa chúng

#### THIS

- Khi sử dụng trong class, thì **this** đại diện cho đối tượng hiện tại của class đó
- Khi sử dụng trong các hàm mở rộng hoặc biểu thức lambda, thì nó đại diện cho một cái gọi là **receiver,** một đối tượng có thể chủ động gọi các hàm và thuộc tính của nó để sử dụng. Ví dụ: **A.length()** thì A là một receiver.

```kotlin
fun Int.foo() {
    val x = this // this là một đối tượng Int, là một receiver
}
 
fun bar() {
    val str: String = "abc"
    val result = str.apply {
        print(this) // this chính là biến str
    }
}
```

#### IT

- Chỉ sử dụng trong các hàm mở rộng hoặc biểu thức lambda , đại diện cho một **parameter/argument** truyền vào. Để bỏ qua việc đặt tên cho parameter/argument này ta sử dụng luôn keyword là **it**, tuy nhiên nếu muốn ta vẫn có thể đặt một tên khác cho nó.

```kotlin
var list = mutableListOf(3, 6, 6, 7, 9)
list.filter {it % 3 == 0} // it chính là biến list được truyền như một tham số vào bên trong filter
```

### STANDARD FUNCTION

Kotlin cung cấp cho chúng ta một số hàm tiêu chuẩn như: **run(), T.run(), with(), let(), apply(), also()**. Các hàm này sử dụng cho các mục đích khác nhau, và có áp dụng **this** hoặc **it** như đã nói ở trên. Để sử dụng đúng ta cần tham khảo sơ đồ sau đây

![Screen Shot 2020-03-27 at 10.14.05](images/01.png)

## CONCLUSION

Các tài liệu có thể tham khảo thêm về Kotlin

* https://kotlinlang.org/docs/reference/
* https://try.kotlinlang.org/
* https://github.com/Kotlin
* https://medium.com/@elye.project/mastering-kotlin-standard-functions-run-with-let-also-and-apply-9cd334b0ef84
