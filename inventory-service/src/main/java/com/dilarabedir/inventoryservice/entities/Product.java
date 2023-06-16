package com.dilarabedir.inventoryservice.entities;

import com.dilarabedir.commonpackage.utils.dto.BaseEntity;
import com.dilarabedir.inventoryservice.entities.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "products")
public class Product implements BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private int quantity;
    private double price;
    @Enumerated(EnumType.STRING)
    private State state;
    private String description;
}
