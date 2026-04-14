package com.validation.bai5.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = PriceValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPrice {
    String message() default "Giá trẻ em phải ≤ giá người lớn";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}