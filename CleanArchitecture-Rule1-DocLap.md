##### 🐙"Bạn đang cần tìm phương pháp code với số lượng dòng code ít nhất, thực dụng nhất ?"
Vui lòng lướt qua bài viết này. 
Giá trị 1 architecture phần mềm tốt nói chung và Clean Architecture nói riêng hầu như không để đáp ứng các yêu cầu trên.

##### 🐙"Bạn đang cần tìm phương pháp code để nhanh release sản phẩm ?"
Tôi không dám chắc Clean Architecture có thể đáp ứng yêu cầu này nốt. 
Bạn có thể tìm 1 kiến trúc đơn giản hơn, hoặc nếu yên tâm sản phẩm chỉ implement trong 1 thời gian ngắn, chỉ release 1 lần duy nhất và không bận tâm đến việc maintainent, bạn không cần apply nguyên tắc nào trong lập trình, hãy code 1 cách đơn giản nhất theo yêu cầu khách hàng, sau khi release thì hãy  cắt đứt liên lạc với ông ấy càng nhanh càng tốt.

##### 🐙"Vậy Clean có ý nghĩa gì với dự án của bạn?"

Đó là SỰ ỔN ĐỊNH. Không chậm, không nhanh. Là 1 sự cân bằng ổn định. Chí ít, đây là những cảm nhận từ cá nhân tôi với các dự án TBV đã áp dụng thành công Clean. Các module trong dự án gần như có thể phát triển độc lập mà không chờ đợi nhau, hoặc ít có sự impact ngoài kiểm soát góp phần giúp team đạt được các estimation tương đối chính xác. 

Trướt hết, Clean không phải là 1 Pattern (như MVC, MVVM) , mà là tập hợp những kinh nghiệm, nguyên tắc để xây dựng phần mềm dễ bảo trì, dễ điều tra lại những business trước và quan trọng nhất là apdapt tốt với những thay đổi, với mỗi yêu cầu mới chúng ta có thể dễ control phạm vi impact giữa các tính năng. Sẽ rất hợp lý khi xem Clean như 1 tiêu chuẩn đánh giá chất lượng source code

Clean Architecture được giới thiệu vào năm 2xxx, bởi xxx trong xxxx, đến nay đã có kha khá bài viết về hắn, sách có, blog có, những bài phân tích so sánh cũng có. Cá nhân tôi cũng đặt mua sách gốc của xxx về ngâm cứu, nhưng chắc do tầm cả tác giả cao quá nên vẫn không thẩm thấu đầy đủ, nên tôi cũng không dám mạo muội múa rìu. Mục đích bài blog này chỉ focus vào những Giá Trị Cốt Lõi (Core Values) và cũng là Tiêu Chí (Targets) của Clean Architecture (mà tôi giác ngộ được), từ những Tiêu Chí này sinh ra Nguyên Tắc (Rules), từ Nguyên tắc sinh Khuôn Mẫu (Pattern).

### "Targets → Rules → Pattern"

Nếu một ngày nào đó, bạn thấy Pattern không phù hợp với nhu cầu dự án, hãy cập nhật lại Pattern dựa trên các Rules.

Và khi  cho rằng Rules này là rào cản, hãy nhìn lại các Targets và Values mà chúng ta từng cùng nhau thừa nhận, nếu module nào đã cam kết với nhau những target/value này là không cần thiết (ví dụ như ta biết chắc tính năng này sẽ remove trong đợt release kế) thì hãy cứ giản lược hóa để đổi lấy các value khác cần thiết hơn.

Chúng ta bắt đầu với Target đầu tiên: 

# TÍNH ĐỘC LẬP

