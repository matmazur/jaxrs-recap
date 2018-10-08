package validators;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DivideValidator.class)
@Target({ElementType.ANNOTATION_TYPE,ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.METHOD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Divided {


    String message() default "{validators.Divided.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    int by() default 1;

}
