# MVVM và câu chuyện về những Model

### 🍋 Model là gì? 

Theo từ điển Oxford, định nghĩa chủ yếu về model là:

> "Đại diện, 1 khuôn mẫu hoặc 1 bản copy cho một đối tượng thật". 

Nếu đem định nghĩa này để giải thích cho thành phần Model trong các mẫu kiến trúc MV* thì vừa phù hợp cũng vừa ... huề vốn. Bởi từ hồi nhập môn OOP, ai cũng hiểu mỗi Class đã là đại diện cho 1 kiểu Đối Tượng nào đó rồi. Thế thì vấn đề ở đây là Model đang đại diện cho Đối Tượng nào? 

### 🍋 Model trong MVC và Model trong MVP có thực sự giống nhau? 



Trong các mẫu kiến trúc MV (MVC, MVP, MVVM, MVI,...) Model ngầm hiểu là DataModel là mô phỏng các đối tượng trong Database, API,... ví dụ, như BookModel là một mô phỏng của thực thể Book trả về từ API hoặc mapping từ table trong MySQL. Tùy vào dự án, có khi DataModel trực tiếp request và parse data, nhưng theo tôi, DataModel không cần ôm đồm công việc của 1 DAO mà chỉ cần chứa data như các POJO và business rule của riêng nó là đủ. Trách nhiệm requesting và mapping nên đặt vào các class Service, Repository hay DataProvider nào khác là ổn.

Duy chỉ mỗi ViewModel





https://www.quora.com/What-are-the-differences-between-MVC-MVP-and-MVVM-in-very-basic-terms-with-examples

https://www.quora.com/How-do-the-MVP-MVC-and-MVVM-patterns-relate

https://www.quora.com/search?q=MVC%20vs%20MVP