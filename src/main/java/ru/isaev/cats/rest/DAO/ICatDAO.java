package ru.isaev.cats.rest.DAO;

import ru.isaev.cats.rest.Entities.Cats.Cat;

import java.util.List;

public interface ICatDAO {
    void add(Cat cat);

    List<Cat> getAll();

    Cat getById(Long Id);

    void update(Cat cat);

    void remove(Cat cat);
}
