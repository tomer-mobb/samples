package app;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExampleController {
    // http://localhost:8888/echo?text=%3Cscript%3Ealert(1)%3C/script%3E
    @GetMapping("/echo")
    public ResponseEntity<String> echo(@RequestParam("text") String text) {
        return ResponseEntity.ok("a" + text + "b");
    }
}
