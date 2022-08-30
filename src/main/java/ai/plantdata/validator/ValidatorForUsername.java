package ai.plantdata.validator;

import ai.plantdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class ValidatorForUsername implements ConstraintValidator<Username, String> {

    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(String value,ConstraintValidatorContext context) {
        return Objects.isNull(value) || Objects.isNull(userService.getRepository().findByUsername(value));
    }

}

