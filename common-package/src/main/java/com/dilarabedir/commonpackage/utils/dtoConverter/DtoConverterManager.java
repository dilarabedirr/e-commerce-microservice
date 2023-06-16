package com.dilarabedir.commonpackage.utils.dtoConverter;

import com.dilarabedir.commonpackage.utils.dto.BaseDto;
import com.dilarabedir.commonpackage.utils.dto.BaseEntity;
import com.dilarabedir.commonpackage.utils.mappers.ModelMapperService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DtoConverterManager implements DtoConverterService {
    private final ModelMapperService mapper;

    @Override
    public <T extends BaseEntity, S extends BaseDto> T toEntity(S dto, Class<T> entity) {
        return mapper.forRequest().map(dto, entity);
    }

    @Override
    public <S extends BaseDto, T extends BaseEntity> S toDto(T entity, Class<S> dto) {
        return mapper.forResponse().map(entity, dto);
    }

    @Override
    public <S extends BaseDto, T extends BaseEntity> List<S> toListDto(List<T> entities, Class<S> dto) {
        return entities.stream()
                .map(entity -> toDto(entity, dto))
                .toList();
    }
}
