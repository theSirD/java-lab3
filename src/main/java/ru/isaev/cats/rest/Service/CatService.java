package ru.isaev.cats.rest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.isaev.cats.rest.DAO.ICatDAO;
import ru.isaev.cats.rest.Entities.Cats.Cat;

import java.util.List;
import java.util.Optional;

@Service
public class CatService {
    private final ICatDAO catDAO;

    @Autowired
    public CatService(ICatDAO catDAO) {
        this.catDAO = catDAO;
    }

    public void addCat(Cat cat) {
//        catDAO.add(cat);
        catDAO.save(cat);
    }

    public List<Cat> getAllCats() {
//        return catDAO.getAll();
        return catDAO.findAll();
    }

    public Optional<Cat> getCatById(Long id) {
//        return catDAO.getById(id);
        return catDAO.findById(id);
    }

    public void updateCat(Cat cat) {
//        catDAO.update(cat);
        catDAO.save(cat);
    }

    public void removeCat(Cat cat) {
//        catDAO.remove(cat);
        catDAO.delete(cat);
    }
}
