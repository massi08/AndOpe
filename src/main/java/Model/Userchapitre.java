package Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;


@Entity
@NamedQueries({
        @NamedQuery(name="Userchapitre.findAll", query="SELECT u FROM Userchapitre u"),
        @NamedQuery(name="Userchapitre.findByUserId", query="SELECT u FROM Userchapitre u WHERE u.userByIdU.idU = :userId"),
        @NamedQuery(name="Userchapitre.findByChapitreId", query="SELECT u FROM Userchapitre u WHERE u.chapitreByIdC.idC= :chapitreId"),
        @NamedQuery(name="Userchapitre.findById", query="SELECT u FROM Userchapitre u WHERE u.idUc = :userchapitreId"),
        @NamedQuery(name="Userchapitre.findByUserAndChapitre", query="SELECT u FROM Userchapitre u WHERE u.userByIdU.idU = :userId AND u.chapitreByIdC.idC = :chapitreId"),
        @NamedQuery(name="Userchapitre.findByUserAndCours", query="SELECT u FROM Userchapitre u WHERE u.userByIdU.idU = :userId AND u.coursByIdCours.idCours = :coursId"),
})
@Table(name = "userchapitre")
public class Userchapitre {
    private int idUc;
    private Chapitre chapitreByIdC;
    private User userByIdU;
    private Cours coursByIdCours;

    public Userchapitre() {
    }

    public Userchapitre(User user, Chapitre chapitre){
        this.chapitreByIdC = chapitre;
        this.userByIdU = user;
        this.coursByIdCours = chapitre.getCoursByIdCours();
    }

    @Id
    @Column(name = "idUC", nullable = false)
    public int getIdUc() {
        return idUc;
    }

    public void setIdUc(int idUc) {
        this.idUc = idUc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Userchapitre that = (Userchapitre) o;

        if (idUc != that.idUc) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idUc;
    }

    @ManyToOne
    @JoinColumn(name = "idC", referencedColumnName = "idC", nullable = false)
    public Chapitre getChapitreByIdC() {
        return chapitreByIdC;
    }

    public void setChapitreByIdC(Chapitre chapitreByIdC) {
        this.chapitreByIdC = chapitreByIdC;
    }

    @ManyToOne
    @JoinColumn(name = "idU")
    public User getUserByIdU() {
        return userByIdU;
    }

    public void setUserByIdU(User userByIdU) {
        this.userByIdU = userByIdU;
    }

    @ManyToOne
    @JoinColumn(name = "idCours")
    public Cours getCoursByIdCours() {
        return coursByIdCours;
    }

    public void setCoursByIdCours(Cours coursByIdCours) {
        this.coursByIdCours = coursByIdCours;
    }
}
