package DAO;

import Model.Chapitre;
import Model.User;
import Model.Userchapitre;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class UserChapitreDao {

    private EntityManager em;

    public UserChapitreDao(EntityManager em) {
        this.em = em;
    }

    public Userchapitre createUserChapitre(User user, Chapitre chapitre) {
        Userchapitre userchapitre = new Userchapitre(user, chapitre);
        em.persist(userchapitre);
        return userchapitre;
    }

    public Userchapitre getUserchapitreById(int id) {
        Userchapitre u = null;
        Query query = em.createNamedQuery("Userchapitre.findById", Userchapitre.class).setParameter("userchapitreId", id);
        try {
            u = (Userchapitre) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return u;
    }

    public Userchapitre getUserchapitreByUserAndChapitre(int userId, int chapitreId) {
        Userchapitre u = null;
        Query query = em.createNamedQuery("Userchapitre.findByUserAndChapitre", Userchapitre.class).setParameter("userId", userId).setParameter("chapitreId", chapitreId);
        try {
            u = (Userchapitre) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return u;
    }

    public List<Userchapitre> getAllUserchapitreByUserId(int id) {
        List<Userchapitre> userchapitres = null;
        Query query = em.createNamedQuery("Userchapitre.findByUserId", Userchapitre.class).setParameter("userId", id);
        try {
            userchapitres = query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return userchapitres;
    }

    public List<Userchapitre> getAllUserchapitreByUserAndCours(int userId, int coursId) {
        List<Userchapitre> userchapitres = null;
        Query query = em.createNamedQuery("Userchapitre.findByUserAndCours", Userchapitre.class).setParameter("userId", userId).setParameter("coursId",coursId);
        try {
            userchapitres = query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return userchapitres;
    }
}
