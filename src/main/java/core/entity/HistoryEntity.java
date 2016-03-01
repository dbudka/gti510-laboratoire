package core.entity;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "history")
public class HistoryEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "userId")
    private Integer userId;

    @Column(name = "videoId")
    private Integer videoId;

    @Column(name = "dateViewed")
    private Date dateViewed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() { return userId; }

    public void setUserId(Integer user) {
        this.userId = user;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer video) {
        this.videoId = video;
    }

    public Date getDateViewed() {
        return dateViewed;
    }

    public void setDateViewed(Date date) {
        this.dateViewed = date;
    }
}
