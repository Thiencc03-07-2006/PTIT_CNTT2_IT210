package com.validation.bai3.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MultipleOfTenThousandValidator
        implements ConstraintValidator<MultipleOfTenThousand, Long> {

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        if (value < 0) {
            return false;
        }
        if (value < 50000) {
            return false;
        }
        return value % 10000 == 0;
    }
}