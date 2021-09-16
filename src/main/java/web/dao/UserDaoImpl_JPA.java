package web.dao;


import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl_JPA implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select distinct u from User u join fetch u.roles", User.class).getResultList();
    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByLogin(String login) {
        return entityManager.createQuery("select u from User u join fetch u.roles where u.login = :login", User.class)
                .setParameter("login", login).getSingleResult();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.createQuery("delete from User u where u.id = :id")
                .setParameter("id", id).executeUpdate();
    }

    @Override
    public void updateUser(User user) {
         entityManager.merge(user);
    }


    @Override
    public User getUserById(Long id) {
        User u = entityManager.createQuery("select u from User u join fetch u.roles where u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
        return u;
    }


}