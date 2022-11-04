package com.aptos.cadastrodeaptos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Apartamento {
    private int id, nroPorta, quartos;
    private String tipo;
    private Proprietario proprietario;
}
