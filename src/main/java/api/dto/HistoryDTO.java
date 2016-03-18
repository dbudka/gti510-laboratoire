package api.dto;

import java.util.Date;

public class HistoryDTO extends AbstractDTO {

    private Integer id;

    private UserDTO user;

    private VideoDTO video;

    // used for storing the date the video has been viewed by the user and sorting them
    private Date dateViewed;

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

    public VideoDTO getVideo() {
        return video;
    }

    public void setVideo(VideoDTO video) {
        this.video = video;
    }

    public Date getDateViewed() {
        return dateViewed;
    }

    public void setDateViewed(Date dateViewed) {
        this.dateViewed = dateViewed;
    }
}
