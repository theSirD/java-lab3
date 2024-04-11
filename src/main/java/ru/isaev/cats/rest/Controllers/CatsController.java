package ru.isaev.cats.rest.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.isaev.cats.rest.Entities.Cats.Cat;

import java.util.List;

@RestController
public class CatsController {
    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/cats")
    public List<Cat> getAll() {

    }

    @GetMapping("/cats/{id}")
    public Cat getCatById(@PathVariable String id) {

    }
}
