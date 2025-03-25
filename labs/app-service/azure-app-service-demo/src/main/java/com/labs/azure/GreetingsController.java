package com.labs.azure;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;

@RestController
public class GreetingsController {

    @GetMapping("/greetings")
    public String greetings() {
        // get current server time
         return "Hello from Azure App Service!!! " + java.time.LocalDateTime.now();
    }
}
