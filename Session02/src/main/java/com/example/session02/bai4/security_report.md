**1. XSS là gì?**

**Định nghĩa**

**XSS (Cross-Site Scripting)** là lỗ hổng cho phép chèn JavaScript vào HTML trả về → trình duyệt user sẽ thực thi.

**Vì \<c:out\>:** Hiển thị như text

**Dùng EL trực tiếp:**

\${keyword}

Input:

\<script\>alert(1)\</script\>

Output HTML:

\<script\>alert(1)\</script\>

Trình duyệt execute → bị hack

**Dùng \<c:out\>:**

\<c:out value=\"\${keyword}\" escapeXml=\"true\"/\>

Output:

&lt;script&gt;alert(1)&lt;/script&gt;

Hiển thị như text  
Không execute

**2. \<c:if\> vs \<c:choose\>**

**\<c:if\>**Dùng cho điều kiện đơn giản (1 nhánh)

**\<c:choose\>**Dùng cho nhiều nhánh (if-else if-else)

| **Logic**  | **Nên dùng** |
|------------|--------------|
| Giá vé     | \<c:choose\> |
| Vé còn lại | \<c:choose\> |

Vì có nhiều trạng thái

**3. \<c:url\> giải quyết gì?**

**Tự động xử lý Context Path (Đường dẫn gốc của ứng dụng)**

- **Nếu bạn hardcode /events/1/book:** Dấu gạch chéo đầu tiên / đại diện cho **Server Root** (ví dụ: http://localhost:8080/). Trình duyệt sẽ tìm đến địa chỉ http://localhost:8080/events/1/book.

- **Nếu bạn dùng \<c:url value=\"/events/1/book\" /\>:** Thẻ này sẽ tự động lấy context path hiện tại của ứng dụng và nối vào phía trước.

**Nếu deploy: /ticketing**

\<a href=\"/events/1/book\"\>

URL thành: /events/1/book

\<c:url value=\"/events/\${event.id}/book\"/\>

➡ URL thành: /ticketing/events/1/book
