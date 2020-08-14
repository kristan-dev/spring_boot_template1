package com.springboot.template1.services;

import com.springboot.template1.web.model.TemplateDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class TemplateServiceImpl implements TemplateService {
    @Override
    public TemplateDto getById(UUID id) {
        log.debug("Get...");
        //todo: add get logic to repository here
        return TemplateDto.builder()
                .id(UUID.randomUUID())
                .name("some name")
                .build();
    }

    @Override
    public TemplateDto addDto(TemplateDto templateDto) {
        log.debug("Added...");
        //todo: add create/add logic to repository here
        return TemplateDto.builder()
                .id(templateDto.getId())
                .name(templateDto.getName())
                .build();
    }

    @Override
    public void updateDto(UUID id,TemplateDto templateDto) {
        log.debug("Updated...");
        //todo: add updated logic to repository here
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("Deleted uuid "+ id);
        //todo: add delete logic to repository here
    }
}
