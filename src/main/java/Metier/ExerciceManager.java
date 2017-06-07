package Metier;

import DAO.ExerciceDao;
import Model.Chapitre;
import Model.Exercice;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by fanuel on 31/05/17.
 */
public class ExerciceManager {

    private EntityManager em;
    private ExerciceDao exerciceDao;

    public ExerciceManager(EntityManager em, ExerciceDao exerciceDao) {
        this.em = em;
        this.exerciceDao = exerciceDao;
    }

    public Exercice newExercice(String title, String path, Chapitre chapitre) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Exercice exercice = this.exerciceDao.createExercice(title, path, chapitre);
        em.persist(exercice);
        transaction.commit();
        return exercice;
    }

    public List<Exercice> getAllExercicesByCoursId(int coursId){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        List<Exercice> exercice = exerciceDao.getExerciceByChapitreId(coursId);

        transaction.commit();
        return exercice;
    }

    public Exercice getExercice(int exerciceId) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Exercice exercice = exerciceDao.getExerciceById(exerciceId);

        transaction.commit();
        return exercice;
    }

    public Exercice getExercice(String title) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Exercice exercice = exerciceDao.getExercice(title);

        transaction.commit();
        return exercice;
    }

    public Exercice updateExerciceTitle(Exercice exercice, String title) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        exercice = this.exerciceDao.updateChapitreName(exercice, title);

        transaction.commit();
        return exercice;
    }

    public Exercice updateExercicePath(Exercice exercice, String path) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        exercice = this.exerciceDao.updateChapitrePath(exercice, path);

        transaction.commit();
        return exercice;
    }

    public boolean deleteExercice(Exercice exercice) {

        EntityTransaction transaction = em.getTransaction();
        boolean status = false;
        transaction.begin();

        status = this.exerciceDao.removeChapitre(exercice.getChapitreByIdC().getIdC());

        transaction.commit();
        return status;
    }
}
