package validatorsWithJPA;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

@Stateless
public class ProductRepo {

    @PersistenceContext
    EntityManager entityManager;

    public void add(Product product) {

        try {
            entityManager.persist(product);
        } catch (ConstraintViolationException c) {

            Set<ConstraintViolation<?>> set = c.getConstraintViolations();
            for (ConstraintViolation<?> v : set) {
                System.out.println(v.getPropertyPath() + " - " + v.getInvalidValue() + " - " + v.getMessage());
            }
        }
    }
}
