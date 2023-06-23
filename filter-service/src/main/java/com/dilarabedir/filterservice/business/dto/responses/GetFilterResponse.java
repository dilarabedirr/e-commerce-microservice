package com.dilarabedir.filterservice.business.dto.responses;

import com.dilarabedir.commonpackage.utils.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetFilterResponse implements BaseDto {
    private UUID id;
    private UUID productId;
    private UUID categoryId;
    private String productName;
    private String categoryName;
    private double price;
    private int quantity;
    private String state;
}
