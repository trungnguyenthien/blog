

## Static Array

**Static Array** là một cấu trúc dữ liệu có kích thước cố định, được xác định khi khai báo và không thể thay đổi trong quá trình thực thi (sau khi khởi tạo)

Các đặc điểm Static Array:

- Bộ nhớ được cấp phát cố định khi khai báo, kích thước của array không thể thay đổi sau khi tạo.
- Ưu điểm: Truy xuất nhanh
- Khuyết điểm: Không thể mở rộng.

NOTE: 

- Trong các ngôn ngữ lập trình mới (Javascript, Swift, Kotlin, PHP) không hỗ trợ kiểu Static Array.
- Ngôn ngữ Java vẫn hỗ trợ kiểu Static Array.

## Dynamic Array

**Dynamic array** (mảng động) là một cấu trúc dữ liệu mảng có khả năng tự động điều chỉnh kích thước để đáp ứng nhu cầu lưu trữ.

![Dynamic Array in Python](https://p.ipic.vip/sf5ge6.png)

- Đặc điểm:

  - Là wrapper class của Static Array

  - Khi array đầy, nó sẽ cấp phát một array mới lớn hơn 1.5~2x lần kích thước trước đó và sao chép các phần tử vào mảng mới.


- Ưu điểm: 
  - Truy xuất nhanh như Static Array.
  - Có thể mở rộng kích thước Array.
- Khuyểt điểm:  
  - Tốn chi phí copy array mỗi khi resize.
  - Chi phí chèn/xoá ở vị trí càng gần đầu array sẽ càng cao tương ứng chi phí chuyển dịch phần tử.
  - Mỗi lần resize thì `capacity` tăng lên đáng kể (Chiếm dụng bộ nhớ không cần thiết)

## Linked List

Linked List là một cấu trúc dữ liệu tuyến tính, trong đó mỗi phần tử được lưu trữ trong một nút (node). Mỗi nút chứa hai thành phần: 

- Data 
- Tham chiếu đến nút trước (previous) hoặc sau (next) (Biến tham chiếu thường chiếm 8 byte)

<img src="https://p.ipic.vip/t0d914.png" alt="Understanding the basics of Linked List - GeeksforGeeks" style="zoom:50%;" />

Đặc điểm:

- Kích thước List động theo số node nó đang quản lý.

Ưu điểm:

- Chi phí thêm, xoá node nhanh hơn Dynamic Array (do Linked List chỉ thực hiện việc huỷ/thêm liên kết (link) giữa các Node)
- Có thể mở rộng kích thước List.

Khuyết điểm:

- Truy xuất chậm hơn Dynamic Array.

Linked List và Dynamic Array, cấu trúc dữ liệu nào sử dụng bộ nhớ ít hơn? 

-  Tuỳ trường hợp: 
  - Linked List yêu cầu mỗi node thêm 8byte cho việc link với node tiếp theo. 
  - Dynamic Array mỗi lần resize sẽ tăng từ 1.5-2x lần so với size cũ.

## Stack & Queue

Stack là một khái niệm về một cấu trúc dữ liệu tuyến tính tuân theo nguyên tắc **LIFO** (Last In, First Out), tức là phần tử được thêm vào cuối cùng sẽ được lấy ra đầu tiên.

Queue là một khái niệm về một cấu trúc dữ liệu tuyến tính tuân theo nguyên tắc **FIFO** (First In, First Out), tức là phần tử được thêm vào đầu tiên sẽ được lấy ra đầu tiên. 

![Stack and Queue](https://p.ipic.vip/ekfzgx.png)

 Queue và Stack là các khái niệm trừu tượng (abstract data types) chỉ định nghĩa hành vi và các thao tác, không quy định cách triển khai cụ thể (**Dynamic Array** hay **Linked List**)

Trong định nghĩa về Stack có 2 method chính: 

- push (Add vào cuối)
- pop (Lấy phần tử cuối)

Trong định nghĩa về Queue có 2 method chính: 

- enqueue (Add vào cuối)
- dequeue (Lấy phần tử đầu)

## Set (Tập hợp)

**Set** (Tập hợp) là một khái niệm về một cấu trúc dữ liệu lưu trữ tập hợp các phần tử **không trùng lặp** và **không có thứ tự**.

Đặc điểm:

- **Tính duy nhất:** Mỗi thành phần chỉ xuất hiện một lần trong SET.
- **Tính vô thứ tự:** Các thành phần trong SET không được sắp xếp theo thứ tự cụ thể nào. 
  Hai Set sau đây được xem như bằng nhau: { 1, 2, 3 } và { 3, 1, 2 }

 Set là khái niệm chỉ định nghĩa hành vi và các thao tác, không quy định cách triển khai cụ thể (**Dynamic Array** hay **Linked List**)

Trong định nghĩa về Sét có 3 method chính: 

- add (thêm element vào tập dữ liệu)
- remove (loại element khỏi tập dữ liệu)
- contains (kiểm tra tồn tại element trong tập)

## Dictionary

![Python Dictionaries. Data structures are basically… | by The Fellow |  Python Pandemonium | Medium](https://p.ipic.vip/lk18y1.png)

**Dictionary** là một khái niệm về một cấu trúc dữ liệu dùng để lưu trữ giá trị dạng `key-value`, cấu trúc này có các đặc điểm sau:

- Mỗi key là duy nhất.
- Thứ tự các phần tử  không đảm bảo là thứ tự khi được khai báo trong Dictionary  (trừ khi triển khai cụ thể có sắp xếp).

Lưu ý: Vấn đề về thứ tự các phần tử trong Dictionary của mỗi ngôn ngữ lập trình sẽ khác nhau và không nhất định giống với thứ tự các key-value khi được khai báo. Sự khác nhau này phụ thuộc vào việc ưu tiên thao tác search key hay thao tác add key-value sẽ có thuật toán băm key thành index tương ứng.



