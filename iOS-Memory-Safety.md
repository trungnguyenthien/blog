## 0. Tác hại Memory Leak



## 1. Phân loại vùng nhớ iOS (Heap, Stack)

Trước khi đi vào phân loại vùng nhớ, chúng ta sẽ overview về khái niệm: Bộ nhớ (Memory).

#### 1.1. Memory (RAM)

RAM - Radom Access Memory là thuật ngữ về bộ nhớ chứa data (thông tin), có thể được access từ hệ thống. . Khác với ROM, bộ nhớ chỉ đọc (Read-Only), data trong Ram có thể được Read/Write/Modify, và có thể được (hoặc bị) giải phóng bởi 2 cách:

- Giải phóng từ hệ thống. Mỗi hệ điều hành (Android, iOS, Windows) đều có cách quản lý memory riêng. 
- Mất nguồn điện. Đây cũng là khác biệt cơ bản giữa RAM và ROM. RAM là bộ nhớ ứng dụng, điện thoại hết pin, tắt nguồn thì data của ứng dụng cũng mất. ROM là bộ nhớ chứa những thông tin quan trọng, dù mất nguồn cũng vẫn còn.

Nên, trong bài này, khi nói đến vấn đề Memory Leak thì chắc chắn làm nói về RAM rồi nha (vì RAM là nơi lưu data của App).

#### 1.2. Limit Memory

Ví dụ, với iPhone 6s, RAM lý thuyết là 2GB, hệ điều hành và các service linh tinh chiếm 40% RAM thì không có nghĩa App của bạn được dùng 60% còn lại. Nhiều thực nghiệm cho thấy, thường thì nếu tổng số RAM không vượt quá 50% thì app của bạn vẫn chưa bị down, khi vượt quá 50% thì nhiều khả năng app bị sập bất cứ lúc nào.

Không có con số chính xác hoặc tài liệu chính xác của Apple về việc down app này. Tuỳ device, tuỳ phiên bản iOS. 

Việc của dev là phải tối ưu hoá việc sử dụng tài nguyên hiệu quả.

#### 1.3. Phân loại vùng nhớ

Trong section này mình chỉ đề cập đến vùng nhớ khi app đang running. Memory của C được chia gồm nhiều vùng, nhưng để hiểu và tối ưu memory iOS thì cần biết 2 vùng chính: Stack và Heap.

＊ **STACK** - Static Memory, chứa biến được create trong qúa trình thực thi function, và được release khi function return. Ví dụ, trong function sinh ra 1 biến Int 4 byte, biến này được push vào một stack memory và sẽ được pop ra khi function này thực hiện xong. Nếu biến là 1 con trỏ (pointer) thì sẽ push vào stack memory 1 biến con trỏ size 32 hoặc 64 bit, đây là địa chỉ đến vùng nhớ trên Heap chứa data của object. 

