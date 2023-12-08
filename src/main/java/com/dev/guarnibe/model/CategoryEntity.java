package com.dev.guarnibe.model;


import com.dev.guarnibe.model.enums.CategoryTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "CATEGORY")
public class CategoryEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private CreateAndUpdateEntity dateTime;

    private CategoryTypes category;

    @PrePersist
    private void initializerCreateAndUpdate(){
        this.dateTime = new CreateAndUpdateEntity();
    }
}
