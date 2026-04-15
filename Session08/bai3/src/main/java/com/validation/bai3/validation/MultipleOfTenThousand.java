package com.validation.bai3.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = MultipleOfTenThousandValidator.class)
public @interface MultipleOfTenThousand {

    String message() default "Số tiền phải là bội số của 10.000 VNĐ và >= 50.000 VNĐ";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}