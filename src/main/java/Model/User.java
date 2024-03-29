package Model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
        @NamedQuery(name="User.findByPseudo", query="SELECT u FROM User u WHERE u.pseudo = :pseudo"),
        @NamedQuery(name="User.findById", query="SELECT u FROM User u WHERE u.idU = :userId"),
        @NamedQuery(name="User.findByPseudoAndPassword", query="SELECT u FROM User u WHERE u.pseudo = :pseudo AND u.password = :userPassword"),
})
@Table(name = "user")
public class User {
    private int idU;
    private String firstname;
    private String lastname;
    private String pseudo;
    private String email;
    private String password;
    private Collection<Inscrit> inscritsByIdU;
    private Collection<Profile> profilesByIdU;
    private Collection<Userchapitre> userchapitresByIdU;

    public User() {
        this.pseudo = "";
        this.password = "";
    }

    public User(String pseudo, String password, String firstname, String lastname, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idU", nullable = false)
    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    @Basic
    @Column(name = "firstname", nullable = false, length = 255)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = false, length = 255)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "pseudo", nullable = false, length = 255)
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (idU != user.idU) return false;
        if (firstname != null ? !firstname.equals(user.firstname) : user.firstname != null) return false;
        if (lastname != null ? !lastname.equals(user.lastname) : user.lastname != null) return false;
        if (pseudo != null ? !pseudo.equals(user.pseudo) : user.pseudo != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;

        return true;
    }



    @Override
    public int hashCode() {
        int result = idU;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (pseudo != null ? pseudo.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "userByIdU")
    public Collection<Inscrit> getInscritsByIdU() {
        return inscritsByIdU;
    }

    public void setInscritsByIdU(Collection<Inscrit> inscritsByIdU) {
        this.inscritsByIdU = inscritsByIdU;
    }

    @OneToMany(mappedBy = "userByIdU")
    public Collection<Profile> getProfilesByIdU() {
        return profilesByIdU;
    }

    public void setProfilesByIdU(Collection<Profile> profilesByIdU) {
        this.profilesByIdU = profilesByIdU;
    }

    @OneToMany(mappedBy = "userByIdU")
    public Collection<Userchapitre> getUserchapitresByIdU() {
        return userchapitresByIdU;
    }

    public void setUserchapitresByIdU(Collection<Userchapitre> userchapitresByIdU) {
        this.userchapitresByIdU = userchapitresByIdU;
    }
}
