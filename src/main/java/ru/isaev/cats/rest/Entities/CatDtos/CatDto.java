package ru.isaev.cats.rest.Entities.CatDtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.isaev.cats.rest.Entities.Cats.Cat;
import ru.isaev.cats.rest.Entities.Cats.CatColors;

import java.util.HashSet;
import java.util.Set;

public class CatDto {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("ownerId")
    private Long ownerId;

    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("color")
    private CatColors color;

    @JsonProperty("breed")
    private String breed;

    @JsonProperty("idsOfFriendsList")
    private Set<Long> friends;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long owner_id) {
        this.ownerId = owner_id;
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

    public Set<Long> getFriends() {
        return friends;
    }

    public void setFriends(Set<Long> friends) {
        this.friends = friends;
    }
}