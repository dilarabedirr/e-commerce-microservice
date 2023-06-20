package com.dilarabedir.inventoryservice.api.controllers;

import com.dilarabedir.inventoryservice.business.abstracts.CategoryService;
import com.dilarabedir.inventoryservice.business.dto.requests.create.CreateCategoryRequest;
import com.dilarabedir.inventoryservice.business.dto.requests.update.UpdateCategoryRequest;
import com.dilarabedir.inventoryservice.business.dto.responses.create.CreateCategoryResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.get.category.GetAllCategoriesResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.get.category.GetCategoryResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.update.UpdateCategoryResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoriesController {
    private final CategoryService service;

    @GetMapping
    public List<GetAllCategoriesResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetCategoryResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateCategoryResponse add(@Valid @RequestBody CreateCategoryRequest request) {
        return service.add(request);
    }

    @PutMapping("/{id}")
    public UpdateCategoryResponse update(@PathVariable UUID id, @Valid @RequestBody UpdateCategoryRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
