package com.dilarabedir.inventoryservice.business.rules;

import com.dilarabedir.commonpackage.utils.constants.Messages;
import com.dilarabedir.inventoryservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductBusinessRules {
    private final ProductRepository repository;

    public void checkIfProductExists(UUID id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException(Messages.Product.NotExists);
        }
    }
}
