package ru.isaev.cats.rest.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.isaev.cats.rest.Entities.Cats.Cat;
import ru.isaev.cats.rest.Entities.Owners.Owner;

import java.util.List;

public interface IOwnerDAO extends JpaRepository<Owner, Long> {
}
