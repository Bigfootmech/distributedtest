package org.distributedtest.core.validators;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = TransactionAmountValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface TransactionAmount {

    String message() default "{Transaction Amount}";
     
    Class<?>[] groups() default {};
     
    Class<? extends Payload>[] payload() default {};
}
