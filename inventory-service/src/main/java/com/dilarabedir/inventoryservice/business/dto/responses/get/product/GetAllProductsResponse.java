package com.dilarabedir.inventoryservice.business.dto.responses.get.product;

import com.dilarabedir.commonpackage.utils.dto.BaseDto;
import com.dilarabedir.inventoryservice.business.dto.responses.get.GetCategoryToProductResponse;
import com.dilarabedir.inventoryservice.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductsResponse implements BaseDto {
    private UUID id;
    private String name;
    private int quantity;
    private double price;
    private String description;
    private State state;
    private List<GetCategoryToProductResponse> categories;
}
