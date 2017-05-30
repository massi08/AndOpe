package Model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by fanuel on 30/05/17.
 */
@Entity
public class Cours {
    private int idC;
    private String title;
    private String path;
    private Integer nbExercices;
    private Collection<Exercice> exercicesByIdC;
    private Collection<Inscrit> inscritsByIdC;

    @Id
    @Column(name = "idC", nullable = false)
    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
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
    @Column(name = "path", nullable = false, length = 255)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

        if (idC != cours.idC) return false;
        if (title != null ? !title.equals(cours.title) : cours.title != null) return false;
        if (path != null ? !path.equals(cours.path) : cours.path != null) return false;
        if (nbExercices != null ? !nbExercices.equals(cours.nbExercices) : cours.nbExercices != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idC;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (nbExercices != null ? nbExercices.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "coursByIdC")
    public Collection<Exercice> getExercicesByIdC() {
        return exercicesByIdC;
    }

    public void setExercicesByIdC(Collection<Exercice> exercicesByIdC) {
        this.exercicesByIdC = exercicesByIdC;
    }

    @OneToMany(mappedBy = "coursByIdC")
    public Collection<Inscrit> getInscritsByIdC() {
        return inscritsByIdC;
    }

    public void setInscritsByIdC(Collection<Inscrit> inscritsByIdC) {
        this.inscritsByIdC = inscritsByIdC;
    }
}
