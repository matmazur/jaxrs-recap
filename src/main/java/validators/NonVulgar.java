package validators;


import utils.Language;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import static java.lang.annotation.ElementType.*;

@Documented
@Constraint(validatedBy = VulgarValidator.class)
@Target({METHOD, FIELD,CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NonVulgar {
    String message () default "Don't be so vulgar you nonchalant prick";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

    Language[] lang() default Language.ENG;
}
