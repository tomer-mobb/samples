package app;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

@Controller
public class ExampleController {
    @GetMapping("/pt/picture")
    @ResponseBody
    public ResponseEntity<?> getProfilePicture(HttpServletRequest request) {
        var name = request.getParameter("name");
        var catPicturesDirectory = "/tmp/cats";
        var catPicture = new File(catPicturesDirectory, name);

        try {
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(MediaType.IMAGE_JPEG_VALUE))
                    .body(Base64.getEncoder().encode(FileCopyUtils.copyToByteArray(catPicture)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.badRequest().build();
    }
}
