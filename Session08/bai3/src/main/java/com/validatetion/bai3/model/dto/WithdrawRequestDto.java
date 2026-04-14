package com.validatetion.bai3.model.dto;

import com.validatetion.bai3.validation.MultipleOfTenThousand;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class WithdrawRequestDto {

    @NotNull(message = "Số tiền không được để trống")
    @Min(value = 50000, message = "Số tiền phải >= 50.000 VNĐ")
    @MultipleOfTenThousand
    private Long withdrawAmount;

    public Long getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(Long withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }
}