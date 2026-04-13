package com.restaurant.bai5.controller;

import com.restaurant.bai5.model.Combo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/merchant/combo")
public class ComboController {

    private static final List<Combo> comboList = new ArrayList<>();

    // Form
    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("combo", new Combo());

        // danh sách món giả lập
        model.addAttribute("foods",
                List.of("Trà sữa", "Pizza", "Burger", "Khoai tây", "Coca"));

        return "combo-add";
    }

    // Submit
    @PostMapping("/add")
    public String addCombo(@ModelAttribute Combo combo,
                           @RequestParam("banner") MultipartFile file,
                           RedirectAttributes redirectAttributes,
                           Model model) {
        if (combo.getItemList() == null || combo.getItemList().size() < 2) {
            model.addAttribute("error", "Combo phải có ít nhất 2 món!");
            return "combo-add";
        }
        if (file.isEmpty()) {
            model.addAttribute("error", "Vui lòng chọn banner!");
            return "combo-add";
        }
        try {
            String uploadDir = "C:/RikkeiFood_Temp/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String newFileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            file.transferTo(new File(uploadDir + newFileName));
            combo.setBannerPath(newFileName);
            comboList.add(combo);
            System.out.println("=== COMBO CREATED ===");
            System.out.println("{");
            System.out.println("  \"id\": " + combo.getId() + ",");
            System.out.println("  \"name\": \"" + combo.getName() + "\",");
            System.out.println("  \"items\": " + combo.getItemList());
            System.out.println("}");
            redirectAttributes.addFlashAttribute("message", "Tạo combo thành công!");
            return "redirect:/merchant/combo/detail?id=" + combo.getId();
        } catch (IOException e) {
            model.addAttribute("error", "Lỗi upload file!");
            return "combo-add";
        }
    }

    // Detail
    @GetMapping("/detail")
    public String detail(@RequestParam("id") Long id, Model model) {
        Combo combo = comboList.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (combo == null) return "redirect:/merchant/combo/add";
        model.addAttribute("combo", combo);
        return "combo-detail";
    }
}