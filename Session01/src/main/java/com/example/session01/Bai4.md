# So sánh các giải pháp Dependency Injection

| **Tiêu chí**                     | **Constructor Injection**                                                                                  | **Field Injection (Dùng @Autowired)**                                                         |
|----------------------------------|------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------|
| **Tính bất biến (Immutability)** | **Tốt.** Các dependency có thể khai báo là final, đảm bảo không bị thay đổi sau khi khởi tạo.              | **Kém.** Không thể sử dụng final, các dependency có thể bị thay đổi vô ý ở Runtime.           |
| **Tính kiểm thử (Testing)**      | **Dễ dàng.** Có thể truyền các bản giả (Mock) trực tiếp vào constructor mà không cần đến Spring Container. | **Khó.** Cần sử dụng Reflection hoặc Mockito Runner để \"nhồi\" dependency vào private field. |
| **Sự minh bạch**                 | **Cao.** Nhìn vào Constructor là biết ngay Service này cần những gì để hoạt động.                          | **Thấp.** Các dependency bị ẩn giấu bên trong các private field.                              |
| **Phát hiện lỗi (Fail-fast)**    | Phát hiện ngay lúc khởi động (Compile-time/Startup) nếu thiếu dependency.                                  | Có thể gây ra NullPointerException tại Runtime nếu Container không tiêm được.                 |
| **Circular Dependency**          | Dễ dàng phát hiện và ngăn chặn sớm.                                                                        | Khó phát hiện hơn, thường dẫn đến lỗi tiềm ẩn.                                                |

# Xử lý \"Bẫy dữ liệu\": Sự cố mất kết nối SMS

Trong trường hợp dịch vụ SMS bị đứt giữa chừng, nếu chúng ta thiết kế code theo kiểu liên kết chặt (Tight Coupling), toàn bộ tiến trình nạp tiền có thể bị treo hoặc báo lỗi cho khách hàng dù tiền đã vào tài khoản.

**Giải pháp đề xuất:**

- **Sử dụng Interface:** SmsSender phải là một Interface. Khi nhà cung cấp A bị đứt, ta có thể nhanh chóng triển khai SmsSenderProviderB mà không sửa logic của NotificationService.

- **Xử lý ngoại lệ (Error Handling):** Bọc quá trình gửi SMS trong try-catch. Nếu SMS lỗi, hệ thống nên ghi log và ưu tiên gửi Email trước, sau đó đưa tin nhắn SMS vào hàng đợi (Retry Queue) để gửi lại sau, thay vì làm hỏng luồng nạp tiền.

# Kết luận và Lựa chọn giải pháp

**Giải pháp tối ưu nhất: Constructor Injection.**

- **Đảm bảo tính bắt buộc:** NotificationService không thể tồn tại nếu thiếu EmailSender hay SmsSender. Constructor Injection bắt buộc chúng ta phải cung cấp đủ các \"nguyên liệu\" này ngay từ đầu.

- **Hỗ trợ Unit Test:** Với một hệ thống nhạy cảm về tiền tệ như Cyber Center, việc viết Test với Mock object là bắt buộc. Constructor Injection giúp việc này trở nên cực kỳ đơn giản và tường minh.

- **Tránh lỗi Null:** Loại bỏ hoàn toàn nguy cơ gọi nhầm vào một Service chưa được khởi tạo.
