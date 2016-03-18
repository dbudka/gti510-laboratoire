package core.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "favorites")
public class FavoritesEntity extends AbstractEntity {

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

    @Column(name = "dateAdded")
    private Date dateAdded;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}
