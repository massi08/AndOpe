package Model;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name="Inscrit.findAll", query="SELECT i FROM Inscrit i"),
        @NamedQuery(name="Inscrit.findAllByUser", query="SELECT i FROM Inscrit i WHERE i.userByIdU.idU = :userId"),
        @NamedQuery(name="Inscrit.findById", query="SELECT i FROM Inscrit i WHERE i.idI = :inscritId"),
})
@Table(name = "inscrit")
public class Inscrit {
    private int idI;
    private User userByIdU;

    public Inscrit(User idU, Cours idC) {
        this.userByIdU = idU;
        this.coursByIdCours = idC;
    }

    private Cours coursByIdCours;

    public Inscrit() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name = "idCours", referencedColumnName = "idCours", nullable = false)
    public Cours getCoursByIdCours() {
        return coursByIdCours;
    }

    public void setCoursByIdCours(Cours coursByIdCours) {
        this.coursByIdCours = coursByIdCours;
    }
}
