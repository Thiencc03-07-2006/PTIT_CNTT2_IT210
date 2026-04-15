package com.validation.bai2.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class EmployeeDto {
    @NotNull
    @Min(value = 18, message = "Nhân viên phải từ 18 tuổi trở lên")
    @Max(value = 60, message = "Tuổi nhân viên không được vượt quá 60")
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
