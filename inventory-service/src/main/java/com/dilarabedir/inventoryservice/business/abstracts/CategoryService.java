package com.dilarabedir.inventoryservice.business.abstracts;

import com.dilarabedir.inventoryservice.business.dto.requests.create.CreateCategoryRequest;
import com.dilarabedir.inventoryservice.business.dto.requests.update.UpdateCategoryRequest;
import com.dilarabedir.inventoryservice.business.dto.responses.create.CreateCategoryResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.get.category.GetAllCategoriesResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.get.category.GetCategoryResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.update.UpdateCategoryResponse;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<GetAllCategoriesResponse> getAll();
    GetCategoryResponse getById(UUID id);
    CreateCategoryResponse add(CreateCategoryRequest request);
    UpdateCategoryResponse update(UUID id, UpdateCategoryRequest request);
    void delete(UUID id);
}
