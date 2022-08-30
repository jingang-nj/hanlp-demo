package ai.plantdata.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidatorForUsername.class)
public @interface Username {

    String message() default "用户已存在";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
