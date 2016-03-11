package api.dto;

public class VideoDTO extends AbstractDTO {

    private Integer id;

    private String name;

    private String url;

    private String pic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPic() { return pic; }

    public void setPic(String pic) { this.pic = pic; }
}