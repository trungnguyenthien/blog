# Các loại Model trong Architecture

Một lần, tôi được vợ nhờ review sản phẩm của cậu học trò, chẳng là trường cấp 3 thường có những cuộc thi sáng tạo nho nhỏ. Phải nói là học sinh thời nay thì bao năng động: từ nghệ ca hát, dancing, ảo thuật,... đến những hội nhóm lập trình, điện tử, S.T.E.M luôn làm tôi bất ngờ. Và cậu học sinh mà vợ gửi gắm cũng khiến tôi hết phần ngạc nhiên. 

Bạn ấy sử dụng C# để viết ứng dụng windows (tôi không tiện trình bày ý tưởng). Giao diện tốt, chức năng đầy đủ, cũng crash đôi lần nhưng với một cậu học sinh 15t thì thế là quá ổn. Source code ... cũng tốt hơn tôi lúc mới ra trường. Nói thẳng là kiến trúc cũng rõ ràng, cũng có View và Model hẳn hoi mặc dù cậu ấy thường nhập nhằng chức năng giữa các layer với nhau. Thế là được rồi. **"Có ý niệm phân chia thế là đã ổn rồi"** - tôi tự nhủ. Bởi lẽ, 10 năm kinh nghiệm của tôi cũng chưa chắc phân định rạch ròi các khái niệm mà định nghĩa đôi khi quá mơ hồ. 

Điển hình là Model - 1 thành phần trong kiến trúc xuất hiện nhiều trong các pattern MVC, MVP, MVVM,...  Tôi để ý rằng, khi vấn đáp ứng viên về kiến trúc MVC hoặc MVP, khi được hỏi **"View là gì?"** mọi người đều trả lời na ná nhau, nhưng khi hỏi **"Model là gì?"** thì câu trả lời lại rất khác ??? 

Vậy khái niệm model trong mỗi pattern có tương đồng nhau, có tất cả bao nhiêu loại model.

## ViewModel và DataModel

Tôi thích MVVM không phải vì kiến trúc này phổ biến hay vì nó clean. Đơn giản vì kiến trúc này vì nó Dễ Hiểu, vì ngay trong tên kiến trúc có đề cập đến Model và ViewModel nên những người theo kiến trúc này sẽ có cái nhận định rạch ròi:

* ViewModel: là những object chứa nội dung, trạng thái, behavior của View. Đối với kiến trúc của ứng dụng mobile, ViewModel dù liên quan đến giao diện, nhưng nó thuộc Domain Layer.
* Model: chính là DataModel, là những data object được parse từ RDBMS hoặc từ Rest API hoặc từ local,... tựu chung là những data không thuộc business chính, được provide từ các Database, Repository tham gia vào business trong ViewModel và DomainModel.

Như vậy MVC, MVP không có thành phần tương tự ViewModel à? - À có, trong MVC, đôi khi một số dev định nghĩa thêm một số class với chức năng mô tả View, tôi xem đó cũng là 1 dạng ViewModel. 

Không nên đem DataModel render trực tiếp lên View. Đôi lần tôi review thấy các dev parse DataModel xong thì nhét vào ArrayList trong ViewModel, chờ ngày được render lên View. **"Y nhau cả, tạo thêm class ViewModel cho đối tượng ấy làm gì cho lắm code."** - Code nhiều hay ít không đánh giá chất lượng kiến trúc. Kiến trúc được sinh ra và chuẩn hóa dần dựa trên tiêu chí **"Separation Of Concern"**, DataModel (Data Layer) thì đừng nhập nhằng dính líu gì đến ViewModel (Domain Layer), developer cũng đâu muốn Database thay đổi structure lại impact đến ViewModel, còn customer cũng đâu muốn giai đoạn coding View, ViewModel lại phụ thuộc nhiều vào Database còn chưa hoàn thiện.

## DomainModel và Entity
