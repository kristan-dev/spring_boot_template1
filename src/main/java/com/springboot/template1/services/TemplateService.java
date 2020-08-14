package com.springboot.template1.services;

import com.springboot.template1.web.model.TemplateDto;

import java.util.UUID;

public interface TemplateService {
    TemplateDto getById(UUID id);

    TemplateDto addDto(TemplateDto templateDto);

    void updateDto(UUID id,TemplateDto templateDto);

    void deleteById(UUID id);
}
