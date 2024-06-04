package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CelularDTO {

    private Long id;
    private String marca;
    private String serial;
    private LocalDate fechaCompra;
    private int anioLanzamiento;
    private double precio;
    private String sistemaOperativo;
    private String gama;
}
