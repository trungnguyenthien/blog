## Nguyên tắc YAGNI: Anh đếch cần gì nhiều ngoài em!!!???

![Kết quả hình ảnh cho anh đếch cần gì nhiều ngoài em](https://i.ytimg.com/vi/KdrbBJNFwGw/maxresdefault.jpg)

#### 🔥 Nguyên tắc YAGNI,  thật dễ hiểu ...

YAGNI có từ thời phương pháp lập trình XP ([ExtremeProgramming](https://martinfowler.com/bliki/ExtremeProgramming.html)) vào những năm 90, trước khi Scrum nổi lên như một hiện tượng. XP là 1 phương pháp chú trọng tốc độ phát triển trong đó YAGNI được xem nguyên tắc tâm pháp quan trọng. "**Đừng giả định và xây dựng trước các Tính năng phần mềm trước khi chúng ta thực sự cần nó**" là 1 phát biểu tương đối đầy đủ hơn "You Aren't Gonna Need It". 

Đồng nghĩa với cách nói "Anh đếch cần gì nhiều ngoài em - các tính năng được khách hàng yêu cầu". 

Thỉnh thoảng, tôi cũng vi phạm YAGNI, với lập luận rằng: "**Ngay thời điểm này, nếu làm luôn tính năng này thì chi phí sẽ ít hơn sau này đến 5 lần**" - nghe như 1 tay bán bảo hiểm ế ẩm đang mời chào cho chính mình nhỉ :))) - thế là tôi giả định trước các tính năng (mà tôi cho là sớm muộn gì cũng phải là) và xây dựng luôn.

May mắn là có khi tôi cũng đúng, nhưng vẫn có vài tính năng chờ mãi cũng chưa được ai kêu làm. Hãy hình dung xem, khi các "tính năng giả định" quá nhiều, thì lượng code sẽ phình lên đáng kể,  gây trở ngại cho những Tính năng Cần được đáp ứng ngay. Cuối cùng là, dù là code của "tính năng giả định" nhưng vẫn cần được nội bộ review, kiểm thử cũng ngốn không ít chi phí.

"Nhưng giờ đâu có ai làm XP" - À, nguyên tắc này tuy xưa nhưng chưa cũ nhé, YAGNI vẫn rất rất hợp lý với Scrum. 

Lý do tôi viết bài này, là khi tôi tìm hiểu về YAGNI, có khá nhiều nhầm lẫn về "Nguyên tắc vàng" này. 

#### 🔥... nhưng cũng dễ nhầm.

> "Anh đếch cần gì nhiều ngoài em" - Câu này chỉ dùng để tỏ tình thôi, còn thực tế ai cũng biết là không phải mà. YAGNI cũng vậy.

Một lần, tôi được đồng nghiệp chia sẻ về nguyên tắc của cậu ấy. Cậu ta nhận mình theo trường phái YAGNI, đơn giản tất cả vấn đề về source code, tính năng vừa đủ , kiến trúc tối giản hết mức: Không cần flexible, không dự trù vấn đề busniess sẽ phát triển, yêu cầu đến đâu thì kiến trúc đến đó. 

Hiểu theo cách này thì, YAGNI có đồng minh là KISS và xem SOLID như kẻ thù không đội trời chung rồi à. 

> Yagni only applies to capabilities built into the software to support a presumptive feature, it does not apply to effort to make the software easier to modify

Xin chú ý: YAGNI hướng đến những "tính năng" mà người dùng nhận được, YAGNI không yêu cầu giảm thiểu những nỗ lực làm phần mềm linh động dễ sửa đổi hơn. Rõ ràng, quan điểm của người bạn tôi là kiểu hiểu lầm tai hại, phổ biến về YAGNI khi chỉ hiểu về mặt câu chữ "You Aren't Gonna Need It". 

> Yagni is not a justification for neglecting the health of your code base. Yagni requires (and enables) malleable code.

YAGNI không phải lời biện minh cho việc bỏ qua sự rõ ràng, linh hoạt của source code. Nhiều cáo buộc YAGNI là nguyên nhân dẫn đến Nợ kỹ thuật khi chỉ code nhanh cho xong tính năng hiện tại và không quan tâm đến những thay đổi sau này. 

Trên thực tế, nguyên tắc này "vô tội", chính vì XP chú trọng tốc độ phát triển, yêu cầu source càng phải dễ thay đổi, thêm chức năng mới 1 cách dễ dàng với chi phí thấp.

#### 🔥Tôi ủng hộ YAGNI, nhưng ...

Quan điểm của tôi hoàn toàn ủng hộ YAGNI, không có gì sai với tư tưởng "thực dụng": "Khách yêu cầu đến đâu thì xây dựng đến đó".

Tuy vậy, nguyên tắc này khá kiệm lời giải thích, cần làm rõ chữ "IT" trong YAGNI là gì? "Tính năng" hay "Kiến trúc"?

Còn đây là cách tôi giải thích nguyên tắc YAGNI cho team:  

>  Không cần xây dựng sớm các tính năng giả định, thay vào đó, hãy luôn chuẩn bị tinh thần cho mọi sự thay đổi bằng cách làm source code linh hoạt và trừu tượng hơn.

