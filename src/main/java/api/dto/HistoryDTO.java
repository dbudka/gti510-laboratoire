package api.dto;

import java.util.Date;
import core.entity.AbstractEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class HistoryDTO extends AbstractEntity {

    private Integer id;

    private Integer userId;

    private Integer videoId;

    // used for storing the date the video has been viewed by the user and sorting them
    private Date dateViewed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Date getDateViewed() {
        return dateViewed;
    }

    public void setDateViewed(Date date) {
        this.dateViewed = date;
    }
}
