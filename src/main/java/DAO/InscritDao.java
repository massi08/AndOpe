package DAO;


import Model.Cours;
import Model.Inscrit;
import Model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.List;

public class InscritDao {

    private EntityManager em;

    public InscritDao(EntityManager em) {
        this.em = em;
    }

    public Inscrit newInscription(User user, Cours cours){
        Inscrit inscrit = getInscritById(user.getIdU());
        if (inscrit == null) {
            inscrit = new Inscrit(user,cours);
            em.persist(inscrit);
            return inscrit;
        }
        else {
            return inscrit;
        }
    }

    public Inscrit getInscritById(int id) {
        Inscrit u = null;
        Query query = em.createNamedQuery("Inscrit.findById", Inscrit.class).setParameter("inscritId", id);
        try {
            u = (Inscrit) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return u;
    }

    public List<Inscrit> getInscritByUser(int id) {
        List<Inscrit> u = null;
        Query query = em.createNamedQuery("Inscrit.findAllByUser", Inscrit.class).setParameter("userId", id);
        try {
            u =  query.getResultList();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ExceptionDao(e);
        }

        return u;
    }
}
