package at.fhcampus.we.controller;

import at.fhcampus.we.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/hello-world")
public class HelloWorldController {

    @GetMapping({"", "/"})
    public List<User> exampleDataStructure() {
        return Collections.singletonList(
                User.builder()
                        .id(1L)
                        .firstName("John")
                        .lastName("Doe")
                        .password("$2a$10$VsL9Tjj1aJO8kIkLlBmvj.xB3RGODuzYMmos9XTQPCGFv9jpzNsKS")
                        .dateOfBirth(LocalDateTime.of(
                                1999,
                                Month.JANUARY,
                                1,
                                1,
                                0
                        ))
                        .build()
        );
    }
}
