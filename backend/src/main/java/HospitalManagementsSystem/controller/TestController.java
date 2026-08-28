package HospitalManagementsSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String testApi() {
        return "Hospital Management System Backend Running Successfully!";
    }
}