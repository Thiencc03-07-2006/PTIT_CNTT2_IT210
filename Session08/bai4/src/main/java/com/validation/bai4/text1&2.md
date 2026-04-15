Phần 1 -- Phân tích & Đề xuất

Input / Output

Input (DTO):

{  
\"username\": \"\...\",  
\"password\": \"\...\",  
\"confirmPassword\": \"\...\"  
}

Output:

- Hợp lệ → tạo tài khoản

- Không hợp lệ → trả lỗi (password ≠ confirmPassword)

Hai giải pháp

Giải pháp 1 -- if-else trong Controller/Service

if (!Objects.equals(dto.getPassword(), dto.getConfirmPassword())) {  
throw new RuntimeException(\"Mật khẩu không khớp\");  
}

Ưu điểm:

- Dễ viết

Nhược điểm:

- Logic validate nằm trong Controller → bẩn code

- Không tái sử dụng

- Khó maintain

Giải pháp 2 -- Class-Level Custom Validation

Tạo annotation áp dụng lên class DTO

@PasswordMatches  
public class RegisterDto { \... }

Ưu điểm:

- Tách biệt validation khỏi business logic

- Tái sử dụng tốt

- Chuẩn JSR 380

Phần 2 -- So sánh

| Tiêu chí               | if-else    | Class-level validation |
|------------------------|------------|------------------------|
| Boilerplate code       | Ít lúc đầu | Viết 1 lần             |
| Tái sử dụng            | Không      | Có                     |
| Clean Code             | Vi phạm    | Chuẩn                  |
| Separation of Concerns | Không      | Có                     |
| Maintain lâu dài       | Không      | Có                     |
Chọn: Class-Level Custom Validation
