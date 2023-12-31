package com.dilarabedir.filterservice.api.controllers;

import com.dilarabedir.filterservice.business.abstracts.FilterService;
import com.dilarabedir.filterservice.business.dto.responses.GetAllFiltersResponse;
import com.dilarabedir.filterservice.business.dto.responses.GetFilterResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/filters")
@AllArgsConstructor
public class FiltersController {
    private final FilterService service;

    @GetMapping
    public List<GetAllFiltersResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public GetFilterResponse getById(@PathVariable UUID id) {
        return service.getById(id);
    }

}
