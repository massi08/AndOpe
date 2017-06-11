package DAO;

import Model.Chapitre;
import Model.Exercice;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;


public class ExerciceDao {

    private EntityManager em;

    public ExerciceDao(EntityManager em) {
        this.em = em;
    }

    public Exercice createExercice(String title, String path, Chapitre chapitre) {
        Exercice exercice = new Exercice(title, path, chapitre);
        em.persist(exercice);
        return exercice;
    }



    public Exercice getExerciceById(int id) {
        Exercice u = null;
        Query query = em.createNamedQuery("Exercice.findById", Exercice.class).setParameter("exerciceId", id);
        try {
            u = (Exercice) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return u;
    }

    public Exercice getExercice(String title) {
        Exercice u = null;
        Query query = em.createNamedQuery("Exercice.findByTitle", Exercice.class).setParameter("title", title);
        try {
            u = (Exercice) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return u;
    }

    public List<Exercice> getExerciceByChapitreId(int id) {
        List<Exercice> exercices = null;
        Query query = em.createNamedQuery("Exercice.findAllByChapitreId", Exercice.class).setParameter("chapitreId", id);
        try {
            exercices = query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return exercices;
    }

    public Exercice updateExerciceStatus(Exercice exercice, int done){
        exercice.setFinished(done);
        return exercice;
    }

    public Exercice updateExerciceName(Exercice exercice, String name){
        exercice.setTitle(name);
        return exercice;
    }

    public Exercice updateExercicePath(Exercice exercice, String path){
        exercice.setPath(path);
        return exercice;
    }

    public boolean removeExercice(int exerciceId){
        Exercice exercice = getExerciceById(exerciceId);
        if(exercice != null){
            em.remove(exercice);
            return true;
        }
        return false;
    }
}
