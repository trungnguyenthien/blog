# Các loại Model trong Architecture

Một lần, tôi được vợ nhờ review sản phẩm của cậu học trò, chẳng là trường cấp 3 thường có những cuộc thi sáng tạo nho nhỏ. 

Bạn ấy sử dụng C# để viết ứng dụng Windows (tôi không tiện trình bày ý tưởng). Giao diện tốt, chức năng đầy đủ, cũng crash đôi lần nhưng với một cậu học sinh 15t thì thế là quá ổn. Source code ... cũng tốt hơn tôi lúc mới ra trường. Kiến trúc cũng rõ ràng, cũng có View và Model hẳn hoi mặc dù cậu ấy thường nhập nhằng chức năng giữa các layer với nhau. Thế là được rồi. **"Có ý niệm phân chia thế là đã ổn rồi"** - tôi tự nhủ. 

Cá nhân tôi cũng không phân định rạch ròi các khái niệm mà định nghĩa đôi khi quá mơ hồ. Điển hình là Model - 1 thành phần trong kiến trúc xuất hiện nhiều trong các pattern MVC, MVP, MVVM,...  Tôi để ý rằng, khi vấn đáp ứng viên về kiến trúc MVC, khi được hỏi **"View là gì?"** mọi người đều trả lời na ná nhau, nhưng khi hỏi **"Model là gì?"** thì câu trả lời lại rất khác ??? 

## Business Object, Business Rule, Business Logic

Kinh nghiệm của tôi khi tìm hiểu về các loại Object là nên phân tích theo **đặc tính**, **chức năng**, **nguồn gốc** của object (vì 1 object có thể là 1 hoặc nhiều loại):

* Data Transfer Object (DTO): Là những object được mapping từ database hoặc api (từ Data Layer)
* Entity Object: là những object có định danh như Account, Product, Invoice, Transaction,... tất cả những đối tượng này đều hướng về 1 thực thể duy nhất. Mỗi entity có thể có quan hệ 1-1 hoặc 1-n với các entity khác.
* Value Object:  ngược lại với Entity, Value là những object không có tính định danh, mỗi value object có thể thuộc nhiều Entity (vd: Point, Name, Value). Value Object không có chứa Business.
* Business Object: là object tham gia trong Business Layer. Vd, ta cần làm chức năng Add Cart, output của chúng ta là Order thì chắc rồi, nhưng để compose được 1 order thì cần tham gia của nhiều đối tượng khác như loại sản phẩm, số lượng tồn, số lượng đặt, thông tin về kho, đơn vị vận chuyển,...
* Domain Object: thường được hiểu là tương tự như Business Object nhưng phạm vi của Domain rộng hơn. Business thiên về service, chức năng, Domain là 1 lĩnh vực bao quát. Vd: ta có domain Shopping, nhưng có business về Search, Campaign,....





BL tập trung vào cách 

BR hay các nguyên tắc nghiệp vụ trong yêu cầu khách hàng. Ở khâu Class Design thì lấy việc xác định, phân loại statement (phát biểu) trong requirement là tiền đề. Ví như việc chúng ta đưa ra các mẫu pattern MVC, MVVM và ấn định xử lý này, xử lý nọ phải đặt trong Model hay ViewModel còn việc hiển thị thì thuộc về View.

Như vậy, chúng ta phải định nghĩa BR thế nào cho sang:

* Không phải statement nào trong REQ đều là BR. Vd: Ly cafe này giá 30k. Ngày nào cũng thế, ai uống mua cũng bán đúng 1 giá đó. Thế thì đây không phải là BR, mấy ông BA cũng không nghề ngỗng gì với cái REQ này được.
* BR là những statement có tính constraint, logic để dẫn đến những quyết định khác nhau. Đơn giản hơn, BR là những statement đại loại như: Nếu... thì..., Trường hợp là ... thì phải...., Chỉ...., Đặc biệt..., Phải (Must)....,. v..v BR cho biết khi nào bạn cần và không được làm gì. Vd: Ngày trong tuần ly cafe này giá 30k, ngày lễ tăng 15%, khách VIP bớt bớt 10%, trai xinh gái đẹp thì bớt thêm 5% nữa, nếu cafe mà có topping thì ... kiểu kiểu như vậy gọi là BR.



#### Xác định BR có ý nghĩa thế nào với developer

Như tôi đã nói ở trên, không xác định được BR thì tổ chức code hợp lý được. Chúng ta kiến trúc source code theo MVC, MVVM chẳng phải là đang tìm các tổ chức các xử lý hợp lý, dễ maintain hơn sao.





## MVC's Model







Bạn không nghe nhầm đâu. Từ 1979, MVC được **Trygve Reenskaug** giới thiệu đến nay đã trải qua khá nhiều biến thể. 

> Tham khảo http://stephenwalther.com/archive/2008/08/24/the-evolution-of-mvc, thật ra còn nhiều nhiều biến thể nữa). 

Tôi ngày xưa đẹp trai, hiếu học mỗi tội khù khờ, cứ lên google search "MVC Pattern" mà đọc cho kỳ hết, đến tẩu hỏa nhập ma, mỗi trang giải thích mỗi kiểu. Cứ nghĩ là do cách diễn đạt khác nhau thôi, chứ ngờ đâu nó khác thiệt T_T (Không biết có ai đồng cảnh ngộ vậy không)

Vấn đề là tất cả những biến thể này đều lấy tên là MVC,  nhưng chức năng mỗi thành phần trong kiến trúc lại nhiều khác biệt. Bài viết này chỉ giới hạn phân tích về Model trong MVC dùng cho Android, iOS.







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

