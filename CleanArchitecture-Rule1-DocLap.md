##### 🐙"Bạn đang cần tìm phương pháp code với số lượng dòng code ít nhất, thực dụng nhất ?"
Vui lòng lướt qua bài viết này. 
Giá trị 1 architecture phần mềm tốt nói chung và Clean Architecture nói riêng hầu như không để đáp ứng các yêu cầu trên.

##### 🐙"Bạn đang cần tìm phương pháp code để nhanh release sản phẩm ?"
Tôi không dám chắc Clean Architecture có thể đáp ứng yêu cầu này nốt. 
Bạn có thể tìm 1 kiến trúc đơn giản hơn, hoặc nếu yên tâm sản phẩm chỉ implement trong 1 thời gian ngắn, chỉ release 1 lần duy nhất và không bận tâm đến việc maintainent, bạn không cần apply nguyên tắc nào trong lập trình, hãy code 1 cách đơn giản nhất theo yêu cầu khách hàng, sau khi release thì hãy  cắt đứt liên lạc với ông ấy càng nhanh càng tốt.

##### 🐙"Vậy Clean có ý nghĩa gì với dự án của bạn?"

Đó là SỰ ỔN ĐỊNH. Không chậm, không nhanh. Là 1 sự cân bằng. Chí ít, đây là những cảm nhận từ cá nhân tôi với các dự án TBV đã áp dụng thành công Clean. Các module trong dự án gần như có thể phát triển độc lập mà không chờ đợi nhau, hoặc ít có sự impact ngoài kiểm soát góp phần giúp team đạt được các estimation tương đối chính xác. 

Trướt hết, Clean không phải là 1 Pattern (như MVC, MVVM) , mà là tập hợp những kinh nghiệm, nguyên tắc để xây dựng phần mềm dễ bảo trì, dễ điều tra lại những business trước và quan trọng nhất là apdapt tốt với những thay đổi, với mỗi yêu cầu mới chúng ta có thể dễ control phạm vi impact giữa các tính năng. Sẽ rất hợp lý khi xem Clean như 1 tiêu chuẩn đánh giá chất lượng source code

Clean Architecture được giới thiệu vào năm 2xxx, bởi xxx trong xxxx, đến nay đã có kha khá bài viết về hắn, sách có, blog có, những bài phân tích so sánh cũng có. Cá nhân tôi cũng đặt mua sách gốc của xxx về ngâm cứu, nhưng chắc do tầm cả tác giả cao quá nên vẫn không thẩm thấu đầy đủ, nên tôi cũng không dám mạo muội múa rìu. Mục đích bài blog này chỉ focus vào những Giá Trị Cốt Lõi (Core Values) và cũng là Tiêu Chí (Targets) của Clean Architecture (mà tôi giác ngộ được), từ những Tiêu Chí này sinh ra Nguyên Tắc (Rules), từ Nguyên tắc sinh Khuôn Mẫu (Pattern).

### "Targets → Rules → Pattern"

Nếu một ngày nào đó, bạn thấy Pattern không phù hợp với nhu cầu dự án, hãy cập nhật lại Pattern dựa trên các Rules.

Và khi  cho rằng Rules này là rào cản, hãy nhìn lại các Targets và Values mà chúng ta từng cùng nhau thừa nhận, nếu module nào đã cam kết với nhau những target/value này là không cần thiết (ví dụ như ta biết chắc tính năng này sẽ remove trong đợt release kế) thì hãy cứ giản lược hóa để đổi lấy các value khác cần thiết hơn.

Chúng ta bắt đầu với Target đầu tiên: 

# TÍNH ĐỘC LẬP - *Independent Value*

Kiến trúc Clean không ràng buộc về Pattern, nhưng ràng buộc về tiêu chuẩn, pattern phải đáp ứng được các giá trị sau:

- Độc lập về UI: Triết lý của Clean, không phân biệt bạn đang viết application mobile, winform, web site,... nếu bạn có thể giữ nguyên toàn bộ code business, thay phần xử lý render UI trên Android sang iOS dễ dàng thì bạn thành công. 
- Độc lập về DataSource: Một lần nữa, kiến trúc Clean cũng không quan tâm đến DataSource, tương tự như việc Độc lập UI, Application có thể từ access local database có thể swap đến 1 nguồn khác như APIs 1 cách đơn giản.

Kinh nghiệm của tôi là không dễ giải thích các giá trị này, tôi cũng thuộc làu các phản hồi như: 

* "Thế khi nào chúng ta cần swap Database..."

* "Việc migration UI như bạn nói sẽ không bao giờ xảy ra..."

* "Không nên lo xa quá, khi nào đến hẵng hay..."

Như lúc nào đó tôi đã từng nói, bản thân kiến trúc tốt không phải là code 1 cách thực dụng. Code tốt là gì? Không Nợ Kỹ Thuật, không phải refactor nhiều, impact lớn cho một thay đổi nhỏ (đương nhiên, refactor nhỏ là tất yếu)

Tôi không khuyến khích bạn phải lo xa, code trước khi cần (trừ khi bạn có ý gây shock cho khách hàng), cái ta chỉ cần 1 sự mềm dẻo, linh động. Khi bạn quá quan tâm vào "khi nào mới cần..." sẽ là 1 rào cản để code tốt hơn.

Tuy khó để trả lời thắc mắc "Khi nào mới cần ..." nhưng, với tôi thì những thay đổi tương tự ấy có cái sắp xảy ra, có cái đã xảy ra.

Ngay thời điểm tôi viết bài này, Kotlin đã support build 

Nếu bạn đang làm iOS thì hot trend thời điểm này là SwiftUI, đây là 1 hệ thống UI hoàn toàn mới, tuy có 1 phần core từ hệ thống UIKit, nhưng cách implement thì hoàn toàn khác, nếu cần thay thế UI từ UIKit sang SwiftUI mà không có sự độc lập UI từ trước thì gần như đập bỏ View ấy đi làm lại.

Khi tôi mới ra nghề, tôi có làm vài dự án từ điển offline, nhưng giờ đa phần là search online 