package Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;


@Entity
@NamedQueries({
        @NamedQuery(name="Chapitre.findAll", query="SELECT e FROM Chapitre e"),
        @NamedQuery(name="Chapitre.findByTitle", query="SELECT e FROM Chapitre e WHERE e.title = :title"),
        @NamedQuery(name="Chapitre.findByCoursAndName", query="SELECT e FROM Chapitre e WHERE e.coursByIdCours.idCours = :coursId and e.title = :title"),
        @NamedQuery(name="Chapitre.findAllByCoursId", query="SELECT e FROM Chapitre e WHERE e.coursByIdCours.idCours = :coursId"),
        @NamedQuery(name="Chapitre.findById", query="SELECT e FROM Chapitre e WHERE e.idC = :chapitreId"),
})
@Table(name = "chapitre")
public class Chapitre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idC", nullable = false)
    private int idC;

    @Basic
    @Column(name = "title", nullable = true, length = 255)
    private String title;

    @Basic
    @Column(name = "path", nullable = false, length = 255)
    private String path;

    @OneToMany(mappedBy = "chapitreByIdC")
    @JsonManagedReference
    private Collection<Exercice> exercicesByIdC;

    @ManyToOne
    @JoinColumn(name = "idCours", referencedColumnName = "idCours", nullable = false)
    @JsonBackReference
    private Cours coursByIdCours;

    @OneToMany(mappedBy = "chapitreByIdC")
    @JsonManagedReference
    private Collection<Userchapitre> userchapitresByIdC;

    public Chapitre(String title, String path, Cours cours) {
        this.title = title;
        this.path = path;
        this.coursByIdCours = cours;
    }

    public Chapitre() {
    }

    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Chapitre chapitre = (Chapitre) o;

        if (idC != chapitre.idC) return false;
        if (title != null ? !title.equals(chapitre.title) : chapitre.title != null) return false;
        if (path != null ? !path.equals(chapitre.path) : chapitre.path != null) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = idC;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        return result;
    }


    public Collection<Exercice> getExercicesByIdC() {
        return exercicesByIdC;
    }

    public void setExercicesByIdC(Collection<Exercice> exercicesByIdC) {
        this.exercicesByIdC = exercicesByIdC;
    }

    public Cours getCoursByIdCours() {
        return coursByIdCours;
    }

    public void setCoursByIdCours(Cours coursByIdCours) {
        this.coursByIdCours = coursByIdCours;
    }

    public Collection<Userchapitre> getUserchapitresByIdC() {
        return userchapitresByIdC;
    }

    public void setUserchapitresByIdUc(Collection<Userchapitre> userchapitresByIdC) {
        this.userchapitresByIdC = userchapitresByIdC;
    }
}
