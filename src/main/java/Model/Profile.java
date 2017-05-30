package Model;

import javax.persistence.*;


@Entity
public class Profile {
    private int idP;
    private int idU;
    private int idE;
    private Integer status;
    private User userByIdU;
    private Exercice exerciceByIdE;

    @Id
    @Column(name = "idP", nullable = false)
    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    @Basic
    @Column(name = "idU", nullable = false)
    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    @Basic
    @Column(name = "idE", nullable = false)
    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }

    @Basic
    @Column(name = "status", nullable = true)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profile profile = (Profile) o;

        if (idP != profile.idP) return false;
        if (idU != profile.idU) return false;
        if (idE != profile.idE) return false;
        if (status != null ? !status.equals(profile.status) : profile.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idP;
        result = 31 * result + idU;
        result = 31 * result + idE;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "idE", referencedColumnName = "idE", nullable = false)
    public Exercice getExerciceByIdE() {
        return exerciceByIdE;
    }

    public void setExerciceByIdE(Exercice exerciceByIdE) {
        this.exerciceByIdE = exerciceByIdE;
    }
}
