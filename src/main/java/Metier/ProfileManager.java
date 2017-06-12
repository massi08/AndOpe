package Metier;


import DAO.ExerciceDao;
import DAO.ProfileDao;
import DAO.UserDao;
import Model.Cours;
import Model.Exercice;
import Model.Profile;
import Model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ProfileManager {

    private EntityManager em;
    private UserDao userDao;
    private ProfileDao profileDao;
    private ExerciceDao exerciceDao;

    public ProfileManager(EntityManager em, ProfileDao profileDao, UserDao userDao, ExerciceDao exerciceDao){
        this.em = em;
        this.profileDao = profileDao;
        this.userDao = userDao;
        this.exerciceDao = exerciceDao;
    }

    public Profile newProfile(User user, Exercice exercice) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Profile profile = this.profileDao.createProfile(user, exercice);
        em.persist(profile);
        transaction.commit();
        return profile;
    }

    public Profile getProfileByUserAndExercice(User user, Exercice exercice) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Profile profile = this.profileDao.getProfileByUserIdExerciceId(user.getIdU(), exercice.getIdE());

        transaction.commit();
        return profile;
    }

    public List<Profile> getAllUserchapitreByUserAndCours(User user, Cours cours){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        List<Profile> profiles = profileDao.getProfileByUserAndCours(user.getIdU(),cours.getIdCours());

        transaction.commit();
        return profiles;
    }
}
