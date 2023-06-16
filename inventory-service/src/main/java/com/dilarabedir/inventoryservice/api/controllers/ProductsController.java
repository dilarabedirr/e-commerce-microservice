package com.dilarabedir.inventoryservice.api.controllers;

import com.dilarabedir.inventoryservice.business.abstracts.ProductService;
import com.dilarabedir.inventoryservice.business.dto.requests.create.CreateProductRequest;
import com.dilarabedir.inventoryservice.business.dto.requests.update.UpdateProductRequest;
import com.dilarabedir.inventoryservice.business.dto.responses.create.CreateProductResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.get.product.GetAllProductsResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.get.product.GetProductResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.update.UpdateProductResponse;
import com.dilarabedir.inventoryservice.entities.enums.State;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsController {
    private final ProductService service;

    @GetMapping
    public List<GetAllProductsResponse> getAll(@RequestParam(defaultValue = "true") boolean includePassive){
        return service.getAll(includePassive);
    }

    @GetMapping("/{id}")
    public GetProductResponse getById(@PathVariable UUID id){
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponse add(@Valid @RequestBody CreateProductRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateProductResponse update(@PathVariable UUID id, @Valid @RequestBody UpdateProductRequest request) {
        return service.update(id, request);
    }

    @PutMapping("/{id}/state")
    public void changeProductState(@PathVariable UUID id, @RequestBody State state) {
        service.changeProductState(id, state);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
