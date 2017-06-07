package DAO;

import Model.Chapitre;
import Model.Cours;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class ChapitreDao {
    private EntityManager em;

    public ChapitreDao(EntityManager em) {
        this.em = em;
    }

    public Chapitre createCours(String title, String path, Cours cours) {
        Chapitre chapitre = new Chapitre(title, path, cours);
        em.persist(chapitre);
        return chapitre;
    }

    public Chapitre getChapitreById(int id) {
        Chapitre u = null;
        Query query = em.createNamedQuery("Chapitre.findById", Chapitre.class).setParameter("chapitreId", id);
        try {
            u = (Chapitre) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return u;
    }

    public List<Chapitre> getChapitreByCoursId(int id) {
        List<Chapitre> chapitres = null;
        Query query = em.createNamedQuery("Chapitre.findAllByCoursId", Chapitre.class).setParameter("coursId", id);
        try {
            chapitres = query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return chapitres;
    }

    public Chapitre updateChapitreName(Chapitre chapitre, String name){
        chapitre.setTitle(name);
        return chapitre;
    }

    public Chapitre updateChapitrePath(Chapitre chapitre, String path){
        chapitre.setPath(path);
        return chapitre;
    }

    public boolean removeChapitre(int chapitreId){
        Chapitre chapitre = getChapitreById(chapitreId);
        if(chapitre != null){
            em.remove(chapitre);
            return true;
        }
        return false;
    }
}
