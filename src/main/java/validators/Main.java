package validators;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
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


        System.out.println("user1 violations:");
        checkViolations(user);
        System.out.println("user2 violations:");
        checkViolations(user2);


    }

    private static void checkViolations(User user) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<User>> violations = validator.validate(user);
        for (ConstraintViolation<User> v : violations) {

            System.out.println(v.getPropertyPath() + " - " + v.getInvalidValue() + " - " + v.getMessage());
        }
        factory.close();
    }
}
