package com.softtek.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class Cliente {
    @EqualsAndHashCode.Include
    //@ToString.Include
    private Integer idCliente;

    // @ToString.Include
    private String nombre;
    private String trabajo;
    private LocalDate fNacimiento;
    private double salario;
    private String pais;
}
