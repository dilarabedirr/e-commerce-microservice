package com.dilarabedir.inventoryservice.business.dto.requests.create;

import com.dilarabedir.commonpackage.utils.dto.BaseDto;
import com.dilarabedir.inventoryservice.entities.enums.State;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest implements BaseDto {
    // TODO : category eklenecek
    @NotBlank
    private String name;
    @Min(1)
    private int quantity;
    @Min(1)
    private double price;
    private State state;
    @NotBlank
    @Length(min = 10, max = 50)
    private String description;
}