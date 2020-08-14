package com.springboot.template1.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.template1.services.TemplateService;
import com.springboot.template1.web.model.TemplateDto;
import org.graalvm.compiler.virtual.phases.ea.ReadEliminationBlockState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RequestMapping("/api/v1/template")
@RestController
public class TemplateController {

    private final TemplateService templateService;
    private final ObjectMapper objectMapper;

    public TemplateController(TemplateService templateService, ObjectMapper objectMapper) {
        this.templateService = templateService;
        this.objectMapper = objectMapper;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getDto(@PathVariable("id") UUID id) throws Exception {
        String response = objectMapper.writeValueAsString(templateService.getById(id));
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PostMapping(value = "/addDto", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HashMap> handlePost(@RequestBody TemplateDto templateDto) throws Exception {
        TemplateDto savedDto = templateService.addDto(templateDto);
        HashMap<String, String> response = new HashMap<>();
        response.put("uuid", savedDto.getId().toString());
        response.put("name", savedDto.getName());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping(value = "/updateDto/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> handlePut(@PathVariable("id") UUID id,@RequestBody TemplateDto templateDto) throws Exception {
        templateService.updateDto(id,templateDto);
        return new ResponseEntity<>("Updated UUID" + id, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/deleteDto", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> handleDelete(@RequestBody UUID id) throws Exception {
        templateService.deleteById(id);
        return new ResponseEntity<>("Deleted UUID "+ id, HttpStatus.ACCEPTED);
    }
}
