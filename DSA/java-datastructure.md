# STATIC ARRAY

<details>
  <summary>Sample</summary>

```java
 // Khai báo và khởi tạo mảng tĩnh kiểu int
        int[] intArray = new int[5];

        // Khởi tạo giá trị cho mảng
        intArray[0] = 10;
        intArray[1] = 20;
        intArray[2] = 30;
        intArray[3] = 40;
        intArray[4] = 50;

        // In các phần tử trong mảng
        for (int i = 0; i < intArray.length; i++) {
            System.out.println("Element at index " + i + ": " + intArray[i]);
        }

        // Khai báo và khởi tạo mảng tĩnh kiểu String
        String[] stringArray = {"Java", "Kotlin", "Swift", "JavaScript"};

        // In các phần tử trong mảng
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println("Element at index " + i + ": " + stringArray[i]);
        }
```

</details>

# DYNAMIC ARRAY

`ArrayList` trong Java là một Dynamic Array. Điều này có nghĩa là `ArrayList` quản lý một mảng nội bộ và tự động mở rộng khi cần thiết để chứa thêm các phần tử. `ArrayList` có thuộc tính `capacity`, mặc dù thuộc tính này không được truy cập trực tiếp mà phải sử dụng reflection.

<details>
  <summary>Sample</summary>

```java
ArrayList < Integer > list = new ArrayList < > ();

// Thêm một số phần tử vào ArrayList
for (int i = 0; i < 10; i++) {
    list.add(i);
}

// In ra kích thước của ArrayList
System.out.println("Size: " + list.size());

// Lấy capacity bằng reflection
Field field = ArrayList.class.getDeclaredField("elementData");
field.setAccessible(true);
Object[] elementData = (Object[]) field.get(list);
System.out.println("Capacity: " + elementData.length);
```

</details>

# LINKED LIST
Java hỗ trợ `LinkedList` thông qua lớp `LinkedList` trong gói `java.util`. Lớp `LinkedList` thực hiện cả hai giao diện `List` và `Deque`, cho phép nó được sử dụng như một danh sách liên kết và một hàng đợi.

<details>
  <summary>Sample</summary>

```java
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        // Tạo một LinkedList
        LinkedList<String> list = new LinkedList<>();

        // Thêm phần tử vào LinkedList
        list.add("First");
        list.add("Second");
        list.add("Third");

        // In ra các phần tử trong LinkedList
        System.out.println("LinkedList: " + list);

        // Thêm phần tử vào đầu danh sách
        list.addFirst("Zeroth");
        System.out.println("After addFirst: " + list);

        // Thêm phần tử vào cuối danh sách
        list.addLast("Fourth");
        System.out.println("After addLast: " + list);

        // Lấy phần tử đầu tiên
        String first = list.getFirst();
        System.out.println("First element: " + first);

        // Lấy phần tử cuối cùng
        String last = list.getLast();
        System.out.println("Last element: " + last);

        // Xóa phần tử đầu tiên
        String removedFirst = list.removeFirst();
        System.out.println("After removeFirst (" + removedFirst + "): " + list);

        // Xóa phần tử cuối cùng
        String removedLast = list.removeLast();
        System.out.println("After removeLast (" + removedLast + "): " + list);
    }
}

```

</details>

# STACK & QUEUE
Java hỗ trợ Stack thông qua java.util.Stack.

<details>
  <summary>Stack</summary>

```java
import java.util.Stack;

public class Main {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();

    // Thêm phần tử vào Stack
    stack.push(1);
    stack.push(2);
    stack.push(3);

    // In ra Stack
    System.out.println("Stack: " + stack);

    // Lấy phần tử ở đầu Stack mà không xoá nó
    int top = stack.peek();
    System.out.println("Top element: " + top);

    // Lấy phần tử ở đầu Stack và xoá nó
    int removed = stack.pop();
    System.out.println("Removed element: " + removed);

    // In ra Stack sau khi xoá phần tử
    System.out.println("Stack after pop: " + stack);
  }
}

```

</details>


Queue trong Java là một cấu trúc dữ liệu tuyến tính tuân theo nguyên tắc FIFO (First-In-First-Out), tức là phần tử được thêm vào đầu tiên sẽ được lấy ra đầu tiên. 

