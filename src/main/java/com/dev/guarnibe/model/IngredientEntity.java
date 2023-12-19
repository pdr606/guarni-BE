package com.dev.guarnibe.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "TB_INGREDIENT")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class IngredientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Embedded
    private CreateAndUpdateEntity dateTime;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "ingredient")
    @JsonIgnore
    private List<ProductEntity> products;

    @PrePersist
    private void initializeCreateAndUpdate(){
        this.dateTime = new CreateAndUpdateEntity();
    }
}
