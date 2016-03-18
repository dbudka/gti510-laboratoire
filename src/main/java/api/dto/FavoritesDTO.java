package api.dto;


import java.util.Date;

public class FavoritesDTO extends AbstractDTO {

    private Integer id;

    private UserDTO user;

    private VideoDTO video;

    private Date dateAdded;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public boolean sameVideoId(int videoId){
        return getVideo().getId() == videoId;
    }
    public VideoDTO getVideo() {
        return video;
    }

    public void setVideo(VideoDTO video) {
        this.video = video;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

}
