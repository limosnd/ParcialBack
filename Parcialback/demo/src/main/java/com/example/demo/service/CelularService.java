package com.example.demo.service;

import com.example.demo.dto.CelularDTO;
import com.example.demo.entity.Celular;
import com.example.demo.repository.CelularRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CelularService {

    private final CelularRepository celularRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CelularService(CelularRepository celularRepository, ModelMapper modelMapper) {
        this.celularRepository = celularRepository;
        this.modelMapper = modelMapper;
    }

    public CelularDTO findById(Long id) {
        Optional<Celular> celularOptional = celularRepository.findById(id);
        return celularOptional.map(celular -> modelMapper.map(celular, CelularDTO.class)).orElse(null);
    }

    public List<CelularDTO> findAll() {
        List<Celular> celularList = (List<Celular>) celularRepository.findAll();
        return celularList.stream()
                .map(celular -> modelMapper.map(celular, CelularDTO.class))
                .collect(Collectors.toList());
    }

    public CelularDTO save(CelularDTO celularDTO) {
        Celular celular = modelMapper.map(celularDTO, Celular.class);
        celular = celularRepository.save(celular);
        return modelMapper.map(celular, CelularDTO.class);
    }

    public CelularDTO update(CelularDTO celularDTO) {
        Celular celular = modelMapper.map(celularDTO, Celular.class);
        celular = celularRepository.save(celular);
        return modelMapper.map(celular, CelularDTO.class);
    }

    public void deleteById(Long id) {
        celularRepository.deleteById(id);
    }
}
