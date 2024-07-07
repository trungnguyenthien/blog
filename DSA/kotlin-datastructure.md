# STATIC ARRAY

Kiểu Array trong Kotlin là Static Array
> https://kotlinlang.org/docs/arrays.html
>
> An array is a data structure that holds a fixed number of values of the same type or its subtypes. The most common type of array in Kotlin is the object-type array, represented by the Array class.
> 
> Use arrays in Kotlin when you have specialized low-level requirements that you need to meet. For example, if you have performance requirements beyond what is needed for regular applications, or you need to build custom data structures. 

<details>
  <summary>Sample</summary>

```kotlin

var riversArray = arrayOf("Nile", "Amazon", "Yangtze")

// Using the += assignment operation creates a new riversArray,
// copies over the original elements and adds "Mississippi"
riversArray += "Mississippi"
println(riversArray.joinToString())
// Nile, Amazon, Yangtze, Mississippi

```
</details>

Kotlin hỗ trợ khai báo array cho các kiểu dữ liệu nguyên thủy (Int, Float) thông qua các class: IntArray, FloatArray,...


<details>
  <summary>Sample</summary>

```kotlin
fun main() {
   // Khai báo và khởi tạo mảng tĩnh kiểu Int
    var intArray = IntArray(5) { it * 2 }  // [0, 2, 4, 6, 8]
	intArray += 10
    // In các phần tử trong mảng
    for (i in intArray.indices) {
        println("Element at index $i: ${intArray[i]}")
    }
}

```

</details>


NOTE: Toán tử += không giúp tăng kích thước Array mà là tạo một static array mới với phần tử mới được thêm vào.

Khác với Dynamic Array, mỗi khi resize, sẽ có `một số slot trống` gọi là Dung Lượng, nhằm giảm chi phí resize + copy nhiều lần nếu thao tác thêm mới được dùng nhiều.

---

# DYNAMIC ARRAY

`ArrayList` trong Kotlin, giống như trong Java, là một cấu trúc dữ liệu Dynamic Array. Điều này có nghĩa là `ArrayList` quản lý một mảng nội bộ và tự động mở rộng khi cần thiết để chứa thêm các phần tử. `ArrayList` có thuộc tính `capacity`, mặc dù thuộc tính này không được truy cập trực tiếp trong Kotlin mà phải sử dụng reflection.

Reference: https://www.geeksforgeeks.org/internal-working-of-arraylist-in-java/

<details>
  <summary>Sample</summary>

```kotlin
fun main() {
    // Khai báo và khởi tạo ArrayList với dung lượng ban đầu là 10
    val arrayList: ArrayList<Int> = ArrayList(10)

    // Thêm phần tử vào ArrayList
    arrayList.add(1)
    arrayList.add(2)
    arrayList.add(3)

    // In các phần tử trong ArrayList
    println("ArrayList elements:")
    for (i in arrayList) {
        println(i)
    }

    // Kiểm tra kích thước hiện tại của ArrayList
    println("Size: ${arrayList.size}")

    // Tăng dung lượng của ArrayList
    arrayList.ensureCapacity(20)

    // Kiểm tra dung lượng hiện tại của ArrayList sử dụng reflection
    println("Capacity: ${arrayList.capacity()}")
}

// Extension function để lấy dung lượng của ArrayList sử dụng reflection
fun <T> ArrayList<T>.capacity(): Int {
    val field = ArrayList::class.java.getDeclaredField("elementData")
    field.isAccessible = true
    val internalArray = field.get(this) as Array<*>
    return internalArray.size
}
```

</details>

----

# LINKED LIST

Kotlin không có lớp `LinkedList` tích hợp sẵn như Java, nhưng bạn có thể sử dụng lớp `LinkedList` từ thư viện chuẩn Java hoặc tự triển khai Linked List.

<details>
  <summary>Sample</summary>

```kotlin

import java.util.LinkedList

fun main() {
    // Khai báo và khởi tạo LinkedList
    val linkedList = LinkedList<Int>()

    // Thêm phần tử vào LinkedList
    linkedList.add(1)
    linkedList.add(2)
    linkedList.add(3)

    // In các phần tử trong LinkedList
    println("LinkedList elements:")
    for (i in linkedList) {
        println(i)
    }

    // Xóa phần tử khỏi LinkedList
    linkedList.remove(2)

    // In các phần tử sau khi xóa
    println("LinkedList elements after removal:")
    for (i in linkedList) {
        println(i)
    }
}
```

</details>

---

# STACK & QUEUE

Kotlin không cung cấp trực tiếp class Stack và Queue nhưng ta có thể customize từ ArrayDeque, ArrayList hoặc LinkedList.

