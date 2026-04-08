**1 Bẫy dữ liệu ép kiểu**

- Khi dùng @PathVariable Long id, nếu người dùng nhập chữ (ví dụ /orders/t), Spring sẽ không thể chuyển đổi sang kiểu số.

- Điều này gây ra lỗi **TypeMismatchException (HTTP 400)**.

- Để tránh crash hệ thống, cần xử lý ngoại lệ bằng cách chuyển sang kiểu String và tự parse, hoặc dùng @ExceptionHandler.

- Nhờ đó hệ thống trả về thông báo thân thiện thay vì lỗi kỹ thuật.

**2 Idempotent**

**DELETE an toàn vì sao?**

- DELETE là **idempotent**

- Gọi 1 lần:

Xóa đơn hàng 1

- Gọi 3 lần:

Lần 1: xóa thành công  
Lần 2: không còn gì để xóa  
Lần 3: vẫn không đổi

**Trạng thái hệ thống KHÔNG thay đổi thêm**

**POST nguy hiểm vì sao?**

- POST là **không idempotent**

- Gọi 3 lần:

tạo 3 đơn hàng khác nhau

Gây:

- dữ liệu rác

- trùng đơn

- sai nghiệp vụ

**Kết luận**

- DELETE → an toàn khi spam request

- POST → nguy hiểm, cần kiểm soát (disable button, token, etc.)
