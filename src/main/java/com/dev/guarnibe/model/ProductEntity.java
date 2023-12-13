package com.dev.guarnibe.model;

import com.dev.guarnibe.model.enums.CategoryTypes;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "TB_PRODUCT")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "requests")
    private Integer requests;

    @Column(name = "available")
    private boolean available;

    @Embedded
    private CreateAndUpdateEntity dateTime;

    @ManyToMany(mappedBy = "products")
    private List<CategoryEntity> category;

    @ManyToMany(mappedBy = "products")
    private List<IngredientEntity> ingredient;

    @ManyToMany(mappedBy = "products")
    private List<OrderEntity> order;

    @PrePersist
    private void initializeCreateAndUpdate(){
        this.dateTime = new CreateAndUpdateEntity();
    }
}
