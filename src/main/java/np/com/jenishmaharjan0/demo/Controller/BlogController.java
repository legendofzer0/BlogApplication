package np.com.jenishmaharjan0.demo.Controller;

import np.com.jenishmaharjan0.demo.DTO.BlogRequest;
import np.com.jenishmaharjan0.demo.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping()
    public List<BlogRequest> getBlog() {
        return blogService.getData();
    }
    @PostMapping
    public String postBlog(@RequestBody BlogRequest  request) {
       blogService.create(request);
        return "Data Inserted";
    }
}
