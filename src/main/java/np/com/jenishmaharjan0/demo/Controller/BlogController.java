package np.com.jenishmaharjan0.demo.Controller;

import jakarta.validation.Valid;
import np.com.jenishmaharjan0.demo.DTO.BlogCreateRequest;
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
    public List<BlogCreateRequest> getBlog() {
        return this.blogService.getData();
    }
    @PostMapping
    public String postBlog(@RequestBody @Valid BlogCreateRequest request) {
       this.blogService.create(request);
        return "Data Inserted";
    }

    @GetMapping("{id}")
    Optional<BlogCreateRequest> getBlogById(@PathVariable Long id) {
        return this.blogService.findById(id);
    }

    @PutMapping("{id}")
    String updateBlog(@PathVariable @Valid Long id, @RequestBody @Valid BlogUpdateRequest request) {
        return this.blogService.updateById(id,request);
    }
    @DeleteMapping("{id}")
    String deleteBlog(@PathVariable Long id) {
        return this.blogService.deleteById(id);
    }
}