Quan điểm cá nhân của mình việc sử dụng LinkedList làm base class sẽ phù hợp hơn Array. 

Vì Stack, Queue không chú trọng việc truy xuất, duyệt danh sách. Thay vào đó, việc add/remove và kiểm tra phần tử đầu cuối danh sách thường xuyên được sử dụng ==> Phù hợp với kiểu LinkedList hơn. 

<details>
  <summary>Stack</summary>

```kotlin
import java.util.LinkedList

class Stack<T> : LinkedList<T>() {

    // Thêm phần tử vào stack (push)
    fun push(element: T) {
        addFirst(element)
    }

    // Loại bỏ phần tử đầu stack (pop)
    fun pop(): T? {
        return if (isEmpty()) null else removeFirst()
    }

    // Truy cập phần tử đầu stack (peek)
    fun peek(): T? {
        return if (isEmpty()) null else first
    }

    // Kiểm tra stack có rỗng không
    fun isEmpty(): Boolean {
        return super.isEmpty()
    }
}

fun main() {
    val stack = Stack<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    println("Top element: ${stack.peek()}")  // Output: Top element: 3
    println("Popped element: ${stack.pop()}")  // Output: Popped element: 3
    println("Is stack empty? ${stack.isEmpty()}")  // Output: Is stack empty? false
    println("Stack elements: $stack")  // Output: Stack elements: [2, 1]
}

```

</details>

<details>
  <summary>Queue</summary>

```kotlin
import java.util.LinkedList

class Queue<T> : LinkedList<T>() {

    // Thêm phần tử vào queue (enqueue)
    fun enqueue(element: T) {
        addLast(element)
    }

    // Loại bỏ phần tử đầu queue (dequeue)
    fun dequeue(): T? {
        return if (isEmpty()) null else removeFirst()
    }

    // Truy cập phần tử đầu queue (peek)
    fun peek(): T? {
        return if (isEmpty()) null else first
    }

    // Kiểm tra queue có rỗng không
    fun isEmpty(): Boolean {
        return super.isEmpty()
    }
}

fun main() {
    val queue = Queue<Int>()
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    println("Front element: ${queue.peek()}")  // Output: Front element: 1
    println("Dequeued element: ${queue.dequeue()}")  // Output: Dequeued element: 1
    println("Is queue empty? ${queue.isEmpty()}")  // Output: Is queue empty? false
    println("Queue elements: $queue")  // Output: Queue elements: [2, 3]
}

```

</details>

---

# SET

Kotlin hỗ trợ kiểu dữ liệu `Set` và cung cấp một số cách để làm việc với các tập hợp (sets). Một `Set` trong Kotlin là một tập hợp các phần tử duy nhất, không cho phép các phần tử trùng lặp. Dưới đây là cách khai báo và sử dụng `Set` trong Kotlin.

<details>
  <summary>Sample</summary>

```kotlin
fun main() {
    val setA = setOf(1, 2, 3)
    val setB = setOf(3, 4, 5)

    // Union of two sets
    val unionSet = setA.union(setB)
    println("Union: $unionSet")  // [1, 2, 3, 4, 5]

    // Intersection of two sets
    val intersectionSet = setA.intersect(setB)
    println("Intersection: $intersectionSet")  // [3]

    // Difference of two sets
    val differenceSet = setA.subtract(setB)
    println("Difference: $differenceSet")  // [1, 2]
}

```

</details>

---

# DICTIONARY

Trong Kotlin, kiểu dữ liệu tương tự như `Dictionary` được gọi là `Map`. Kotlin cung cấp cả `Immutable Map` và `Mutable Map` để lưu trữ các cặp khóa-giá trị (key-value pairs).

<details>
  <summary>Sample</summary>

```kotlin
fun main() {
    // Khai báo và khởi tạo một Mutable Map
    val mutableMap: MutableMap<String, Int> = mutableMapOf("one" to 1, "two" to 2, "three" to 3)

    // In các phần tử trong Map
    println("Mutable Map elements:")
    for ((key, value) in mutableMap) {
        println("$key: $value")
    }

    // Truy cập giá trị bằng khóa
    println("Value for key 'one': ${mutableMap["one"]}")  // Output: Value for key 'one': 1

    // Thêm phần tử vào Map
    mutableMap["four"] = 4
    println("After adding 'four': $mutableMap")  // Output: After adding 'four': {one=1, two=2, three=3, four=4}

    // Cập nhật giá trị của một khóa
    mutableMap["one"] = 10
    println("After updating 'one': $mutableMap")  // Output: After updating 'one': {one=10, two=2, three=3, four=4}

    // Xóa phần tử khỏi Map
    mutableMap.remove("two")
    println("After removing 'two': $mutableMap")  // Output: After removing '

```

</details>