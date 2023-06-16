package com.dilarabedir.commonpackage.configurations.mappers;

import com.dilarabedir.commonpackage.utils.dtoConverter.DtoConverterManager;
import com.dilarabedir.commonpackage.utils.dtoConverter.DtoConverterService;
import com.dilarabedir.commonpackage.utils.mappers.ModelMapperManager;
import com.dilarabedir.commonpackage.utils.mappers.ModelMapperService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @Bean
    public ModelMapperService getModelMapperService(ModelMapper mapper) {
        return new ModelMapperManager(mapper);
    }

    @Bean
    public DtoConverterService getDtoConverterService(ModelMapperService modelMapperService) {
        return new DtoConverterManager(modelMapperService);
    }
}