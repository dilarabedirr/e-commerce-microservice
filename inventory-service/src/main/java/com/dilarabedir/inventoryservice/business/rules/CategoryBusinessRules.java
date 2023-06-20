package com.dilarabedir.inventoryservice.business.rules;

import com.dilarabedir.commonpackage.utils.constants.Messages;
import com.dilarabedir.inventoryservice.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryBusinessRules {
    private final CategoryRepository repository;

    public void checkIfCategoryExists(UUID id){
        if (!repository.existsById(id)){
            throw new RuntimeException(Messages.Category.NotExists);
        }
    }
}
