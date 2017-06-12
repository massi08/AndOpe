package Metier;

import DAO.ChapitreDao;
import DAO.UserChapitreDao;
import DAO.UserDao;
import Model.Chapitre;
import Model.Cours;
import Model.User;
import Model.Userchapitre;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Created by fanuel on 12/06/17.
 */
public class UserChapitreManager {

    private EntityManager em;
    private UserDao userDao;
    private ChapitreDao chapitreDao;
    private UserChapitreDao userChapitreDao;

    public UserChapitreManager(EntityManager em, UserChapitreDao userChapitreDao,  UserDao userDao, ChapitreDao chapitreDao) {
        this.em = em;
        this.userDao = userDao;
        this.chapitreDao = chapitreDao;
        this.userChapitreDao = userChapitreDao;
    }

    public Userchapitre newUserChapitre(User user, Chapitre chapitre) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Userchapitre userchapitre = this.userChapitreDao.createUserChapitre(user, chapitre);
        em.persist(userchapitre);
        transaction.commit();
        return userchapitre;
    }

    public Userchapitre getUserChapitreByUserAndChapitre(User user, Chapitre chapitre) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Userchapitre userchapitre = this.userChapitreDao.getUserchapitreByUserAndChapitre(user.getIdU(), chapitre.getIdC());

        transaction.commit();
        return userchapitre;
    }

    public List<Userchapitre> getAllUserchapitreByUserAndCours(User user, Cours cours){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        List<Userchapitre> userchapitres = userChapitreDao.getAllUserchapitreByUserAndCours(user.getIdU(),cours.getIdCours());

        transaction.commit();
        return userchapitres;
    }
}
