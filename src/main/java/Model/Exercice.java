package Model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by fanuel on 30/05/17.
 */
@Entity
public class Exercice {
    private int idE;
    private String title;
    private String path;
    private Cours coursByIdC;
    private int idC;
    private Collection<Profile> profilesByIdE;

    @Id
    @Column(name = "idE", nullable = false)
    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Exercice exercice = (Exercice) o;

        if (idE != exercice.idE) return false;
        if (title != null ? !title.equals(exercice.title) : exercice.title != null) return false;
        if (path != null ? !path.equals(exercice.path) : exercice.path != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idE;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (path != null ? path.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idC", referencedColumnName = "idC", nullable = false)
    public Cours getCoursByIdC() {
        return coursByIdC;
    }

    public void setCoursByIdC(Cours coursByIdC) {
        this.coursByIdC = coursByIdC;
    }

    @Basic
    @Column(name = "idC", nullable = false)
    public int getIdC() {
        return idC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    @OneToMany(mappedBy = "exerciceByIdE")
    public Collection<Profile> getProfilesByIdE() {
        return profilesByIdE;
    }

    public void setProfilesByIdE(Collection<Profile> profilesByIdE) {
        this.profilesByIdE = profilesByIdE;
    }
}