Java cung cấp giao diện `Queue` trong gói `java.util` và nhiều lớp cụ thể thực hiện giao diện này.

### Các phương thức chính của Queue

1. **Thêm phần tử**:
   - `offer(E e)`: Thêm phần tử vào cuối hàng đợi, trả về `true` nếu thành công, `false` nếu không (trong trường hợp hàng đợi có giới hạn kích thước).

2. **Lấy và xóa phần tử**:
   - `poll()`: Lấy và xóa phần tử ở đầu hàng đợi, trả về phần tử hoặc `null` nếu hàng đợi rỗng.

3. **Lấy phần tử mà không xóa**:
   - `peek()`: Lấy phần tử ở đầu hàng đợi mà không xóa nó, trả về phần tử hoặc `null` nếu hàng đợi rỗng.

4. **Kiểm tra hàng đợi rỗng**:
   - `isEmpty()`: Kiểm tra xem hàng đợi có rỗng hay không, trả về `true` nếu rỗng, `false` nếu không.


### Java cung cấp 3 class kế thừ từ Queue: 
- **LinkedList**
- **PriorityQueue**
- **ArrayDeque**

<details>
  <summary>Queue</summary>

```java
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();

    // Thêm phần tử vào Queue
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);

    // In ra Queue
    System.out.println("Queue: " + queue);

    // Lấy phần tử ở đầu Queue mà không xoá nó
    int front = queue.peek();
    System.out.println("Front element: " + front);

    // Lấy phần tử ở đầu Queue và xoá nó
    int removed = queue.poll();
    System.out.println("Removed element: " + removed);

    // In ra Queue sau khi xoá phần tử
    System.out.println("Queue after poll: " + queue);
  }
}

```

</details>

# SET

Trong Java, `Set` là một giao diện trong gói `java.util` đại diện cho một tập hợp các phần tử không trùng lặp. Java cung cấp một số lớp cụ thể thực hiện giao diện `Set`, bao gồm `HashSet`, `LinkedHashSet`, và `TreeSet`. Mỗi lớp này có các đặc điểm riêng biệt về cách lưu trữ và quản lý các phần tử.


<details>
  <summary>Sample</summary>

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
  public static void main(String[] args) {
    Set<String> set = new HashSet<>();

    // Thêm phần tử vào HashSet
    set.add("Apple");
    set.add("Banana");
    set.add("Cherry");

    // In ra HashSet
    System.out.println("HashSet: " + set);

    // Kiểm tra phần tử có trong HashSet không
    boolean containsApple = set.contains("Apple");
    System.out.println("Contains 'Apple': " + containsApple);

    // Xóa phần tử khỏi HashSet
    set.remove("Banana");
    System.out.println("HashSet after removal: " + set);

    // Kiểm tra kích thước của HashSet
    int size = set.size();
    System.out.println("Size of HashSet: " + size);

    // Xóa tất cả các phần tử
    set.clear();
    System.out.println("HashSet after clear: " + set);
  }
}


```

</details>

# DICTIONARY

Java cung cấp giao diện `Map` và các lớp cụ thể như `HashMap`, `LinkedHashMap`, và `TreeMap` để thực hiện chức năng như một `Dictionary`

<details>
  <summary>Sample</summary>

```java

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
  public static void main(String[] args) {
    Map<String, Integer> map = new HashMap<>();

    // Thêm cặp khóa-giá trị vào HashMap
    map.put("Apple", 1);
    map.put("Banana", 2);
    map.put("Cherry", 3);

    // In ra HashMap
    System.out.println("HashMap: " + map);

    // Lấy giá trị theo khóa
    int value = map.get("Banana");
    System.out.println("Value for 'Banana': " + value);

    // Kiểm tra khóa tồn tại
    boolean containsApple = map.containsKey("Apple");
    System.out.println("Contains 'Apple': " + containsApple);

    // Xóa cặp khóa-giá trị theo khóa
    map.remove("Cherry");
    System.out.println("HashMap after removal: " + map);

    // Kiểm tra kích thước của HashMap
    int size = map.size();
    System.out.println("Size of HashMap: " + size);

    // Xóa tất cả các cặp khóa-giá trị
    map.clear();
    System.out.println("HashMap after clear: " + map);
  }
}
```
</details>