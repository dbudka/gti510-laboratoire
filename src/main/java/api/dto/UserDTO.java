package api.dto;

import core.entity.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class UserDTO extends AbstractEntity {

    private Integer id;

    private String user;

    private String password;

    private Boolean passwordChanging;

    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id; }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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
