# Workaround: Lối tắt đến Nợ kỹ thuật

Workaround - 1 con đường khác, giải pháp khác để giải quyết vấn đề trước mắt, đây không hẳn là con đường "khác" sẽ dài hay ngắn hơn, đơn giản vì con đường "chính" đang bị một tảng đá chắn ngang, còn bạn phải đưa ra lựa chọn cách giải quyết.

1 - Phá tảng đá để vượt qua
2 - Tìm một con đường khác
3 - ... bỏ cuộc

Tôi, khi mới ra trường, thích chứng tỏ nên chắc chắn không chọn Bỏ cuộc, năng lực không đủ nên thường tránh việc Phá đá. Một Con đường khác là cách tôi rất nhanh nghĩ đến và cũng rất nhanh hiểu ra: Workaround là "lối tắt" đến Nợ kỹ thuật

WORKAROUND = ĐỂ LẠI NHỮNG ĐOẠN CODE KHÓ HIỂU, TƯƠNG LAI KHÓ LƯỜNG

Workaround là keyword tôi được nghe gần như mỗi ngày, hoặc, dù bạn không phát ra nó trong phần đề xuất giải pháp, nhưng giải pháp của bạn chính là workaround. 

Cách đây 1 tuần, khách yêu cầu team chặn chức năng zoom trang web trong webview (loại control hiển thị trang web trong iOS, Android) bằng cách chặn thao tác pinch (một kiểu tương tác bằng 2 ngón tay thường dùng để zoom website trên iPhone). Có thể, khách hàng chúng tôi cũng biết kỹ thuật, hiểu việc chặn zoom 1 cách trực tiếp sẽ phức tạp (ví như phá tảng đá trên đường đi) nên khách yêu cầu có thể chặn pinch cũng được (workaround). Giải pháp chặn pinch có thể dẫn đến:

- Tạo ra những đoạn code khó hiểu: developer maintain code sau này khi đọc lại sẽ chỉ hiểu được Giải pháp (chặn pinch) mà không hiểu được requirement thật phía sau (chặn zoom). Không hiểu được requirement cũ thì sẽ sinh bug mới.
- Tương lai khó lường: Workaround (chặn pinch) thường dựa trên phán đoán trạng thái hiện tại. Ví dụ, hiện tại, chúng ta đang phán đoán: "thao tác pinch chỉ dùng để zoom, mapping 1-1" , nên "chặn pinch tương đương với chặn zoom và ngược lại". Tuy nhiên, nếu quan hệ này, ở hiện tại hoặc tương lai không con là 1-1 (có nhiều thao tác có thể zoom, hoặc pinch đáp ứng cho nhiều chức năng khác) thì giải pháp này sẽ sinh bug ở đâu đó mà ta chưa biết.

Trên đây là một mẫu về vấn đề trường hợp workaround gần nhất mà tôi nhớ được, thật ra thì vấn đề này diễn ra mỗi ngày mà chắc tôi cần tập viết nhật ký để lưu lại các sample để tự nhắc nhở mình sau này.

WORKAROUND = NGUYÊN NHÂN SINH RA WORKAROUND

Có thể nói: Workaround Bank là 1 ngân hàng cho vay với lãi suất cao. Cũng có nhiều loại Nợ kỹ thuật ít lãi, nhưng... workaround là loại nặng lãi.

Ví dụ, nếu ta chọn giải pháp chính thống nhưng code khó hiểu, thì cũng là nợ kỹ thuật, nhưng bất quá chỉ là chức năng đó khó đọc hiểu thôi. Còn khi đã workaround, thì code chắc chắn khó hiểu (như đã giải thích), và sau này những vấn đề liên quan đến pinch đều phải dè chừng không dám can thiệp sâu. Vô tình ta lại đặt một tảng đá vào con đường khác, để sau này buộc phải tìm một con đường khác nữa (workaround). Giống thể loại phim về vòng lặp vô tận nhỉ @_@.

Rồi lúc nào đó, tất cả con đường đều có đá chặn lối. Hết phim.

