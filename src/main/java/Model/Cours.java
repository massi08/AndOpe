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

    @OneToMany(mappedBy = "coursByIdCours")
    @JsonManagedReference
    private Collection<Userchapitre> userchapitresByIdC;

    @OneToMany(mappedBy = "coursByIdCours")
    @JsonManagedReference
    private Collection<Userchapitre> profilesByIdC;

    @Basic
    @Column(name = "image", nullable = true, length = 255)
    private String image;

    @Basic
    @Column(name = "description", columnDefinition = "mediumtext",nullable = true, length=46000)
    private String description;

    @Basic
    @Column(name = "finished", nullable = false)
    private int finished;

    @Basic
    @Column(name = "nbChapitre", nullable = false)
    private int nbChapitre;

    public Cours(String title, String image, String description, Integer nbExercices) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.nbExercices = 0;
        this.finished = 0;
        this.nbChapitre = 0;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFinished() {
        return finished;
    }

    public void setFinished(int finished) {
        this.finished = finished;
    }

    public Collection<Userchapitre> getUserchapitresByIdC() {
        return userchapitresByIdC;
    }

    public void setUserchapitresByIdC(Collection<Userchapitre> userchapitresByIdC) {
        this.userchapitresByIdC = userchapitresByIdC;
    }

    public Collection<Userchapitre> getProfilesByIdC() {
        return profilesByIdC;
    }

    public void setProfilesByIdC(Collection<Userchapitre> profilesByIdC) {
        this.profilesByIdC = profilesByIdC;
    }

    public int getNbChapitre() {
        return nbChapitre;
    }

    public void setNbChapitre(int nbChapitre) {
        this.nbChapitre = nbChapitre;
    }
}
