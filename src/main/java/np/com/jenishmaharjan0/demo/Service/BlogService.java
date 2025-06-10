package np.com.jenishmaharjan0.demo.Service;

import np.com.jenishmaharjan0.demo.DTO.BlogRequest;
import np.com.jenishmaharjan0.demo.DTO.BlogUpdateRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    private List<BlogRequest> DATA = new ArrayList<BlogRequest>();
    public void  create (@RequestBody BlogRequest blogRequest) {
        DATA.add(blogRequest);
    }
    public List<BlogRequest> getData () {
        return DATA;
    }

    public Optional<BlogRequest> findById(Long id) {
    Optional<BlogRequest> blogOpt = Optional.empty();
    for(BlogRequest blog : DATA) {
        if(blog.getId().equals(id)) {
            blogOpt = Optional.of(blog);
        }
    }
    return blogOpt;
    }

    public String updateById(Long id, BlogUpdateRequest request) {
     for(BlogRequest blog : DATA) {
        if(blog.getId().equals(id)) {
            blog.setTitle(request.getTitle());
            blog.setContent(request.getContent());
            blog.setSlug(request.getSlug() );
            blog.setTag(request.getTag());
        }
    }

        return "Data Updated Successfully";
    }

    public String deleteById(Long id) {
        List<BlogRequest> data = DATA;
        data.removeIf(blog -> blog.getId().equals(id));
        return "Data Deleted Successfully";
    }
}
