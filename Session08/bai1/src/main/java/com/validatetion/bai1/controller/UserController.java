package com.validatetion.bai1.controller;

import com.validatetion.bai1.modal.dto.AddressDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class UserController {

    @PostMapping("/update")
    public ResponseEntity<String> updateAddress(@Valid @RequestBody AddressDto addressDto) {
        return ResponseEntity.ok("Cập nhật địa chỉ thành công!");
    }
}