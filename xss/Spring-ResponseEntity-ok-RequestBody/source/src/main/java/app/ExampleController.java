package app;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
public class ExampleController {
    // curl -X POST -d '{"id": "<script>alert(1)</script>"}' -H "Content-Type: application/json" localhost:8888/two
    @PostMapping("/two")
    ResponseEntity<String> two(@RequestBody Map<String, Object> content) {
        return ResponseEntity.ok(content.get("id").toString());
    }
}
