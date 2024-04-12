package ru.isaev.cats.rest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.isaev.cats.rest.Entities.CatDtos.CatDto;
import ru.isaev.cats.rest.Entities.Cats.Cat;
import ru.isaev.cats.rest.Entities.Cats.CatColors;
import ru.isaev.cats.rest.Entities.Mapper.IMyMapper;
import ru.isaev.cats.rest.Service.CatService;

import java.util.List;
import java.util.Set;

@RestController
public class CatController {
    private final CatService catService;

    private final IMyMapper mapper;

    @Autowired
    public CatController(CatService catService, IMyMapper mapper) {
        this.catService = catService;
        this.mapper = mapper;
    }

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

//    @GetMapping("/cats")
//    public List<Cat> getAll() {
//        return catService.getAllCats();
//    }

//    @GetMapping("/cats/{id}")
//    public Cat getCatById(@PathVariable Long id) {
//        return catService.getCatById(id).get();
//    }

    @GetMapping("/cats/{id}")
    public ResponseEntity<CatDto> getCatById(@PathVariable Long id) {
        return new ResponseEntity<>(
                mapper.catToCatDto(catService.getCatById(id).get()),
                HttpStatus.OK
        );
    }

    @GetMapping("/cats/{color}")
    @RequestMapping("enummapping")
    public ResponseEntity<Set<CatDto>> getCatByColor(@PathVariable CatColors color) {

        return new ResponseEntity<>(
                mapper.catsSetToCatDtosSet(catService.getCatByColor(color)),
                HttpStatus.OK
        );
    }
}
