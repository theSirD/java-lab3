package ru.isaev.cats.rest.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.isaev.cats.rest.Entities.Mapper.IMyMapper;
import ru.isaev.cats.rest.Entities.OwnerDtos.OwnerDto;
import ru.isaev.cats.rest.Entities.Owners.Owner;
import ru.isaev.cats.rest.Service.OwnerService;

import java.util.List;

@RestController
@RequestMapping("/owner")
public class OwnerController {
    private final OwnerService ownerService;

    private final IMyMapper mapper;

    @Autowired
    public OwnerController(OwnerService ownerService, IMyMapper mapper) {
        this.ownerService = ownerService;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDto> getById(@PathVariable Long id) {
        return new ResponseEntity<>(
                mapper.ownerToOwnerDto(ownerService.getOwnerById(id).get()),
                HttpStatus.OK
        );
    }

    @GetMapping("/name")
    public ResponseEntity<List<OwnerDto>> getByColor(@RequestParam(name = "name", required = false) String name) {
        return new ResponseEntity<>(
                mapper.mapListOfOwnersToListOfDtos(ownerService.getOwnersByName(name)),
                HttpStatus.OK
        );
    }

    @PostMapping("/add")
    public ResponseEntity<String> addOwner(@RequestBody OwnerDto ownerDto) {
        Owner owner = mapper.ownerDtoToOwner(ownerDto);
        ownerService.addOwner(owner);

        return ResponseEntity.status(HttpStatus.CREATED).body("Owner was added");
    }

    @PostMapping("/add")
    public ResponseEntity<String> editOwner(@RequestBody OwnerDto ownerDto) {
        Owner owner = mapper.ownerDtoToOwner(ownerDto);
        ownerService.updateOwner(owner);

        return ResponseEntity.status(HttpStatus.CREATED).body("Owner was edited");
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<String> deleteOwnerById(@PathVariable Long id) {
        ownerService.removeOwnerById(id);

        return ResponseEntity.status(HttpStatus.CREATED).body("Owner was deleted");
    }
}

