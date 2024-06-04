package com.example.demo.controller;

import com.example.demo.dto.CelularDTO;
import com.example.demo.service.CelularService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/celulares")
@CrossOrigin(origins = "http://localhost")
public class CelularController {

    private final CelularService celularService;

    @Autowired
    public CelularController(CelularService celularService) {
        this.celularService = celularService;
    }

    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CelularDTO get(@PathVariable Long id) {
        return celularService.findById(id);
    }

    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CelularDTO> get() {
        return celularService.findAll();
    }

    @CrossOrigin
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CelularDTO save(@RequestBody CelularDTO celularDTO) {
        return celularService.save(celularDTO);
    }

    @CrossOrigin
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CelularDTO update(@RequestBody CelularDTO celularDTO) {
        return celularService.update(celularDTO);
    }

    @CrossOrigin
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id) {
        celularService.deleteById(id);
    }
}
