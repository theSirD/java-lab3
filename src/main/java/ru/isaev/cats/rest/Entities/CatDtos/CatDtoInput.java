package ru.isaev.cats.rest.Entities.CatDtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.isaev.cats.rest.Entities.Cats.CatColors;

public class CatDtoInput {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("color")
    private CatColors color;

    @JsonProperty("breed")
    private String breed;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public CatColors getColor() {
        return color;
    }

    public void setColor(CatColors color) {
        this.color = color;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

}