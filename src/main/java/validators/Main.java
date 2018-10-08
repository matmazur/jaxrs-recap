package validators;

import validators.beans.NumberBean;
import validators.beans.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Set;

public class Main {

    public static void main(String[] args) {


        User user = new User(null,
                LocalDate.of(1990, 10, 14),
                "4132414134",
                "mietek",
                "napletek",
                13,
                "jka@daso");

        User user2 = new User("username",
                LocalDate.of(1990, 10, 14),
                "11111111111",
                "mietek",
                "napletek",
                14,
                "jka@daso");

        NumberBean number  = new NumberBean(3);

        Locale.setDefault(Locale.ENGLISH);

        System.out.println("user1 violations:");
        checkViolations(user);
        System.out.println("user2 violations:");
        checkViolations(user2);
        System.out.println("number violations:");
        checkViolations(number);


    }


    private static <T> void checkViolations(T object) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<T>> violations = validator.validate(object);
        for (ConstraintViolation<T> v : violations) {

            System.out.println(v.getPropertyPath() + " - " + v.getInvalidValue() + " - " + v.getMessage());
        }
        factory.close();
    }












}
