import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pt")
class Z {
    @GetMapping("/example")
    public String example(@RequestParam(required = false) String username) {
        try {
            String fileName = "data/" + username + ".json";
//          FIX:
//          String fileName = "data/" + String.valueOf(username).replaceAll("([/\\\\:*?\"<>|])|(^\\s)|([.\\s]$)", "_") + ".json";
            ClassPathResource resource = new ClassPathResource(fileName);
            byte[] data = FileCopyUtils.copyToByteArray(resource.getInputStream());
            return new String(data);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred";
        }
    }
}
