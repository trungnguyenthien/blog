# Swift 5.2 - New Evolution

## 1. Statically Callable

Ngôn ngữ Swift được tiến hóa theo định hướng giúp người code và người đọc code cảm giác gần gũi với ngôn ngữ tự nhiên nhất có thể. Tham khảo Swift-CodingCoding-Convention của Apple thì hoàn toàn định hướng kiểu kiểu như vậy. Code càng dễ đọc càng giúp người review code đỡ ngán, có thể review kỹ hơn, đảm bảo chất lượng hơn. 

Với những class cung cấp những xử lý, hành vi đặc trưng như Parser, Calculator, Factory, Creator,... Chúng ta thường code như thế này:

```swift
struct ResponseParser {
  func parsed(from json: JSON) -> Response {
    return ...
  }
}
// Use
let responseParser = ResponseParser()
let response = responseParser.parsed(from: json)
```

Như trên thì vẫn không đến nỗi nào, tuy đọc code thì chưa tự nhiên lắm `let tax is response parser parsed from json`, trước thì mình vẫn code như vầy nhưng cải tiến mới của Swift 5.2 thì thật sự có ý nghĩa trong trường hợp trên.

```swift
struct ResponseParser {
  func callAsFunction(from json: JSON) -> Response {
    return ...
  }
}
// Use
let responseParsed = ResponseParser()
let tax = responseParsed(from: json)
```

Review lại dòng cuối nhé `let tax is response parsed from json` (Câu này trước khi rút ngắn mệnh đề quan hệ sẽ là `let tax is response which was parsed from json` nhưng trong thực tế thì ít khi dùng full như thế).  

Giờ thì code của bạn đã gần với ngôn ngữ thường ngày rồi đấy.

##### Lưu ý:

1. `callAsFunction` tương tự như `subscript[]` , nhưng `[]` đặc trưng cho việc access đến những element sẵn có trong object (thường là collection, list), vì chỉ là access nên tốc độ xử lý của `subscript` sẽ gần như tức thời.   Không nên dùng `subscript` thay cho `callAsFunction` cho những xử lý phức tạp.
2. `callAsFunction` hay còn gọi là statically Callable, trước Swift 5.0 đã giới thiện 1 khái niệm dynamically Callable **@dynamicCallable** Tham khảo ở [đây](https://www.hackingwithswift.com/articles/134/how-to-use-dynamiccallable-in-swift) nha.

## 2. KeyPath Expression

Tương tự `callAsFunction`cải tiến syntax này giúp  code dễ đọc hơn. Ví dụ, trước đây chúng ta muốn map() ra danh sách name của array user, ta thường dùng như sau:

```swift
// Before Swift 5.2
let usernames = users.map { $0.name }
```

Thật ra là cách viết gọn closure  `(User) -> String` , thế thì cũng clean lắm rồi. Swift 5.2 cho phép chúng ta tạo expression KeyPath thay cho closure cho method map, filter,... , trong trường hợp closure như trên có thể được thay tương đương  `\User.name`  

```swift
// Swift 5.2
let usernames = users.map(\.name)
// Or
let asName = (User) -> String = \.name
let usernames = users.map(asName)
```

Nếu tách ra expression `asName` như trên thì code sẽ dễ đọc hơn đôi chút.

## 3. Subscripts default arguments

```swift
struct PoliceForce {
    var officers: [String]

    subscript(index: Int, default default: String = "Unknown") -> String {
        if index >= 0 && index < officers.count {
            return officers[index]
        } else {
            return `default`
        }
    }
}

let force = PoliceForce(officers: ["Amy", "Jake", "Rosa", "Terry"])
print(force[0]) // -> "Amy"
print(force[5]) // -> "Unknown"
```

