package api.dto;


import java.util.List;

public class UserDTO extends AbstractDTO {

    private Integer id;

    private String username;

    private String password;

    private Boolean passwordChanging;

    private String email;

    private List<HistoryDTO> videoHistory;

    private List<FavoritesDTO> favoritevideos;

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

    public List<FavoritesDTO> getFavoritevideos() {
        return favoritevideos;
    }

    public void setFavoritevideos(List<FavoritesDTO> favoritevideos) {
        this.favoritevideos = favoritevideos;
    }
}
