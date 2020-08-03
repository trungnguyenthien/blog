### Non-Null & Nullable Type

Nếu như mãi đến Java 8 mới xuất hiện annotation @NonNull để check null tự động trước khi sử dụng, thì mặc định các kiểu dữ liệu khi khai báo mà không có `? (Nullable)` thì đều là kiểu NonNull. Kotlin khuyến khích sử dụng kiểu NonNull nhằm giảm thiểu lỗi `NullPointerException` phổ biến trong lập trình. Trường hợp, bạn vẫn cần dùng kiểu Nullable, Kotlin vẫn hỗ trợ kèm theo các toán tử check null simple hơn Java.

```kotlin
var company: String? = "Techbase"

val a = company!!.length // a = 8
company = null
val b = company!!.length // throw NullPointerException

company = "Techbase"
val a = company?.length ?: -1 // a = 8
company = null
val b = company?.length ?: -1 // b = -1

company?.let {
    // do something if object is not null
}
```

### Kết

Những tính năng kể trên chỉ là một phần những khác biệt (cũng có thể gọi là cải tiến đáng kể) từ Kotlin. Nhìn chung, đây là một ngôn ngữ tuyệt vời. Với cùng 1 ý tưởng, lượng code Kotlin ít hơn và dễ đọc hơn rất nhiều so với Java, đặc biệt là phần định nghĩa class/function. Ở góc độ nào đó, số lượng dòng code tỉ lệ nghịch với thời gian code và tỉ lệ thuận với độ chính xác mỗi dòng code.

Một vấn đề nhỏ duy nhất là Kotlin vẫn đang giai đoạn phát triển và thay đổi. Mỗi khi có version mới sẽ có sựu thay đổi syntax trước đó và sẽ có thêm nhiều keyword mới (lượng keyword hiện tại đã hơn nhiều so với Java). Thỉnh thoảng, bạn sẽ gặp một số task kiểu như "upgrade Kotlin 1.xxx". Không cần phải lo, vì thường thì IDEs đã giúp bạn phần lớn rồi! Nếu bạn là vẫn đang dùng ngôn ngữ Java để viết ứng dụng, hãy thử chuyển sang Kotlin./