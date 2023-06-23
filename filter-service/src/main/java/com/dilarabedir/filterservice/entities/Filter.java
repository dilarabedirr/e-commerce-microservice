package com.dilarabedir.filterservice.entities;

import com.dilarabedir.commonpackage.utils.dto.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Filter implements BaseEntity {
    @Id
    private String id;
    private UUID productId;
    private UUID categoryId;
    private String productName;
    private String categoryName;
    private double price;
    private int quantity;
    private String state;
}
