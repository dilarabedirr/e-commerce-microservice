package com.dilarabedir.filterservice.business.concretes;

import com.dilarabedir.commonpackage.utils.dtoConverter.DtoConverterService;
import com.dilarabedir.filterservice.business.abstracts.FilterService;
import com.dilarabedir.filterservice.business.dto.responses.GetAllFiltersResponse;
import com.dilarabedir.filterservice.business.dto.responses.GetFilterResponse;
import com.dilarabedir.filterservice.entities.Filter;
import com.dilarabedir.filterservice.repository.FilterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FilterManager implements FilterService {
    private final FilterRepository repository;
    private final DtoConverterService dtoConverterService;

    @Override
    public List<GetAllFiltersResponse> getAll() {
        var filters = repository.findAll();
        return dtoConverterService.toListDto(filters, GetAllFiltersResponse.class);
    }

    @Override
    public GetFilterResponse getById(UUID id) {
        var filter = repository.findById(id).orElseThrow();
        return dtoConverterService.toDto(filter, GetFilterResponse.class);
    }

    @Override
    public void add(Filter filter) {
        repository.save(filter);
    }

    @Override
    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
