package com.dilarabedir.inventoryservice.business.dto.responses.get;

import com.dilarabedir.commonpackage.utils.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoryToProductResponse implements BaseDto {
    private String name;
}
