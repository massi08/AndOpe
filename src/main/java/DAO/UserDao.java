package DAO;

import Model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class UserDao {

    private EntityManager em;

    public UserDao(EntityManager em) {
        this.em = em;
    }

    /**
     * Récupère un utilisateur par son nom
     * @param name le nom de l'utilisateur
     * @return l'utilisateur
     */
    public User getUserByPseudo(String name) {
        User u = null;
        Query query = em.createNamedQuery("User.findByPseudo", User.class).setParameter("pseudo", name);
        try {
            u = (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return u;
    }

    /**
     * Récupère un utilisateur en fonction de son Id
     * @param id l'Id de l'utilisateur
     * @return l'utilisateur
     */
    public User getUserById(int id) {
        User u = null;
        Query query = em.createNamedQuery("User.findById", User.class).setParameter("userId", id);
        try {
            u = (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return u;
    }

    /**
     * récupère l'utilisateur grâce à son nom et son password
     * @param name le nom de l'utilisateur
     * @param password le mot de passe de l'utilisateur
     * @return l'utilisateur
     */
    public User getUserByPseudoPassword(String name, String password) {
        User u = null;
        Query query = em.createNamedQuery("User.findByPseudoAndPassword", User.class).setParameter("pseudo", name).setParameter("userPassword", password);
        try {
            u = (User) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return u;
    }

    /**
     * Récupère tous les utilisateurs
     * @return la liste d'utilisateurs
     */
    public List<User> getAllUsers() {
        List<User> lu = null;
        Query query = em.createNamedQuery("User.findAll", User.class);

        try {
            lu = query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }
        return lu;
    }

    /**
     * Crée un utilisateur
     * @param pseudo le nom de l'utilisateur
     * @param userPassword son password
     * @return l'utilisateur crée
     */
    public User createUser(String pseudo, String userPassword, String firstname, String lastname, String email) {
        User u = getUserByPseudo(pseudo);
        if (u == null) {
            u = new User(pseudo, userPassword, firstname, lastname, email);
            System.out.println(u.getPseudo());
            return u;
        }
        else {
            return u;
        }
    }

    /**
     * Supprime un utilisateur en fonction de son nom
     * @param userName le nom de l'utilisateur à supprimer
     */
    public void removeUser(String userName) {
        User u = getUserByPseudo(userName);
        if(u != null) {
            em.remove(u);
        }
    }
}
