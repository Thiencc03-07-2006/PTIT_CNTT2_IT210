package com.example.session01;
/*
Đoạn code sai (vi phạm IoC/DI)
public RechargeService() {
    // Lỗi: Tự khởi tạo thủ công (Hard-code dependency)
    this.gateway = new InternalPaymentGateway();
}

RechargeService tự khởi tạo dependency thay vì nhận từ bên ngoài, làm mất đi tính loose coupling, vi phạm nguyên lý IoC và DI, khiến hệ thống khó mở rộng, khó test và khó bảo trì.
 */
public class Bai1 {
}
