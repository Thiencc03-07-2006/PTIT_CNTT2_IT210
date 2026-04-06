1.  **Vì sao error phải dùng Request Scope?**

**Tại sao là Request Scope:** Vì một thông báo lỗi đăng nhập chỉ có giá trị ngay tại thời điểm đó. Khi bạn sửa lại mật khẩu và nhấn \"Gửi\" một lần nữa, đó là một Request mới hoàn toàn. Request Scope tự động bị xóa sau khi phản hồi (Response) được gửi đi, giúp dữ liệu luôn \"tươi\" và sạch sẽ.

**Nếu dùng Session**

- Thông báo lỗi **bị lưu dai**

- User reload vẫn thấy lỗi → UX tệ

- Có thể hiển thị sai ngữ cảnh

2.  **Vì sao totalViewCount phải dùng Application Scope?**

**Tại sao là Application Scope:** Scope này tồn tại từ khi Server khởi động đến khi tắt. Mọi người dùng đều truy cập vào cùng một biến duy nhất, giúp con số được cộng dồn chính xác từ tất cả các nguồn khách truy cập.

**Nếu dùng Session:**

| **User** | **Giá trị** |
|----------|-------------|
| A        | 3           |
| B        | 1           |

Mỗi user thấy **số khác nhau** → sai yêu cầu

3.  **Race Condition là gì?**

Race Condition xảy ra khi: Nhiều thread cùng đọc/ghi dữ liệu shared mà không đồng bộ

| **Thread A**   | **Thread B**   |
|----------------|----------------|
| count = 5      | count = 5      |
| count++ → 6    | count++ → 6    |
| setAttribute 6 | setAttribute 6 |

Kết quả: **6 thay vì 7**

**Cách fix: synchronized**

synchronized (application) {

Integer count = (Integer) application.getAttribute(\"totalViewCount\");

if (count == null) count = 0;

application.setAttribute(\"totalViewCount\", ++count);

}
