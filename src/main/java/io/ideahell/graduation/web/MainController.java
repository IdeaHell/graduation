package io.ideahell.graduation.web;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    ResponseEntity<String> home() {
        return ResponseEntity.ok("Hello World!");
    }
}
