package np.com.jenishmaharjan0.demo.Controller;

import np.com.jenishmaharjan0.demo.DTO.BlogRequest;
import np.com.jenishmaharjan0.demo.DTO.BlogUpdateRequest;
import np.com.jenishmaharjan0.demo.Service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping()
    public List<BlogRequest> getBlog() {
        return this.blogService.getData();
    }
    @PostMapping
    public String postBlog(@RequestBody BlogRequest  request) {
       this.blogService.create(request);
        return "Data Inserted";
    }

    @GetMapping("{id}")
    Optional<BlogRequest> getBlogById(@PathVariable Long id) {
        return this.blogService.findById(id);
    }

    @PutMapping("{id}")
    String updateBlog(@PathVariable Long id, @RequestBody BlogUpdateRequest request) {
        return this.blogService.updateById(id,request);
    }
    @DeleteMapping("{id}")
    String deleteBlog(@PathVariable Long id) {
        return this.blogService.deleteById(id);
    }
}
