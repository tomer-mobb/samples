package app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController2 {
    // http://localhost:8888/two/%3Cbody%20onload=%22alert(1)%22%3E
    @GetMapping("/two/{id}")
    @ResponseBody
    public String two(@PathVariable String id) {
        return id;
    }
}
