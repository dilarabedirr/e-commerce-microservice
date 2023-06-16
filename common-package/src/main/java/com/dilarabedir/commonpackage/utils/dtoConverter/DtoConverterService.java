package com.dilarabedir.commonpackage.utils.dtoConverter;

import com.dilarabedir.commonpackage.utils.dto.BaseDto;
import com.dilarabedir.commonpackage.utils.dto.BaseEntity;

import java.util.List;

public interface DtoConverterService {
    <T extends BaseEntity, S extends BaseDto> T toEntity(S dto, Class<T> entity);

    <S extends BaseDto, T extends BaseEntity> S toDto(T entity, Class<S> dto);

    <S extends BaseDto, T extends BaseEntity> List<S> toListDto(List<T> entity, Class<S> dto);
}
