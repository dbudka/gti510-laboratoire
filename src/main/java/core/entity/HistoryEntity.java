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

    @ManyToOne
    @JoinColumn(name="userId")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name="videoId")
    private VideoEntity video;

    @Column(name = "dateViewed")
    private Date dateViewed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getDateViewed() {
        return dateViewed;
    }

    public void setDateViewed(Date date) {
        this.dateViewed = date;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public VideoEntity getVideo() {
        return video;
    }

    public void setVideo(VideoEntity video) {
        this.video = video;
    }
}
