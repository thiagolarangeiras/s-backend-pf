package com.controlis.salus.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

record AjudaDto(
        String[] estudantes,
        String projeto,
        String tema
) { }

@RestController
@RequestMapping("/ajuda")
public class AjudaController {
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public AjudaDto ajuda() {
        return new AjudaDto(
            new String[] {
                "João Pedro Darabas Cardoso",
                "Paulo César Becker Dal Ponte",
                "Thiago Larangeira de Souza",
            },
            "Controlis Salus (Controle de Saúde)",
            "Saúde e Bem-estar: Gerenciamento de Medicamentos, Mapeamento de Atendimentos Médicos, Recomendações Médicas."
        );
    }
}
