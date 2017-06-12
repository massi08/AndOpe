package Metier;

import DAO.CoursDao;
import Model.Cours;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
public class CoursManager {


    private EntityManager em;
    private CoursDao coursDao;
    private InscriptionManager inscriptionManager;

    public CoursManager(EntityManager em, CoursDao coursDao) {
        this.em = em;
        this.coursDao = coursDao;
    }

    public Cours newCours(String title, String image, String description, int nbExercice) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Cours cours = this.coursDao.createCours(title, image, description, nbExercice);
        em.persist(cours);
        transaction.commit();
        return cours;
    }

    public List<Cours> getAllCours(){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        List<Cours> cours = coursDao.getAllCours();

        transaction.commit();
        return cours;
    }

    public Cours getCours(int coursId) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Cours cours = coursDao.getCoursById(coursId);

        transaction.commit();
        return cours;
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

    public Cours updateCoursImage(Cours cours, String image) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        cours = this.coursDao.updateCoursImage(cours, image);

        transaction.commit();
        return cours;
    }

    public Cours updateCoursDescription(Cours cours, String description) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        cours = this.coursDao.updateCoursDescription(cours, description);

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

    public Cours updateCoursChapitreNumber(Cours cours, int nbChapitre) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        cours = this.coursDao.updateCoursChapitreNumber(cours, nbChapitre);

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
