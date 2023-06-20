package com.dilarabedir.inventoryservice.business.dto.requests.create;


import com.dilarabedir.commonpackage.utils.dto.BaseDto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryRequest implements BaseDto {
    @NotBlank
    private String name;
}
