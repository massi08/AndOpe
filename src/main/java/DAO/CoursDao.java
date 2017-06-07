package DAO;


import Model.Cours;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class CoursDao {
    private EntityManager em;

    public CoursDao(EntityManager em) {
        this.em = em;
    }

    public Cours createCours(String title, int nbExercices) {
        Cours cours = getCoursByTitle(title);
        if (cours == null) {
            cours = new Cours(title,nbExercices);
            em.persist(cours);
            return cours;
        }
        else {
            return cours;
        }
    }

    public Cours getCoursByTitle(String name) {
        Cours u = null;
        Query query = em.createNamedQuery("Cours.findByTitle", Cours.class).setParameter("title", name);
        try {
            u = (Cours) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return u;
    }

    public Cours getCoursById(int id){
        Cours u = null;
        Query query = em.createNamedQuery("Cours.findById", Cours.class).setParameter("coursId", id);
        try {
            u = (Cours) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return u;
    }

    public Cours updateCoursExerciceNumber(Cours cours, int nbExercice){
        cours.setNbExercices(nbExercice);
        return cours;
    }

    public Cours updateCoursName(Cours cours, String name){
        cours.setTitle(name);
        return cours;
    }

    public boolean removeCours(String coursName){
        Cours cours = getCoursByTitle(coursName);
        if(cours != null){
            em.remove(cours);
            return true;
        }
        return false;
    }
}
