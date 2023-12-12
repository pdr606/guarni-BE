package com.dev.guarnibe.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Entity
@Table(name = "TB_ORDER")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tax_service")
    private Double taxService;

    @Column(name = "finished", columnDefinition = "false")
    @Value(value = "false")
    private boolean finished;

    @ManyToMany
    @JoinTable(
            name = "TB_PRODUCT_ORDER",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<ProductEntity> products;

    @OneToOne(mappedBy = "tablet", cascade = CascadeType.ALL)
    private TabletEntity tablet;

    @Embedded
    private CreateAndUpdateEntity dateTime;

    @PrePersist
    private void initializeCreateAndUpdate(){
        this.dateTime = new CreateAndUpdateEntity();
    }
}
