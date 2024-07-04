Swift cung cấp ba loại tập hợp chính, được biết đến như mảng (arrays), tập hợp (sets), và từ điển (dictionaries), để lưu trữ các tập hợp giá trị. 

- **Array** là tập hợp các giá trị có thứ tự. 

- **Set** là các tập hợp không có thứ tự của các giá trị duy nhất. 

- **Dictionary** là các tập hợp không có thứ tự của các cặp khóa-giá trị.

<img src="https://p.ipic.vip/elwkgp.png" alt="img" style="zoom:50%;" />

# DYNAMIC ARRAY

```swift
# Các cách khai báo Array
let arrayOfInts = [1, 2, 3, 4, 5]
let arrayOfInts = [Int](repeating: 0, count: 5)  // [0, 0, 0, 0, 0]
let arrayOfInts: [Int] = [] // Empty
let arrayOfStrings: [String] = ["Apple", "Banana", "Cherry"]
let arrayOfStrings = [String]()

# Truy cập giá trị
let firstElement = arrayOfInts[0]  // 1
let secondElement = arrayOfStrings[1]  // "Banana"
```



### Array được cài đặt như một `Dynamic Array`.

Mỗi Array dự trữ một lượng bộ nhớ cụ thể (capacity) để lưu trữ nội dung của nó. Khi ta thêm các phần tử vào một mảng và bắt đầu vượt quá dung lượng dự trữ của nó, mảng sẽ phân bổ một vùng bộ nhớ lớn hơn và sao chép các phần tử của nó vào nơi lưu trữ mới. 

Nơi lưu trữ mới có kích thước là bội số của kích thước nơi lưu trữ cũ. Chiến lược tăng trưởng theo cấp số nhân này có nghĩa là việc thêm một phần tử diễn ra trong thời gian hằng, trung bình hóa hiệu suất của nhiều thao tác thêm phần tử. Các thao tác thêm phần tử kích hoạt tái phân bổ có một chi phí hiệu suất, nhưng chúng xảy ra ít dần khi mảng trở nên lớn hơn.

### Array cung cấp các thao tác như một `List`

```swift
var arrayOfInts = [1, 2, 3]
arrayOfInts.append(4)  // [1, 2, 3, 4]
arrayOfInts.append(contentsOf: [5, 6])  // [1, 2, 3, 4, 5, 6]
arrayOfInts.insert(0, at: 0)  // [0, 1, 2, 3, 4, 5, 6]
arrayOfInts.remove(at: 0)  // [1, 2, 3, 4, 5, 6]
```

### Array có cung cấp thao tác tương đương như `Stack` 

```swift
extension Array {
    // Phương thức thêm phần tử vào cuối stack (push)
    mutating func push(_ element: Element) {
        self.append(element)
    }
    
    // Phương thức xoá và trả về phần tử cuối cùng của stack (pop)
    mutating func pop() -> Element? {
        return self.popLast()
    }
    
    // Phương thức trả về phần tử cuối cùng mà không xoá nó (peek)
    func peek() -> Element? {
        return self.last
    }
    
    // Kiểm tra stack có rỗng hay không
    var isEmptyStack: Bool {
        return self.isEmpty
    }
    
    // Đếm số phần tử trong stack
    var stackSize: Int {
        return self.count
    }
}
```

### Array có cung cấp thao tác tương đương như `Queue` 

```swift
extension Array {
    // Phương thức thêm phần tử vào cuối hàng đợi (enqueue)
    mutating func enqueue(_ element: Element) {
        self.append(element)
    }
    
    // Phương thức xoá và trả về phần tử đầu tiên của hàng đợi (dequeue)
    mutating func dequeue() -> Element? {
        guard !self.isEmpty else { return nil }
        return self.removeFirst()
    }
    
    // Phương thức trả về phần tử đầu tiên mà không xoá nó (peek)
    func peek() -> Element? {
        return self.first
    }
    
    // Kiểm tra hàng đợi có rỗng hay không
    var isEmptyQueue: Bool {
        return self.isEmpty
    }
    
    // Đếm số phần tử trong hàng đợi
    var queueSize: Int {
        return self.count
    }
}
```

