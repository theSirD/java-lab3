package ru.isaev.cats.rest.Entities.Mapper;

import ru.isaev.cats.rest.Entities.CatDtos.CatDto;
import ru.isaev.cats.rest.Entities.Cats.Cat;
import ru.isaev.cats.rest.Entities.OwnerDtos.OwnerDto;
import ru.isaev.cats.rest.Entities.Owners.Owner;

import java.util.Set;

public interface IMyMapper {
    CatDto catToCatDto(Cat cat);

    Set<CatDto> catsSetToCatDtosSet(Set<Cat> setOfCats);

    OwnerDto ownerToOwnerDto(Owner book);
}