package Metier;

import DAO.CoursDao;
import DAO.InscritDao;
import DAO.UserDao;
import Model.Cours;
import Model.Inscrit;
import Model.User;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

@Transactional
public class InscriptionManager {

    private EntityManager em;
    private CoursDao coursDao;
    private UserDao userDao;
    private InscritDao inscritDao;

    public InscriptionManager(EntityManager em, CoursDao coursDao, UserDao userDao, InscritDao inscritDao) {
        this.em = em;
        this.coursDao = coursDao;
        this.userDao = userDao;
        this.inscritDao = inscritDao;
    }

    public Inscrit newInscription(User user, Cours cours) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Inscrit inscrit = this.inscritDao.newInscription(user, cours);
        em.persist(inscrit);
        transaction.commit();
        return inscrit;
    }
}
