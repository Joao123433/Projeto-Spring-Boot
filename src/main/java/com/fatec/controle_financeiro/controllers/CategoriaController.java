package com.fatec.controle_financeiro.controllers;

import com.fatec.controle_financeiro.domain.categoria.CategoriaRepository;
import com.fatec.controle_financeiro.entities.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    public ResponseEntity<Object> createCategoria(@RequestBody Categoria categoria) {
        if (categoria.getDescricao() == null || categoria.getDescricao().trim().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro: A descrição é obrigatória e não pode ser vazia.");
        }

        if (categoriaRepository.existsByDescricao(categoria.getDescricao())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Erro: Já existe uma categoria com a descrição '" + categoria.getDescricao() + "'.");
        }

        if (categoria.getAtivo() == null) {
            categoria.setAtivo(true);
        }

        Categoria novaCategoria = categoriaRepository.save(categoria);

        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
    }
}
