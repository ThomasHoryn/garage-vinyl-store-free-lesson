package com.tomhor.garagevinylstore.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Vinyl> vinyls;
}
