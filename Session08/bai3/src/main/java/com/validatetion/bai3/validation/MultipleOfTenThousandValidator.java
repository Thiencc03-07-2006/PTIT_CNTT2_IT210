package com.validatetion.bai3.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MultipleOfTenThousandValidator
        implements ConstraintValidator<MultipleOfTenThousand, Long> {

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        // ⚠️ Best Practice: null để @NotNull xử lý
        if (value == null) {
            return true;
        }

        // Chặn số âm
        if (value < 0) {
            return false;
        }

        // Điều kiện >= 50.000
        if (value < 50000) {
            return false;
        }

        // Điều kiện bội số 10.000
        return value % 10000 == 0;
    }
}