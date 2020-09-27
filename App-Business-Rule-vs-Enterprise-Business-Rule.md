## Clean Architecture: Phân Loại Business Rule 

Các Lập trình viên kinh nghiệm luôn ý thức rằng "Bussiness Layer là trái tim của phần mềm", họ luôn cố gắng tách rời  trọng tâm (Business) độc lập với các thành phần thứ yếu (UI, Data Layer) rất sớm. Gọi là "thứ yếu" không có nghĩa là những thành phần kém quan trọng với end user, nhưng 10 năm code dạo của tôi mách bảo rằng, phần lớn thời gian maintaince là để điều tra, fix những vấn đề trong Business Layer. Khi một chức năng được release, break layout đã là 1 vấn đề lớn, nhưng hiển thị sai thông tin cho user lại là vấn đề lớn hơn.

Khi còn là Junior, riêng cá nhân tôi, việc nắm được yếu tố Business trong yêu cầu khách hàng là việc không đơn giản, thành thật mà nói, tôi còn không nghĩ nó quan trọng. Thay vì tập trung các Business code liên quan với nhau lại thành từng khối để dễ quản lý, review. tôi lại rải rác chúng khắp nơi → Điều tra code mệt mỏi, fix bug miệt mài.

Ngay thời điểm release bài này, tôi vẫn chưa thể phân tích Business dễ dàng như 1 BA, nhưng tôi cũng rút được 1 số kinh nghiệm để việc xác định dễ thở hơn.

#### I) Business Rule là gì

Rule là Nguyên tắc đưa ra lựa chọn, quyết định, các anh BA khi phân tích Requirement thường rất focus vào những chi tiết thế này: `"Khi A thì cần làm B"`,  `"Nếu A thì đó là B"`,… Nói theo developer thì đó là những đoạn code có `if…else…`,  `switch…case…`,... Cơ bản là như vậy, khi phân tích requirement ta cần phải highlight các chi tiết này để đưa ra phương án implement và test phù hợp.

Nhưng bạn cũng sớm nhận ra, chiếu theo định nghĩa trên thì số rule trong requirement là rất nhiều, các vấn đề về quản lý các rule trong source code vẫn chưa giải quyết triệt để. Bạn cần phương pháp phân loại chi tiết hơn để xác định rule nào nên đưa vào component nào trong các architecture pattern (như MVVM, VIPER).

#### II) Phân loại Business Rule

Trước khi biết đến Clean Architecture, tôi cũng hiểu về Business ở cấp độ như trên, mặc dù tôi thường lúng túng khi lựa chọn đặt 1 business ở Model hay ViewModel, ở Entity hay Interactor. Dù khá nhiều bài viết cũng giải thích nhưng tôi vẫn thấy mơ hồ lạc trôi ... cho đến khi Uncle Bob giải thích về nguyên tắc trong Clean Architecture. 

Tôi đặc biệt chú ý đến 2 vòng tròn trong cùng của Clean: **Enterprise Business Rule** và **Application Business Rule**.

![image-20200925164617805](App%20Business%20Rule%20vs%20Enterprise%20Business%20Rule.assets/image-20200925164617805.png)

##### 1) Enterprise Business Rule (EBR)

Là những rule liên quan đến mối quan hệ giữa các thuộc tính trong Entity hoặc giữa các Entity với nhau. EBR không chỉ được thiết kế cho Application cụ thể mà có thể cung cấp cho các Application cùng Domain. Ví dụ, Service Shopping có các Entity như Product, Store, Order, User, Cart,.... Rule về mối quan hệ giữa các Entity này với nhau gọi là EBR. 

Chẳng hạn, có lần chúng tôi implement tính toán điểm thưởng khi user mua sản phẩm trong campaign và các mobile platform (iOS, Android) đều cùng đối ứng business này như nhau. Do business rule này thuộc về Enterprise, không đặc thù riêng cho Application nào nên chúng tôi quy về nhóm EBR.

##### 2) Application Business Rule (ABR)

Là các rule liên quan đến flow xử lý data của 1 application cụ thể, đưa ra các quyết định  thời điểm và cách tạo ra Entity (lấy từ nguồn nào) và cách mà các Entity tương tác với nhau.

- Service G của Yahoo đang cung cấp 2 API riêng biệt (load video và load quảng cáo), với user thường sẽ LoadVideos và LoadAds, với user VIP chỉ LoadVideos thôi. Đây là business của 1 Application cụ thể của G, đương nhiên, G có thể có nhiều Application khác cũng sử dụng 2 API này nhưng với 1 flow xử lý nào khác. Đây gọi là ABR. 
- Requirement về filter, validation data trước khi load lên màn hình cũng gọi là ABR.

> Trong project, việc phân biệt EBR và ABR đối với 1 developer không phải lúc nào cũng suông sẻ. Theo tôi, EBR là những rule mà khi bạn đem chúng hỏi các domain expert, họ có thể hiểu và giải đáp được cho bạn. Ví dụ, bạn đang làm ứng dụng Mobile Banking, bạn có thể tìm 1 chuyên gia về banking, tham khảo về business gửi tiền tiết kiệm như kỳ hạn, tần suất nhận lãi, tích lũy hàng tháng,... họ có thể ung dung giải thích cho bạn. Nhưng nếu bạn hỏi về các rule như: "Giờ vô màn hình này, tôi phải request API nào để lấy data, tôi phải validate thông tin như thế nào trước khi gửi lên, tôi cần tracking thông tin user khi vào màn hình không?".... thì các domain expert cũng bó tay thôi 😅. Vì đây là các ABR mà . 
> Đôi khi, bạn cần phân biệt các rule để gửi Q&A cho đúng đối tượng nữa.

#### III) Việc phân loại cụ thể có ý nghĩa gì?

**"Tăng tính tái sử dụng EBR"** - Khả năng này sẽ không xảy ra nếu BackEnd, FrontEnd (Mobile App, Web App, Desktop App) dựng trên các nền khác nhau, ngôn ngữ khác nhau nên sẽ không share code với nhau được. Nhưng sẽ rất khả thi nếu BackEnd và FrontEnd được viết cùng ngôn ngữ, ví dụ như ở TBV, chúng tôi dùng Kotlin Spring Boot để viết API và cũng dùng Kotlin để viết ứng dụng Android → code EBR có thể share được với nhau. Gần đây, Kotlin cũng vừa tuyên bố có thể viết Business Module thuần kotlin và export framework dùng trong project iOS. Thôi thì ta tiếp tục hy vọng 😇

Và đây là lý do hợp lý nhất cho bài viết này: **"Để các developer thống nhất với nhau vị trí đặt các code nghiệp vụ"**, nghiệp vụ nào phải đặt trong EBR, nghiệp vụ nào đặt trong ABR. Khi cả team cùng hiểu giống nhau thì đọc code của nhau sẽ dễ dàng hơn, điều tra source, bớt những thước phim tranh luận vô nghĩa: "Tại sao chức năng này lại xử lý ở đây?"

------

Theo bạn: EBR và ABR là thành phần nào trong MVVM, VIPER 😎

