package com.projetospringboot.api_fatec.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetospringboot.api_fatec.entities.Cliente;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
  private List<Cliente> clientes = new ArrayList<>();
  private int proximoid = 1;

  //CREATE    
  @PostMapping()
  public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
      for (Cliente clienteA : clientes) {
        if (clienteA.getNome().equals(cliente.getNome())) {
          throw new IllegalArgumentException("ja existe nome");
        }
      }

      cliente.setId(proximoid++);
      clientes.add(cliente);

      return new ResponseEntity<>(cliente, HttpStatus.CREATED);
  }
  
    //READ
    @GetMapping()
    public ResponseEntity<List<Cliente>> getAllCliente() {
      return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cliente> getById(@PathVariable int id) {
      for (Cliente cliente : clientes) {
        if (cliente.getId() == id) {
          return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //UPDATE
    @PutMapping("{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable int id, @RequestBody Cliente entity) {
      for (Cliente cliente : clientes) {
        if (cliente.getId() == id) {
          cliente.setNome(entity.getNome());
          return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable int id) {
      for (Cliente cliente : clientes) {
        if (cliente.getId() == id) {
          clientes.remove(cliente);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}