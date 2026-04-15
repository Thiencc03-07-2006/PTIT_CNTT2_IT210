package com.validation.bai5.validation;

import com.validation.bai5.model.dto.TourDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, TourDto> {

    @Override
    public boolean isValid (TourDto dto, ConstraintValidatorContext context){
        if (dto == null) return true;
        if (dto.getStartDate() == null || dto.getEndDate() == null) return true;
        boolean valid = dto.getEndDate().isAfter(dto.getStartDate());
        if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("endDate")
                    .addConstraintViolation();
        }
        return valid;
    }
}
