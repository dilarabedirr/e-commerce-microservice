package com.dilarabedir.filterservice.business.abstracts;

import com.dilarabedir.filterservice.business.dto.responses.GetAllFiltersResponse;
import com.dilarabedir.filterservice.business.dto.responses.GetFilterResponse;
import com.dilarabedir.filterservice.entities.Filter;

import java.util.List;
import java.util.UUID;

public interface FilterService {
    List<GetAllFiltersResponse> getAll();
    GetFilterResponse getById(UUID id);
    void add(Filter filter);
    void delete(UUID id);
}
