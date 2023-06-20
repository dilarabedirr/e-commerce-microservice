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

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest implements BaseDto {
    private List<UUID> categoryIds;
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
