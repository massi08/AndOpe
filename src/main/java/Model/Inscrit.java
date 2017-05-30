package Model;

import javax.persistence.*;

/**
 * Created by fanuel on 30/05/17.
 */
@Entity
public class Inscrit {
    private int idI;
    private User userByIdU;
    private Cours coursByIdC;

    @Id
    @Column(name = "idI", nullable = false)
    public int getIdI() {
        return idI;
    }

    public void setIdI(int idI) {
        this.idI = idI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inscrit inscrit = (Inscrit) o;

        if (idI != inscrit.idI) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idI;
    }

    @ManyToOne
    @JoinColumn(name = "idU", referencedColumnName = "idU", nullable = false)
    public User getUserByIdU() {
        return userByIdU;
    }

    public void setUserByIdU(User userByIdU) {
        this.userByIdU = userByIdU;
    }

    @ManyToOne
    @JoinColumn(name = "idC", referencedColumnName = "idC", nullable = false)
    public Cours getCoursByIdC() {
        return coursByIdC;
    }

    public void setCoursByIdC(Cours coursByIdC) {
        this.coursByIdC = coursByIdC;
    }
}
