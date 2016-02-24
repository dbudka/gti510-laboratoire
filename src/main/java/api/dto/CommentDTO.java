package api.dto;

import java.util.Date;

public class CommentDTO extends AbstractDTO {

    private String comment;

    private UserDTO user;

    private VideoDTO video;

    private Date postDate;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
}
