package ru.isaev.cats.rest.Entities.Owners;

import jakarta.persistence.*;
import ru.isaev.cats.rest.Entities.Cats.Cat;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "OWNER")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String first_name;

    private String last_name;

    private Date birthday;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cats_of_hosts",
            joinColumns = @JoinColumn(name = "host_id"),
            inverseJoinColumns = @JoinColumn(name = "cat_id")
    )
    private Set<Cat> catsList = new HashSet<>();

    public Owner() {
    }

    public Long getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Set<Cat> getCatsList() {
        return catsList;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String firstName) {
        this.first_name = firstName;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String lastName) {
        this.last_name = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void addCat(Cat cat, Boolean set) {
        if (cat != null) {
            catsList.add(cat);
        }
        if (set) {
            cat.setOwner(this, false);
        }
    }
}
