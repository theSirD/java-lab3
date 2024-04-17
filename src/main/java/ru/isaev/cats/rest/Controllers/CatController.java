package ru.isaev.cats.rest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isaev.cats.rest.Entities.CatDtos.CatDto;
import ru.isaev.cats.rest.Entities.CatDtos.CatDtoInput;
import ru.isaev.cats.rest.Entities.Cats.Cat;
import ru.isaev.cats.rest.Entities.Cats.CatColors;
import ru.isaev.cats.rest.Entities.Mapper.IMyMapper;
import ru.isaev.cats.rest.Service.CatService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cats")
public class CatController {
    private final CatService catService;

    private final IMyMapper mapper;

    @Autowired
    public CatController(CatService catService, IMyMapper mapper) {
        this.catService = catService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(
                mapper.catToCatDto(catService.getCatById(id).get()),
                HttpStatus.OK
        );
    }

    @GetMapping("/color")
    public ResponseEntity<List<CatDto>> getByColor(@RequestParam(name = "color", required = false) CatColors color) {
        return new ResponseEntity<>(
                mapper.mapListOfCatsToListOfDtos(catService.getCatsByColor(color)),
                HttpStatus.OK
        );
    }

    @GetMapping("/breed")
    public ResponseEntity<List<CatDto>> getByBreed(@RequestParam(name = "breed", required = false) String breed) {
        return new ResponseEntity<>(
                mapper.mapListOfCatsToListOfDtos(catService.getCatsByBreed(breed)),
                HttpStatus.OK
        );
    }

    @PostMapping("/add")
    public ResponseEntity<String> addCat(@RequestBody CatDtoInput catDtoInput) {
        //{"id":1,"birthday":"3100-10-04","color":"Red","breed":"breed3"}
        Cat cat = mapper.catDtoInputToCat(catDtoInput);
        catService.addCat(cat);

        return ResponseEntity.status(HttpStatus.CREATED).body("Cat was added");
    }
}