> (Ở đây mình dùng khái niệm Con Trỏ, các ngôn ngữ hiện đại như Java, Swift, C# đều che giấu tính chất con trỏ trong ngôn ngữ để người học dễ nắm bắt, nhưng… bản chất của tham chiếu chính là con trỏ là việc không chối cãi). Mình xin dùng khái niệm con trỏ để diễn giải về Strong, Weak tiện hơn.

Static Memory, được cấp phát cố định trên từng thread. Theo tài liệu Apple:

> - 1 MB (iOS main thread), 512 KB (secondary threads), Creation time = Approximately 90 microseconds
> - The minimum allowed stack size for secondary threads is 16 KB and the stack size must be a multiple of 4 KB. The space for this memory is set aside in your process space at thread creation time, but the actual pages associated with that memory are not created until they are needed.

Default, mỗi thread con sinh ra sẽ cấp 1 stack memory tối thiểu 16KB, tuy nhiên vẫn có thể setting để tạo thread với stack memory lớn hơn. Stack Memory gọi là Static memory vì sau khi thread được tạo ra thì stack memory size sẽ không tăng/giảm được. Nếu cấp phát full, sẽ dẫn đến lỗi kinh điển...

![image-20200515134244019](/Users/ntrung/Library/Application Support/typora-user-images/image-20200515134244019.png)



＊ **HEAP** - Dynamic Memory, như đã nói, địa chỉ con trỏ trong function sẽ lưu trong Stack, còn vùng nhớ thật sự của Object sẽ được lưu trong Heap. Gọi là Dynamic vì vùng nhớ này không cố định. Memory Size của 1 object trong Heap được xác định bằng tổng size của các biến trong Object. Vùng nhớ Heap của iOS là dynamic, sẽ tăng dần đến mức hệ thống "không đồng ý" cấp thêm nữa thì crash app với lỗi **OutOfMemory**.

---------

❓Đố zui nhé, đối tượng `dev` dưới đây có size trong stack là bao nhiêu?

```swift
struct TbvDeveloper {
  let name = "KimChon" 
  let age = 33 
}

func test() {
  var dev = TbvDeveloper()
  print(MemoryLayout.size(ofValue: dev))
}
```

Việc ẩn đi khái niệm con trỏ, thay bằng tham chiếu-tham trị làm chúng ta bối rối khi lý giải memory layout của String, Array, Dictionary. 

Rất dễ khi nhìn ra size của biến `age` là 8byte (size của biến kiểu Int), thế còn biến `name` . String là 1 struct, mặc dù có tính tham trị như Int, Double nhưng đó là do String được override operator `=` để copy value khi pass cho biến khác hoặc pass vào function như 1 tham số. Bản chất String vẫn là con trỏ chứa địa chỉ array các ký tự trong Heap dù String dùng y chang như Int, Double.

##### Đáp án: 16 byte

##### 😝 Giải thích:

Biến kiểu **String** luôn là 8 byte để lưu địa chỉ, dù nội dung dài hay ngắn (Vì nội dung không được lưu trong biến String)

```swift
print(MemoryLayout.size(ofValue: "Tui là KimChon")) // 8
print(MemoryLayout<String>.size) // 8
```

Biến kiểu **Int** nếu không chỉ định là Int8, Int16, Int32 thì đang được mặc định là Int64 tức 64bit ~ 8byte.

```swift
print(MemoryLayout<Int8>.size) // 1
print(MemoryLayout<Int16>.size) // 2
print(MemoryLayout<Int32>.size) // 4
print(MemoryLayout<Int64>.size) // 8
print(MemoryLayout<Int>.size) // 8
```

Như vậy, đối tượng kiểu TbvDeveloper từ lúc khởi tạo đã và luôn có size là 8 + 8 = 16 byte. 



## 2. Các kiểu tham chiếu vùng nhớ (Strong, Weak, Unowned)



## 3. Cơ chế thu dọn vùng nhớ của iOS (ARC)

Mỗi language cung cấp phương pháp quản lý (cấp phát/release) memory khác nhau. Một số "Tự Quản" như  C/C++. Một số  dùng Garbage Collector như Java, JS, C#. 

## 4. Nguyên nhân dẫn đến tình trạng Object "bất tử"



## 5. Các nhận diện  Memory Leak.



### 5.1 Memory Graph Debugger của XCode



##6. Một số kinh nghiệm tránh memory leak.

#### 6.1 Sử dụng `weak` hoặc `onwned`



----------

Tham khảo:

* <https://heartbeat.fritz.ai/memory-management-in-swift-heaps-stacks-baa755abe16a>
* <https://medium.com/elements/memory-management-in-swift-31e20f942bbc>
* <https://medium.com/flawless-app-stories/memory-leaks-in-swift-bfd5f95f3a74>
* <https://medium.com/@stremsdoerfer/understanding-memory-leaks-in-closures-48207214cba>
* <https://medium.com/flawless-app-stories/techniques-to-reduce-memory-footprint-and-oom-terminations-in-ios-a0f6bef38217>
* <https://medium.com/free-code-camp/finding-memory-leaks-react-native-app-ios-46e6eeb50c8c>
* <https://medium.com/@iostechset/3-ways-to-detect-memory-leaks-in-ios-bdf9425507d6>
* <https://medium.com/digisketches/the-heap-the-stack-notes-on-memory-in-ios-91b4f5339e9d>
* <https://medium.com/digisketches/the-heap-the-stack-notes-on-memory-in-ios-91b4f5339e9d>
* <https://medium.com/swift-programming/ios-osx-memory-management-reference-counting-7bf60c3fbb8a>
* <https://medium.com/better-programming/diagnose-memory-leaks-using-xcode-instruments-5692a6458020>





<https://stackoverflow.com/questions/6044147/ios-memory-allocation-how-much-memory-can-be-used-in-an-application>