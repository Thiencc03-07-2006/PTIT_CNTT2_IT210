**1. Lỗi trong MyWebAppInitializer.java**

@Override  
protected String\[\] getServletMappings() {  
return new String\[\] { \"/api/\*\" };  
}

**Bản chất lỗi**

Bạn đang cấu hình **DispatcherServlet chỉ lắng nghe URL bắt đầu bằng /api/**

**Kết quả**

Khi truy cập:

http://localhost:8080/demo/welcome

Request **không đi vào DispatcherServlet**  
Tomcat không tìm thấy resource tương ứng  
**HTTP 404 --- Not Found**

**2. Lỗi trong WebConfig.java**

@ComponentScan(basePackages = \"com.demo.service\")

**Bản chất lỗi**

Spring chỉ quét bean trong package: com.demo.service

Trong khi Controller nằm ở: com.demo.controller

Khi request /welcome đi vào: DispatcherServlet → HandlerMapping → Không tìm thấy Controller

Kết quả: HTTP 404 (không có handler)

**3. Nếu chỉ sửa lỗi 1 mà không sửa lỗi 2?**

**Sau khi sửa mapping DispatcherServlet nhận request**

Luồng sẽ là:

DispatcherServlet HandlerMapping không tìm thấy Controller

**Kết quả cuối cùng**

Vẫn **404**

**Quan trọng**

- Lỗi 1: request không vào được Spring

- Lỗi 2: request vào rồi nhưng **Spring không biết xử lý**

Phải sửa **cả hai** thì mới chạy được
