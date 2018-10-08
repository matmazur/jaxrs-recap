package validators.annotations;


import validators.utils.Language;
import validators.realValidators.VulgarValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = VulgarValidator.class)
@Target({METHOD, FIELD,CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NonVulgar {
    String message () default "{validators.annotations.NonVulgar.message}";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

    Language[] lang() default Language.ENG;

}
