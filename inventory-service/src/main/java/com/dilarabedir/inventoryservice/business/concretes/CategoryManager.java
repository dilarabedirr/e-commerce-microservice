package com.dilarabedir.inventoryservice.business.concretes;

import com.dilarabedir.commonpackage.utils.dtoConverter.DtoConverterService;
import com.dilarabedir.inventoryservice.business.abstracts.CategoryService;
import com.dilarabedir.inventoryservice.business.dto.requests.create.CreateCategoryRequest;
import com.dilarabedir.inventoryservice.business.dto.requests.update.UpdateCategoryRequest;
import com.dilarabedir.inventoryservice.business.dto.responses.create.CreateCategoryResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.get.category.GetAllCategoriesResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.get.category.GetCategoryResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.update.UpdateCategoryResponse;
import com.dilarabedir.inventoryservice.business.rules.CategoryBusinessRules;
import com.dilarabedir.inventoryservice.entities.Category;
import com.dilarabedir.inventoryservice.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryRepository repository;
    private final DtoConverterService dtoConverterService;
    private final CategoryBusinessRules rules;

    @Override
    public List<GetAllCategoriesResponse> getAll() {
        var categories = repository.findAll();
        return dtoConverterService.toListDto(categories, GetAllCategoriesResponse.class);
    }

    @Override
    public GetCategoryResponse getById(UUID id) {
        rules.checkIfCategoryExists(id);
        var category = repository.findById(id).orElseThrow();
        return dtoConverterService.toDto(category, GetCategoryResponse.class);
    }

    @Override
    public CreateCategoryResponse add(CreateCategoryRequest request) {
        var category = dtoConverterService.toEntity(request, Category.class);
        category.setId(null);
        var createCategory = repository.save(category);
        return dtoConverterService.toDto(createCategory, CreateCategoryResponse.class);
    }

    @Override
    public UpdateCategoryResponse update(UUID id, UpdateCategoryRequest request) {
        rules.checkIfCategoryExists(id);
        var category = dtoConverterService.toEntity(request, Category.class);
        category.setId(id);
        var updateCategory = repository.save(category);
        return dtoConverterService.toDto(updateCategory, UpdateCategoryResponse.class);
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfCategoryExists(id);
        repository.deleteById(id);
    }
}
