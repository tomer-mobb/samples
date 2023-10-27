package app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ExampleController2 {

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("f") MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            return "no";
        }
        Path path = Paths.get("/tmp/upload/" + file.getOriginalFilename());
//      FIX:
//      Path path = Paths.get("/tmp/upload/" + String.valueOf(file.getOriginalFilename()).replaceAll("([/\\\\:*?\"<>|])|(^\\s)|([.\\s]$)", "_"));
        Files.write(path, file.getBytes());
        return "ok";
    }
}
