package com.validation.bai5.model.dto;

import com.validation.bai5.validation.ValidDateRange;
import com.validation.bai5.validation.ValidPrice;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@ValidPrice
@ValidDateRange
public class TourDto {

    @NotBlank
    @Pattern(regexp = "^(VN|INT)_\\d{5}$",
            message = "Mã tour phải VN_ hoặc INT_ + 5 số")
    private String tourCode;

    @NotNull
    @Min(value = 1, message = "Giá người lớn phải > 0")
    private Long adultPrice;

    @NotNull
    @Min(value = 1, message = "Giá trẻ em phải > 0")
    private Long childPrice;

    @NotNull
    @FutureOrPresent(message = "Ngày khởi hành phải từ hôm nay")
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    public String getTourCode() {
        return tourCode;
    }

    public void setTourCode(String tourCode) {
        this.tourCode = tourCode;
    }

    public Long getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(Long adultPrice) {
        this.adultPrice = adultPrice;
    }

    public Long getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(Long childPrice) {
        this.childPrice = childPrice;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}