package com.validation.bai4.validation;

import com.validation.bai4.model.dto.RegisterDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Objects;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, RegisterDto> {

    @Override
    public boolean isValid(RegisterDto dto, ConstraintValidatorContext context) {
        if (dto == null) return true;
        String password = dto.getPassword();
        String confirm = dto.getConfirmPassword();
        boolean matches = Objects.equals(password, confirm);
        if (!matches) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Mật khẩu xác nhận không khớp").addPropertyNode("confirmPassword").addConstraintViolation();
        }
        return matches;
    }
}