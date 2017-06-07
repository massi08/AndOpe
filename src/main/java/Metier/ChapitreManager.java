package Metier;


import DAO.ChapitreDao;
import DAO.CoursDao;
import Model.Chapitre;
import Model.Cours;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
public class ChapitreManager {

    private ManagerUtility managerUtility;
    @PersistenceContext(unitName = "pu-andope")
    private EntityManager em;
    private CoursDao coursDao;
    private ChapitreDao chapitreDao;

    public ChapitreManager(EntityManager em, CoursDao coursDao, ChapitreDao chapitreDao) {
        this.em = em;
        this.coursDao = coursDao;
        this.chapitreDao = chapitreDao;
    }

    public Chapitre newChapitre(String title, String path, Cours cours) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Chapitre chapitre = this.chapitreDao.createChapitre(title, path, cours);
        em.persist(cours);
        transaction.commit();
        return chapitre;
    }

    public List<Chapitre> getAllChapitreByCoursId(int coursId){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        List<Chapitre> chapitre = chapitreDao.getAllChapitreByCoursId(coursId);

        transaction.commit();
        return chapitre;
    }

    public Chapitre getChapitre(int chapitreId) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Chapitre chapitre = chapitreDao.getChapitreById(chapitreId);

        transaction.commit();
        return chapitre;
    }

    public Chapitre getChapitre(String title) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Chapitre chapitre = chapitreDao.getChapitre(title);

        transaction.commit();
        return chapitre;
    }


    public Chapitre updateChapitreTitle(Chapitre chapitre, String title) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        chapitre = this.chapitreDao.updateChapitreName(chapitre, title);

        transaction.commit();
        return chapitre;
    }

    public Chapitre updateChapitrePath(Chapitre chapitre, String path) {

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        chapitre = this.chapitreDao.updateChapitrePath(chapitre, path);

        transaction.commit();
        return chapitre;
    }

    public boolean deleteChapitre(Chapitre chapitre) {

        EntityTransaction transaction = em.getTransaction();
        boolean status = false;
        transaction.begin();

        status = this.chapitreDao.removeChapitre(chapitre.getIdC());

        transaction.commit();
        return status;
    }
}
