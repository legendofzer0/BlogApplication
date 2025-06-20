package np.com.jenishmaharjan0.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter
@Setter
public class BlogUpdateRequest {
    @NotBlank(message = "Title is Required")
    @Length(max = 100)
    private String title;
    @NotBlank(message = "Content is Required")
    private String content;
    @NotBlank
    private String slug;
    @NotEmpty
    private List<@NotBlank String> tag;

}
