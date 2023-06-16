package com.dilarabedir.inventoryservice.business.concretes;

import com.dilarabedir.commonpackage.utils.dtoConverter.DtoConverterService;
import com.dilarabedir.inventoryservice.business.abstracts.ProductService;
import com.dilarabedir.inventoryservice.business.dto.requests.create.CreateProductRequest;
import com.dilarabedir.inventoryservice.business.dto.requests.update.UpdateProductRequest;
import com.dilarabedir.inventoryservice.business.dto.responses.create.CreateProductResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.get.product.GetAllProductsResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.get.product.GetProductResponse;
import com.dilarabedir.inventoryservice.business.dto.responses.update.UpdateProductResponse;
import com.dilarabedir.inventoryservice.business.rules.ProductBusinessRules;
import com.dilarabedir.inventoryservice.entities.Product;
import com.dilarabedir.inventoryservice.entities.enums.State;
import com.dilarabedir.inventoryservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService {
    private final ProductRepository repository;
    private final DtoConverterService dtoConverterService;
    private final ProductBusinessRules rules;

    @Override
    public List<GetAllProductsResponse> getAll(boolean includePassive) {
        var products = filterProductsByPassiveState(includePassive);
        return dtoConverterService.toListDto(products, GetAllProductsResponse.class);
    }

    @Override
    public GetProductResponse getById(UUID id) {
        rules.checkIfProductExists(id);
        var product = repository.findById(id).orElseThrow();
        return dtoConverterService.toDto(product, GetProductResponse.class);
    }

    @Override
    public CreateProductResponse add(CreateProductRequest request) {
        var product = dtoConverterService.toEntity(request, Product.class);
        product.setId(null);
        var createProduct = repository.save(product);
        return dtoConverterService.toDto(createProduct, CreateProductResponse.class);
    }

    @Override
    public UpdateProductResponse update(UUID id, UpdateProductRequest request) {
        rules.checkIfProductExists(id);
        var product = dtoConverterService.toEntity(request, Product.class);
        product.setId(id);
        var updateProduct = repository.save(product);
        return dtoConverterService.toDto(updateProduct, UpdateProductResponse.class);
    }

    @Override
    public void delete(UUID id) {
        rules.checkIfProductExists(id);
    }

    @Override
    public void changeProductState(UUID id, State state){
        rules.checkIfProductExists(id);
        var product =repository.findById(id).orElseThrow();
        product.setState(state);
        repository.save(product);
    }

    private List<Product> filterProductsByPassiveState(boolean includePassive) {
        if (includePassive) {
            return repository.findAll();
        }
        return repository.findAllByStateIsNot(State.PASSIVE);
    }
}
