package ru.isaev.cats.rest.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.isaev.cats.rest.Entities.Cats.Cat;

import java.util.List;

public interface ICatDAO extends JpaRepository<Cat, Long> {
//    void add(Cat cat);
//
//    List<Cat> getAll();
//
//    Cat getById(Long Id);
//
//    void update(Cat cat);
//
//    void remove(Cat cat);
}
