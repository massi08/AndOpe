package DAO;
import Model.Profile;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class ProfileDao {

    private EntityManager em;

    public ProfileDao(EntityManager em) {
        this.em = em;
    }

    public Profile getInscritById(int id) {
        Profile u = null;
        Query query = em.createNamedQuery("Profile.findById", Profile.class).setParameter("profileId", id);
        try {
            u = (Profile) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return u;
    }

    public Profile getInscritByUserIdExerciceId(int userId, int exerciceId) {
        Profile u = null;
        Query query = em.createNamedQuery("Profile.findByUserIdandExerciceId", Profile.class).setParameter("userId", userId).setParameter("exerciceId", exerciceId);
        try {
            u = (Profile) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return u;
    }

    public List<Profile> getInscritByUserId(int id) {
        List<Profile> u = null;
        Query query = em.createNamedQuery("Profile.findAllByUserId", Profile.class).setParameter("userId", id);
        try {
            u = query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return u;
    }
}
