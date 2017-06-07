package Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @Basic
    @Column(name = "title", nullable = true, length = 255)
    private String title;

    @Basic
    @Column(name = "nbExercices", nullable = true)
    private Integer nbExercices;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCours", nullable = false)
    private int idCours;

    @JsonManagedReference
    @OneToMany(mappedBy = "coursByIdCours")
    private Collection<Inscrit> inscritsByIdCours;

    @JsonManagedReference
    @OneToMany(mappedBy = "coursByIdCours")
    private Collection<Chapitre> chapitresByIdCours;

    public Cours(String title, Integer nbExercices) {
        this.title = title;
        this.nbExercices = nbExercices;
    }

    public Cours() {
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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



    public int getIdCours() {
        return idCours;
    }

    public void setIdCours(int idCours) {
        this.idCours = idCours;
    }

    public Collection<Inscrit> getInscritsByIdCours() {
        return inscritsByIdCours;
    }

    public void setInscritsByIdCours(Collection<Inscrit> inscritsByIdCours) {
        this.inscritsByIdCours = inscritsByIdCours;
    }

    public Collection<Chapitre> getChapitresByIdCours() {
        return chapitresByIdCours;
    }

    public void setChapitresByIdCours(Collection<Chapitre> chapitresByIdCours) {
        this.chapitresByIdCours = chapitresByIdCours;
    }
}
