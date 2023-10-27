package app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    // http://localhost:8080/?ip=127.0.0.1;whoami
    @GetMapping("/")
    public String HelloWorld(@RequestParam String ip) {
        var pingAction = new app.PingAction();
        pingAction.setAddress(ip);
        pingAction.execute();
        return pingAction.getCommandOutput();
    }
}
