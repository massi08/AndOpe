package Metier;

import DAO.*;
import Model.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
public class UserManager {

    private EntityManager em;

    private UserDao userDao;

    public UserManager(EntityManager em, UserDao userDao) {
        this.em = em;
        this.userDao = userDao;
    }

    public void deleteUser(String userName) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        userDao.removeUser(userName);

        transaction.commit();
    }

    public User newUser(String pseudo, String userPassword, String firstname, String lastname, String email) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        User user = userDao.createUser(pseudo, userPassword, firstname, lastname, email);
        em.persist(user);
        transaction.commit();
        return user;
    }

    public User checkUser(String pseudo, String userPassword) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        User user = userDao.getUserByPseudoPassword(pseudo, userPassword);

        transaction.commit();
        return user;
    }

    public User getUser(String pseudo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        User user = userDao.getUserByPseudo(pseudo);

        transaction.commit();
        return user;
    }

    public User getUser(int userId) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        User user = userDao.getUserById(userId);

        transaction.commit();
        return user;
    }

    public List<User> getUsers() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        List<User> users = userDao.getAllUsers();

        transaction.commit();
        return users;
    }
}
