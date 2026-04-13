package com.restaurant.bai3_bai4.controller;

import com.restaurant.bai3_bai4.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/merchant/food")
public class FoodController {

    private static final List<Food> foodList = new ArrayList<>();

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("food", new Food());
        model.addAttribute("categories", List.of("Khai vị", "Món chính", "Đồ uống"));
        return "food-add";
    }

    @PostMapping("/add")
    public String addFood(@ModelAttribute Food food, @RequestParam("image") MultipartFile file, Model model, RedirectAttributes redirectAttributes) {
        //Check file rỗng
        if (file.isEmpty()) {
            model.addAttribute("error", "Vui lòng chọn ảnh!");
            return "food-add";
        }
        //Check định dạng file
        String originalFilenameName = file.getOriginalFilename();
        if (originalFilenameName == null || !(originalFilenameName.endsWith(".jpg") || originalFilenameName.endsWith(".png") || originalFilenameName.endsWith(".jpeg"))) {
            model.addAttribute("error", "Chỉ chấp nhận file ảnh (.jpg, .png, .jpeg)");
            return "food-add";
        }
        //Check giá
        if (food.getPrice() < 0) {
            model.addAttribute("error", "Giá phải >= 0");
            return "food-add";
        }
        try {
            //Lưu file
            String uploadDir = "C:/RikkeiFood_Temp/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String newFileName = System.currentTimeMillis() + "_" + originalFilenameName;
            String filePath = uploadDir + newFileName;
            file.transferTo(new File(filePath));
            // set đường dẫn ảnh
            food.setImagePath(filePath);
            //Lưu vào memory
            foodList.add(food);
            //Log
            System.out.println("=== THÊM MÓN THÀNH CÔNG ===");
            System.out.println("Tên: " + food.getName());
            System.out.println("Danh mục: " + food.getCategory());
            System.out.println("Giá: " + food.getPrice());
            System.out.println("Ảnh: " + food.getImagePath());
            System.out.println("Tổng số món: " + foodList.size());
            redirectAttributes.addFlashAttribute("message", "Thêm món thành công!");
            return "redirect:/merchant/food/detail?id=" + food.getId();
        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "Lỗi upload file!");
            return "food-add";
        }
    }

    @GetMapping("/detail")
    public String showDetail(@RequestParam("id") Long id, Model model) {
        Food found = foodList.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (found == null) {
            return "redirect:/merchant/food/add";
        }
        model.addAttribute("food", found);
        return "food-detail";
    }
}