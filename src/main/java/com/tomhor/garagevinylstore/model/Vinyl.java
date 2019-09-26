package com.tomhor.garagevinylstore.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Data
public class Vinyl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, max = 200, message = "nazwa powinna zawierać między 2 a 200 znaków")
    private String name;

    @NotNull(message = "podaj wartość większą od 0, minimum 1 grosz")
    @DecimalMin(value = "0.01", message = "podaj wartość płyty większą od 0")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn
    private Author author;
}
