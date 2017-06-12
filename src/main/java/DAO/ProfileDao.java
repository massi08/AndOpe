package DAO;
import Model.Exercice;
import Model.Profile;
import Model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class ProfileDao {

    private EntityManager em;

    public ProfileDao(EntityManager em) {
        this.em = em;
    }

    public Profile createProfile(User user, Exercice exercice) {
        Profile profile = new Profile(user, exercice);
        em.persist(profile);
        return profile;
    }

    public Profile getProfileById(int id) {
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

    public Profile getProfileByUserIdExerciceId(int userId, int exerciceId) {
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

    public List<Profile> getProfileByUserAndCours(int userId, int coursId) {
        List<Profile> u = null;
        Query query = em.createNamedQuery("Profile.findByUserandCours", Profile.class).setParameter("userId", userId).setParameter("coursId", coursId);
        try {
            u = query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return u;
    }

    public List<Profile> getProfileByUserId(int id) {
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
