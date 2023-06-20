package com.dilarabedir.inventoryservice.business.dto.responses.create;

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
public class CreateCategoryResponse implements BaseDto {
    private UUID id;
    private String name;
}

