package np.com.jenishmaharjan0.demo.Service;

import np.com.jenishmaharjan0.demo.DTO.BlogRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlogService {
    private List<BlogRequest> DATA = new ArrayList<BlogRequest>();
    public void  create (@RequestBody BlogRequest blogRequest) {
        DATA.add(blogRequest);
    }
    public List<BlogRequest> getData () {
        return DATA;
    }
}