# SET
Swift hỗ trợ cấu trúc dữ liệu Set thông qua class Set như sau:
```swift
// Khai báo và khởi tạo Set
var setA: Set<Int> = [1, 2, 3, 4, 5]
var setB: Set<Int> = [4, 5, 6, 7, 8]

// Thêm phần tử vào Set
setA.insert(6)
print("Set A after insert: \(setA)")  // [1, 2, 3, 4, 5, 6]

// Xoá phần tử khỏi Set
if let removedElement = setA.remove(3) {
    print("Removed element: \(removedElement)")  // 3
}
print("Set A after remove: \(setA)")  // [1, 2, 4, 5, 6]

// Kiểm tra phần tử có tồn tại trong Set không
let containsElement = setA.contains(4)
print("Set A contains 4: \(containsElement)")  // true

// Đếm số phần tử trong Set
let setSize = setA.count
print("Set A size: \(setSize)")  // 5

// Kiểm tra Set có rỗng không
let isEmptySet = setA.isEmpty
print("Set A is empty: \(isEmptySet)")  // false

// Hợp (Union) của hai Set
let unionSet = setA.union(setB)
print("Union of Set A and Set B: \(unionSet)")  // [1, 2, 4, 5, 6, 7, 8]

// Giao (Intersection) của hai Set
let intersectionSet = setA.intersection(setB)
print("Intersection of Set A and Set B: \(intersectionSet)")  // [4, 5, 6]

// Phần tử có trong Set A nhưng không có trong Set B (Subtracting)
let subtractingSet = setA.subtracting(setB)
print("Subtracting Set B from Set A: \(subtractingSet)")  // [1, 2]

// Phần tử có trong Set A hoặc Set B, nhưng không có trong cả hai (Symmetric Difference)
let symmetricDifferenceSet = setA.symmetricDifference(setB)
print("Symmetric Difference of Set A and Set B: \(symmetricDifferenceSet)")  // [1, 2, 7, 8]

// Duyệt qua các phần tử trong Set
print("Elements in Set A:")
for element in setA {
    print(element)
}

// Làm rỗng Set
setA.removeAll()
print("Set A after removing all elements: \(setA)")  // []


```

# DICTIONARY
Swift hỗ trợ cấu trúc dữ liệu Set thông qua class Dictionary như sau:
```swift
// Khai báo và khởi tạo Dictionary
// Cách 1: Khai báo rỗng
var emptyDict1: [String: Int] = [:]
var emptyDict2 = [String: Int]()

// Cách 2: Khởi tạo với các giá trị cụ thể
var dict: [String: Int] = ["One": 1, "Two": 2, "Three": 3]

// Thêm (put) một cặp key-value vào Dictionary
dict["Four"] = 4
print("Dictionary after adding key 'Four': \(dict)")  // ["One": 1, "Two": 2, "Three": 3, "Four": 4]

// Cập nhật (update) giá trị cho một key đã tồn tại
if let oldValue = dict.updateValue(5, forKey: "Four") {
    print("Old value for key 'Four': \(oldValue)")  // 4
}
print("Dictionary after updating key 'Four': \(dict)")  // ["One": 1, "Two": 2, "Three": 3, "Four": 5]

// Xoá (remove) một cặp key-value khỏi Dictionary
dict["Two"] = nil
print("Dictionary after removing key 'Two': \(dict)")  // ["One": 1, "Three": 3, "Four": 5]

if let removedValue = dict.removeValue(forKey: "Three") {
    print("Removed value for key 'Three': \(removedValue)")  // 3
}
print("Dictionary after removing key 'Three': \(dict)")  // ["One": 1, "Four": 5]

// Truy cập giá trị bằng key
if let value = dict["One"] {
    print("Value for key 'One': \(value)")  // 1
}

// Kiểm tra sự tồn tại của key
let containsKey = dict.keys.contains("Four")
print("Dictionary contains key 'Four': \(containsKey)")  // true

// Đếm số phần tử trong Dictionary
let dictSize = dict.count
print("Dictionary size: \(dictSize)")  // 2

// Kiểm tra Dictionary có rỗng không
let isEmptyDict = dict.isEmpty
print("Dictionary is empty: \(isEmptyDict)")  // false

// Duyệt qua các phần tử trong Dictionary
print("Elements in Dictionary:")
for (key, value) in dict {
    print("\(key): \(value)")
}

// Truy cập tất cả các keys và values
let keys = Array(dict.keys)
let values = Array(dict.values)
print("Keys: \(keys)")  // ["One", "Four"]
print("Values: \(values)")  // [1, 5]

// Làm rỗng Dictionary
dict.removeAll()
print("Dictionary after removing all elements: \(dict)")  // [:]

```

# STATIC ARRAY
Swift không hỗ trợ tạo Static Array

# LINKED LIST
Swift mặc định không support Linked List. Tuy nhiên Apple cung cấp package cấu trúc dữ liệu collection mở rộng, trong số đó có kiểu LinkedList

- SPM:  "https://github.com/apple/swift-collections.git"

```swift
import Collections

// Sử dụng LinkedList từ Swift Collections
var linkedList = LinkedList<Int>()
linkedList.append(1)
linkedList.append(2)
linkedList.append(3)

print("Linked List Elements:")
for element in linkedList {
    print(element)
}

linkedList.removeFirst()
print("Linked List after removing first element:")
for element in linkedList {
    print(element)
}

```
