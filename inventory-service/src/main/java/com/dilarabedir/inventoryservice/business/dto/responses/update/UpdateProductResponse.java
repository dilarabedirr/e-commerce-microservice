package com.dilarabedir.inventoryservice.business.dto.responses.update;

import com.dilarabedir.commonpackage.utils.dto.BaseDto;
import com.dilarabedir.inventoryservice.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductResponse implements BaseDto {
    private UUID id;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private State state;
    // TODO: add category
}