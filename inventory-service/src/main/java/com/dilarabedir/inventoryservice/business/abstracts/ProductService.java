package com.dilarabedir.inventoryservice.business.abstracts;

import com.dilarabedir.inventoryservice.business.dto.requests.create.CreateProductRequest;
import com.dilarabedir.inventoryservice.business.dto.requests.update.UpdateProductRequest;
import com.dilarabedir.inventoryservice.business.dto.responses.create.CreateProductResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.get.product.GetAllProductsResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.get.product.GetProductResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.update.UpdateProductResponse;
import com.dilarabedir.inventoryservice.entities.enums.State;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<GetAllProductsResponse> getAll(boolean includePassive);
    GetProductResponse getById(UUID id);
    CreateProductResponse add(CreateProductRequest request);
    UpdateProductResponse update(UUID id, UpdateProductRequest request);
    void delete(UUID id);
    void changeProductState(UUID id, State state);
}
