package com.validation.bai5.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = DateRangeValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidDateRange {
    String message() default "Ngày kết thúc phải sau ngày khởi hành";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}