//package com.example.session02.controller;
//
//import com.example.session02.model.Product;
//import com.example.session02.model.Student;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//import java.util.List;
//
//@Controller
//@RequestMapping(value = {"/"})
//public class WebController {
//
//    @GetMapping("/list-product")
//    public String productList(Model model) {
//        // Giả lập dữ liệu (Sau này bạn sẽ lấy từ Service/DB)
//        List<Product> list = Arrays.asList(
//                new Product(1, "iPhone 15", 20000000, true),
//                new Product(2, "Samsung S24", 18000000, false)
//        );
//
//        model.addAttribute("products", list); // Gửi sang JSP
//        return "list-product";
//    }
//
//    @GetMapping("/list-student")
//    public String studentList(Model model) {
//        // Giả lập dữ liệu (Sau này bạn sẽ lấy từ Service/DB)
//        List<Student> list = Arrays.asList(
//                (new Student(1, "Ngô Trung Chiến", true, LocalDate.of(2003, 5, 15), "Hà Nội", "K24_Frontend")),
//                (new Student(2, "Đỗ Hoàng Anh", true, LocalDate.of(2003, 10, 20), "Hải Phòng", "K24_Frontend")),
//                (new Student(3, "Đỗ Đức Mạnh", true, LocalDate.of(2002, 1, 1), "Nam Định", "K24_Frontend")),
//                (new Student(4, "Vũ Đức Huy Hoàng", true, LocalDate.of(2003, 12, 12), "Thái Bình", "K24_Frontend"))
//        );
//
//        model.addAttribute("students", list); // Gửi sang JSP
//        return "list-student";
//    }
//}
