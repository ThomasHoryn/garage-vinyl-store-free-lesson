package com.tomhor.garagevinylstore.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Podaj autora")
    @Size(min = 2, max = 200, message = "nazwa autora powinna zawierać między 2 a 200 znaków")
    private String name;

    @ManyToMany
    @JoinTable(name = "AUTHOR_VINYL",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "vinyl_id"))
    private List<Vinyl> vinyls = new ArrayList<>();
}
