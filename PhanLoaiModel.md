# Các loại Model trong Architecture

Một lần, tôi được vợ nhờ review sản phẩm của cậu học trò, chẳng là trường cấp 3 thường có những cuộc thi sáng tạo nho nhỏ. 

Bạn ấy sử dụng C# để viết ứng dụng windows (tôi không tiện trình bày ý tưởng). Giao diện tốt, chức năng đầy đủ, cũng crash đôi lần nhưng với một cậu học sinh 15t thì thế là quá ổn. Source code ... cũng tốt hơn tôi lúc mới ra trường. Nói thẳng là kiến trúc cũng rõ ràng, cũng có View và Model hẳn hoi mặc dù cậu ấy thường nhập nhằng chức năng giữa các layer với nhau. Thế là được rồi. **"Có ý niệm phân chia thế là đã ổn rồi"** - tôi tự nhủ. Cá nhân tôi cũng không phân định rạch ròi các khái niệm mà định nghĩa đôi khi quá mơ hồ. 

Điển hình là Model - 1 thành phần trong kiến trúc xuất hiện nhiều trong các pattern MVC, MVP, MVVM,...  Tôi để ý rằng, khi vấn đáp ứng viên về kiến trúc MVC hoặc MVP, khi được hỏi **"View là gì?"** mọi người đều trả lời na ná nhau, nhưng khi hỏi **"Model là gì?"** thì câu trả lời lại rất khác ??? 

## Model trong MVC thuộc DataLayer hay BusinessLayer?

Đáp án: - Tùy vào biến thể MVC mà bạn đang hiểu. Bạn không nghe nhầm đâu, MVC từ 1979 khi được giới thiệu bởi  **Trygve Reenskaug** đến nay đã trải qua khá nhiều biến thể. Tham khảo http://stephenwalther.com/archive/2008/08/24/the-evolution-of-mvc, thật ra còn nhiều nhiều biến thể nữa). Vấn đề khó chịu là tất cả những biến thể này đều lấy tên chung là MVC. 

Tôi ngày xưa đẹp trai, hiếu học mỗi tội khù khờ, cứ lên google search "MVC Architecture" mà đọc cho kỳ hết, đến tẩu hỏa nhập ma, mỗi trang nói mỗi kiểu. Cứ nghĩ là do cách diễn đạt khác nhau thôi, chứ ngờ đâu nó khác thiệt T_T. Không biết có ai đồng cảnh ngộ vậy không! Có lẽ vì lý do đó mà về sau, người ta cố tình đặt tên khác nhau dù ý nghĩa các thành phần chỉ khác nhau đôi chút, như MVI, MVP, MVT, MVVM,... Và sau kinh nghiệm đau thương ấy, tôi không lựa chọn học Architecture Pattern, mà tôi học theo Architecture Principles (Những nguyên tắc về kiến trúc)







> "Model (MVC) là class chứa data và business rule của ứng dụng" - Định nghĩa thường thấy nhất trên Google.

Với định nghĩa trên, Model object trong MVC được sử dụng với 2 chức năng:

* Các Model object đóng vai trò như DTO (Data transfer object) chứa parse data từ API, hoặc từ Database --> Model thuộc DataLayer.

* Trong Model có thể có thêm các property/method chứa logic hiển thị theo requirement khách hàng. Ví dụ, ta đang có API trả về danh sách Product, trong mỗi Product có 3 thông tin như `giá cũ, giá mới, thời gian sale`  , trong mỗi row Product phải hiển thị đầy đủ 3 thông tin trên, lưu ý, `giá mới, % giảm giá` sẽ được hiển thị trong khung `thời gian sale` . Do đó, đối với application bạn đang work, `percentDiscount, needShowDiscountInfo() ` không phải thông tin sẵn có từ API, mà là yêu cầu thêm từ requirement, và đây là những business logic. Nếu bạn đưa thêm  `percentDiscount, needShowDiscountInfo() `  vào Product object thì vô hình chung object này đang chứa business --> Model thuộc Business Layer.



![image-20200731054455581](C:\Users\COMPUTER\Documents\blog\PhanLoaiModel.assets\image-20200731054455581.png)



## ViewModel và DataModel

Tôi thích MVVM không phải vì kiến trúc này phổ biến hay vì nó clean. Đơn giản vì kiến trúc này vì nó Dễ Hiểu, vì ngay trong tên kiến trúc có đề cập đến Model và ViewModel nên những người theo kiến trúc này sẽ có cái nhận định rạch ròi:

* ViewModel: là những object chứa nội dung, trạng thái, behavior của View. Đối với kiến trúc của ứng dụng mobile, ViewModel dù liên quan đến giao diện, nhưng lại thuộc Business Layer.
* Model: chính là DataModel, là những data object được parse từ RDBMS hoặc từ Rest API hoặc từ local,... tựu chung là những data không thuộc business chính, được provide từ các Database, Repository tham gia vào business trong ViewModel và BusinessModel.



*Không nên đem DataModel render trực tiếp lên View.* 

- Thỉnh thoảng tôi review thấy các dev parse DataModel xong thì nhét vào ArrayList trong ViewModel, chờ ngày được render lên View, rồi thuyết phục nhau rằng **"Y nhau cả, tạo thêm class ViewModel cho đối tượng ấy làm gì cho lắm code."** - Code nhiều hay ít không đánh giá chất lượng kiến trúc. Kiến trúc được sinh ra và chuẩn hóa dần dựa trên tiêu chí **"Separation Of Concern"**, DataModel (Data Layer) thì đừng đem mix với ViewModel (Domain Layer). Developer cũng đâu thích việc Database thay đổi structure lại impact đến ViewModel, còn customer cũng đâu muốn giai đoạn implement View/ViewModel lại phụ thuộc nhiều vào API còn chưa hoàn thiện. Ít code kiểu này hóa ra lại làm chậm tiến độ.

## 

