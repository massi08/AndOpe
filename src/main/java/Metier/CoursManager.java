package Metier;

import DAO.CoursDao;
import Model.Cours;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

@Transactional
public class CoursManager {


    private EntityManager em;
    private CoursDao coursDao;

    public CoursManager(EntityManager em, CoursDao coursDao) {
        this.em = em;
        this.coursDao = new CoursDao(em);
    }

    public Cours newCours(String title, int nbExercice) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Cours cours = this.coursDao.createCours(title, nbExercice);
        em.persist(cours);
        transaction.commit();
        return cours;
    }

    public Cours getCours(int coursId) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Cours user = coursDao.getCoursById(coursId);

        transaction.commit();
        return user;
    }

    public Cours getCours(String title) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Cours user = coursDao.getCoursByTitle(title);

        transaction.commit();
        return user;
    }

    public Cours updateCoursTitle(Cours cours, String title) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        cours = this.coursDao.updateCoursName(cours, title);

        transaction.commit();
        return cours;
    }

    public Cours updateCoursExerciceNumber(Cours cours, int nbExercice) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        cours = this.coursDao.updateCoursExerciceNumber(cours, nbExercice);

        transaction.commit();
        return cours;
    }

    public boolean deleteCours(Cours cours) {

        EntityTransaction transaction = em.getTransaction();
        boolean status = false;
        transaction.begin();

        status = this.coursDao.removeCours(cours.getTitle());

        transaction.commit();
        return status;
    }
}
