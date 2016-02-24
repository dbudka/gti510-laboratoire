package core.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "passwordChanging")
    private Boolean passwordChanging;

    @Column(name = "email")
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getPasswordChanging() {
        return passwordChanging;
    }

    public void setPasswordChanging(Boolean passwordChanging) {
        this.passwordChanging = passwordChanging;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
