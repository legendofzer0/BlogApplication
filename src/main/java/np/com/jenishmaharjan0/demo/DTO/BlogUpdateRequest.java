package np.com.jenishmaharjan0.demo.DTO;

import java.util.List;

public class BlogUpdateRequest {
    private String title;
    private String content;
    private String slug;
    private List<String> tag;

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
}
