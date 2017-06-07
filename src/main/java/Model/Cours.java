package Model;

import javax.persistence.*;
import java.util.Collection;


@Entity
@NamedQueries({
        @NamedQuery(name="Cours.findAll", query="SELECT c FROM Cours c"),
        @NamedQuery(name="Cours.findByTitle", query="SELECT c FROM Cours c WHERE c.title = :title"),
        @NamedQuery(name="Cours.findById", query="SELECT c FROM Cours c WHERE c.idCours = :coursId"),
})
@Table(name = "cours")
public class Cours {
    private String title;
    private Integer nbExercices;
    private Collection<Exercice> exercicesByIdC;
    private Collection<Inscrit> inscritsByIdC;
    private int idCours;
    private Collection<Inscrit> inscritsByIdCours;
    private Collection<Chapitre> chapitresByIdCours;

    public Cours(String title, Integer nbExercices) {
        this.title = title;
        this.nbExercices = nbExercices;
    }

    public Cours() {
    }


    @Basic
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Basic
    @Column(name = "nbExercices", nullable = true)
    public Integer getNbExercices() {
        return nbExercices;
    }

    public void setNbExercices(Integer nbExercices) {
        this.nbExercices = nbExercices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cours cours = (Cours) o;

        if (idCours != cours.idCours) return false;
        if (title != null ? !title.equals(cours.title) : cours.title != null) return false;
        if (nbExercices != null ? !nbExercices.equals(cours.nbExercices) : cours.nbExercices != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCours;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (nbExercices != null ? nbExercices.hashCode() : 0);
        return result;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCours", nullable = false)
    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    @OneToMany(mappedBy = "coursByIdCours")
    public Collection<Inscrit> getInscritsByIdCours() {
        return inscritsByIdCours;
    }

    public void setInscritsByIdCours(Collection<Inscrit> inscritsByIdCours) {
        this.inscritsByIdCours = inscritsByIdCours;
    }

    @OneToMany(mappedBy = "coursByIdCours")
    public Collection<Chapitre> getChapitresByIdCours() {
        return chapitresByIdCours;
    }

    public void setChapitresByIdCours(Collection<Chapitre> chapitresByIdCours) {
        this.chapitresByIdCours = chapitresByIdCours;
    }
}
