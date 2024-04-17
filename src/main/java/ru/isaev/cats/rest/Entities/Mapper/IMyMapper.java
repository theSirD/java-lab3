package ru.isaev.cats.rest.Entities.Mapper;

import ru.isaev.cats.rest.Entities.CatDtos.CatDto;
import ru.isaev.cats.rest.Entities.CatDtos.CatDtoInput;
import ru.isaev.cats.rest.Entities.Cats.Cat;
import ru.isaev.cats.rest.Entities.OwnerDtos.OwnerDto;
import ru.isaev.cats.rest.Entities.Owners.Owner;

import java.util.List;
import java.util.Set;

public interface IMyMapper {
    CatDto catToCatDto(Cat cat);

    List<CatDto> mapListOfCatsToListOfDtos(List<Cat> listOfCats);

    Cat catDtoInputToCat(CatDtoInput catDtoInput);

//    List<Cat> mapListOfDtosToListOfCats(List<CatDto> listOfCats);

//    OwnerDto ownerToOwnerDto(Owner owner);
}