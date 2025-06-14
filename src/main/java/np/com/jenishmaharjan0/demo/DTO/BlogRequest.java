package np.com.jenishmaharjan0.demo.DTO;

import java.util.List;

public class BlogRequest {
    private Long id;
    private String title;
    private String content;
    private String slug;
    private List<String> tag;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getSlug() {
        return slug;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }
}
