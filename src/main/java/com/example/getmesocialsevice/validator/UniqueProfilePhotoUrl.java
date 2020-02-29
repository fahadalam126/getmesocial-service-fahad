package com.example.getmesocialsevice.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueProfilePhotoUrlValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)

public @interface UniqueProfilePhotoUrl {

    String message() default"Profile Picture is already being used";

    Class<?>[] groups() default {};

    Class<? extends Payload>[]payload() default {};
}
