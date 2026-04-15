# Tài liệu Thiết kế & Kiểm thử Validation cho Tour Management

## 1. Thiết kế Kiến trúc & Logic

### 1.1. Bảng ánh xạ nghiệp vụ (Mapping Rules)

| Nghiệp vụ | Giải pháp kỹ thuật | Ghi chú |
| :--- | :--- | :--- |
| **Mã tour:** `VN_` hoặc `INT_` + 5 số | `@Pattern` | Sử dụng Regular Expression chuẩn |
| **Giá người lớn:** `> 0` | `@Min(1)` | Ràng buộc giá trị tối thiểu |
| **Giá trẻ em:** `> 0` | `@Min(1)` | Ràng buộc giá trị tối thiểu |
| **Giá trẻ em:** `≤` Giá người lớn | **Custom Class-level** | Kiểm tra logic đa trường (Multi-field) |
| **Ngày bắt đầu:** `≥` Hôm nay | `@FutureOrPresent` | Ngăn chặn dữ liệu trong quá khứ |
| **Ngày kết thúc:** `>` Ngày bắt đầu | **Custom Class-level** | Đảm bảo tính logic của khoảng thời gian |

### 1.2. Các Annotation sử dụng

* **Built-in (Hibernate Validator):**
    * `@NotBlank`, `@NotNull`: Kiểm tra tính hiện diện của dữ liệu.
    * `@Pattern`: Ràng buộc định dạng chuỗi phức tạp.
    * `@Min`: Giới hạn giá trị số học.
    * `@FutureOrPresent`: Kiểm tra logic thời gian thực tế.
* **Custom (Tự định nghĩa):**
    * `@ValidPrice`: Xử lý ràng buộc `childPrice ≤ adultPrice`.
    * `@ValidDateRange`: Xử lý ràng buộc `endDate > startDate`.

### 1.3. Luồng xử lý (Processing Flow)

1.  **Client Side:** Người dùng nhập liệu vào form trên giao diện **Thymeleaf**.
2.  **Request:** Gửi yêu cầu `POST /tour/create` lên Server.
3.  **Controller:** Nhận DTO kèm annotation `@Valid` để kích hoạt bộ máy kiểm tra.
4.  **Bean Validation:**
    * **Field-level:** Kiểm tra từng trường đơn lẻ (Mã tour, giá, ngày).
    * **Class-level:** Kiểm tra logic giữa các trường (So sánh giá, so sánh ngày).
5.  **Handling:**
    * **Nếu có lỗi:** `BindingResult` ghi nhận lỗi → Trả về view `create-tour` → Hiển thị thông báo lỗi và giữ lại dữ liệu đã nhập.
    * **Nếu hợp lệ:** Thực hiện lưu vào Database → Điều hướng (`redirect`) sang trang thành công.

## 3. Kịch bản Kiểm thử Rủi ro

Dưới đây là các kịch bản test để đảm bảo hệ thống chặn đứng dữ liệu không hợp lệ:

### Case 1: Mã tour sai định dạng
* **Dữ liệu:** `{"tourCode": "ABC_123"}`
* **Kết quả:** Bị `@Pattern` chặn. Trả về lỗi định dạng, không được thực thi lưu DB.

### Case 2: Giá trẻ em vượt mức giá người lớn
* **Dữ liệu:** `{"adultPrice": 100000, "childPrice": 200000}`
* **Kết quả:** Bị `@ValidPrice` chặn. Lỗi được gắn chính xác vào trường `childPrice` để thông báo cho người dùng.

### Case 3: Ngày kết thúc trước ngày bắt đầu
* **Dữ liệu:** `{"startDate": "2026-05-10", "endDate": "2026-05-01"}`
* **Kết quả:** Bị `@ValidDateRange` chặn. Thông báo khoảng thời gian không hợp lệ.

### Case 4: Ngày bắt đầu ở quá khứ
* **Dữ liệu:** `{"startDate": "2020-01-01"}`
* **Kết quả:** Bị `@FutureOrPresent` chặn. Ngăn chặn việc tạo các tour du lịch cho thời điểm đã qua.

### Tại sao KHÔNG bị crash 500?
Dùng @Valid + BindingResult
Validator:
* check null trước
* **không throw exception
* **Không có logic if-else nguy hiểm trong Controller