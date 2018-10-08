package validators.realValidators;

import validators.annotations.Divided;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DivideValidator implements ConstraintValidator<Divided, Integer> {

    private int divider;

    @Override
    public void initialize(Divided constraintAnnotation) {
        divider = constraintAnnotation.by();
    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {

        return integer%divider==0;
    }
}
