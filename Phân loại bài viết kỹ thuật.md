## Nguyên tắc YAGNI: Anh Đếch cần gì nhiều ngoài em

![Kết quả hình ảnh cho anh đếch cần gì nhiều ngoài em](https://i.ytimg.com/vi/KdrbBJNFwGw/maxresdefault.jpg)

#### YAGNI, Nguyên tắc dễ hiểu ...

YAGNI có từ thời phương pháp lập trình XP ([ExtremeProgramming](https://martinfowler.com/bliki/ExtremeProgramming.html)) vào những năm 90, trước khi Scrum nổi lên như một hiện tượng. XP là 1 phương pháp chú trọng tốc độ phát triển trong đó YAGNI được xem nguyên tắc tâm pháp quan trọng. "**Đừng giả định và xây dựng trước các Tính năng phần mềm trước khi chúng ta thực sự cần nó**" là 1 phát biểu tương đối đầy đủ hơn "You Aren't Gonna Need It". 

Đồng nghĩa với việc "đếch cần gì nhiều ngoài em - các tính năng được khách hàng yêu cầu". Hãy chú ý, tôi đang focus vào "Tính năng phần mềm".

Thỉnh thoảng, tôi cũng vi phạm YAGNI, với lập luận rằng: "**Ngay thời điểm này, nếu làm luôn tính năng này thì chi phí sẽ ít hơn sau này đến 5 lần**" - nghe như 1 tay bán bảo hiểm ế ẩm đang mời chào cho chính mình nhỉ :))) - thế là tôi giả định trước các tính năng (mà tôi cho là sớm muộn gì cũng phải là) và xây dựng luôn.

May mắn là có khi tôi cũng đúng, nhưng vẫn có vài tính năng chờ mãi cũng chưa được ai kêu làm. Nhưng hãy hình dung xem, khi các "tính năng giả định" quá nhiều, thì lượng code sẽ phình lên đáng kể,  gây trở ngại cho những Tính năng Cần được đáp ứng ngay. Cuối cùng là, dù là code của "tính năng giả định" nhưng vẫn cần được nội bộ review, kiểm thử cũng ngốn không ít chi phí.

"Nhưng giờ đâu có ai làm XP" - À, nguyên tắc này tuy xưa nhưng chưa cũ nhé, YAGNI vẫn rất rất hợp lý với Scrum. 

Tuy nhiên, khi tôi nghiên cứu về YAGNI, có khá nhiều nhầm lẫn về nguyên tắc vàng này. 

#### ... nhưng cũng dễ nhầm

> "Anh Đếch cần gì nhiều ngoài em" - Câu này chỉ dùng để tỏ tình thôi, còn thực tế ai cũng biết là không phải mà. YAGNI cũng vậy.

Đừng nghĩ về YAGNI cực đoan theo kiểu Đen Vâu nhé. 

Một lần, tôi được đồng nghiệp chia sẻ về nguyên tắc của cậu ấy. Cậu ta "tôn thờ" YAGNI, tối giản tất cả vấn đề về source code, tính năng vừa đủ , kiến trúc tối giản hết mức: Không cần flexible, không dự trù busniess sẽ phát triển, yêu cầu đến đâu thì kiến trúc đến đó. 

Hiểu theo cách này thì, YAGNI có đồng minh là KISS và xem SOLID như kẻ thù không đội trời chung rồi à. 

> Yagni only applies to capabilities built into the software to support a presumptive feature, it does not apply to effort to make the software easier to modify

Xin chú ý lần nữa, YAGNI đang nói về những "tính năng phần mềm" mà người dùng nhận được, nhưng YAGNI không yêu cầu giảm thiểu những nỗ lực làm phần mềm linh động dễ sửa đổi hơn.

> Yagni is not a justification for neglecting the health of your code base. Yagni requires (and enables) malleable code.

YAGNI không phải lời biện minh cho việc bỏ qua sự rõ ràng, linh hoạt của source code. Rất nhiều cáo buộc YAGNI là nguyên nhân dẫn đến nợ kỹ thuật, nếu chỉ code nhanh cho được tính năng hiện tại và không quan tâm đến những thay đổi sau này. Hoàn toàn ngược lại, YAGNI chú trọng tốc độ phát triển, yêu cầu source  phải dễ thay đổi, thêm chức năng mới 1 cách dễ dàng với chi phí thấp.

Rõ ràng, quan điểm của người bạn tôi là kiểu hiểu lầm tai hại, phổ biến về YAGNI khi chỉ hiểu YAGNI về mặt câu chữ "You Aren't Gonna Need It". 

Tôi không cần xây dựng sớm các tính năng giả định, thay vào đó, hãy luôn chuẩn bị tinh thần cho mọi sự thay đổi bằng cách làm source code linh hoạt và trừu tượng hơn.

