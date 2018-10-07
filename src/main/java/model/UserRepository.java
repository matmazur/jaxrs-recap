package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(User user) {
        entityManager.persist(user);
    }


    public User findById(Long id){

        TypedQuery<User> query = entityManager.createNamedQuery("User.findById",User.class);
        query.setParameter("id",id);

        return query.getSingleResult();
    }



    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createNamedQuery("User.findAll",User.class);
        return query.getResultList();
    }

}