package api.dto;

import core.entity.AbstractEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Component
@Scope(value = "session",  proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserDTO extends AbstractDTO {

    private Integer id;

    private String username;

    private String password;

    private Boolean passwordChanging;

    private String email;

    private List<HistoryDTO> videoHistory;

    private List<FavoritesDTO> videoFavorites;

    private Integer connectTry;

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

    public List<HistoryDTO> getVideoHistory() {
        return videoHistory;
    }

    public void setVideoHistory(List<HistoryDTO> videoHistory) {
        this.videoHistory = videoHistory;
    }

    public List<FavoritesDTO> getVideoFavorites() {
        return videoFavorites;
    }

    public void setVideoFavorites(List<FavoritesDTO> videoFavorites) {
        this.videoFavorites = videoFavorites;
    }

    public Integer getConnectTry() {
        return connectTry;
    }

    public void setConnectTry(Integer connectTry) {
        this.connectTry = connectTry;
    }
}
