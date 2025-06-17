package np.com.jenishmaharjan0.demo.Service;

import np.com.jenishmaharjan0.demo.DTO.BlogCreateRequest;
import np.com.jenishmaharjan0.demo.DTO.BlogUpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {
    private static Logger log = LoggerFactory.getLogger(BlogService.class);

    private List<BlogCreateRequest> DATA = new ArrayList<BlogCreateRequest>();
    public void  create (@RequestBody BlogCreateRequest blogRequest) {
        log.debug("Creating blog : {}", blogRequest);
        DATA.add(blogRequest);
    }
    public List<BlogCreateRequest> getData () {
        return DATA;
    }

    public Optional<BlogCreateRequest> findById(Long id) {
    Optional<BlogCreateRequest> blogOpt = Optional.empty();
    for(BlogCreateRequest blog : DATA) {
        if(blog.getId().equals(id)) {
            blogOpt = Optional.of(blog);
        }
    }
    return blogOpt;
    }

    public String updateById(Long id, BlogUpdateRequest request) {
     for(BlogCreateRequest blog : DATA) {
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
        List<BlogCreateRequest> data = DATA;
        data.removeIf(blog -> blog.getId().equals(id));
        return "Data Deleted Successfully";
    }
}
