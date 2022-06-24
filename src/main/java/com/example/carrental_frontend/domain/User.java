package com.example.carrental_frontend.domain;

import javax.persistence.*;
import java.util.List;


@Entity()

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    private String surname;

    private String lastname;

    private String login;

    private String password;

    private String mail;

    private String phone;


    private boolean isActive;

    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Rent> rentList;

    public Long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<Rent> getRentList() {
        return rentList;
    }
}
