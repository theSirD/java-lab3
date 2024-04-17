package ru.isaev.cats.rest.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.isaev.cats.rest.Entities.Cats.Cat;
import ru.isaev.cats.rest.Entities.Cats.CatColors;

import java.util.List;
import java.util.Set;

public interface ICatDAO extends JpaRepository<Cat, Long> {
//    @Query("SELECT f FROM Cat f WHERE LOWER(f.color) = LOWER(:color)")
//    Cat findByColor(@Param("color") String color);
    List<Cat> findByColor(CatColors color);

    List<Cat> findByBreed(String breed);
}
