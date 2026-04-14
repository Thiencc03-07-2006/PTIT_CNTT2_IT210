package com.validation.bai5.validation;

import com.validation.bai5.model.dto.TourDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PriceValidator implements ConstraintValidator<ValidPrice, TourDto> {

    @Override
    public boolean isValid(TourDto dto, ConstraintValidatorContext context) {
        if (dto == null) return true;
        if (dto.getAdultPrice() == null || dto.getChildPrice() == null)
            return true;
        boolean valid = dto.getChildPrice() <= dto.getAdultPrice();
        if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Giá trẻ em phải nhỏ hơn hoặc bằng giá người lớn")
                    .addPropertyNode("childPrice")
                    .addConstraintViolation();
        }
        return valid;
    }
}