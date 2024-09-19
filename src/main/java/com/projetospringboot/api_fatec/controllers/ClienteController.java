package com.projetospringboot.api_fatec.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.controle_financeiro.entities.Cliente;

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
        if (clienteA.getName().equals(cliente.getName())) {
          throw new IllegalArgumentException("ja existe nome");
        }
      }

      cliente.setId(proximoId++);
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
      // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
      for (Cliente cliente : Clientes) {
        if (cliente.getId() == id) {
          // Se o usuário for encontrado, retorna-o com status 200 OK
          return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
      }
      // Se o usuário não for encontrado, retorna status 404 Not Found
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //UPDATE
    @PutMapping("{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable int id, @RequestBody Cliente entity) {
      // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
      for (Cliente cliente : clientes) {
        if (cliente.getId() == id) {
          // Se o usuário for encontrado, atualiza suas informações
          cliente.setName(entity.getName());
          cliente.setAge(entity.getAge());
          // Retorna o usuário atualizado com status 200 OK
          return new ResponseEntity<>(cliente, HttpStatus.OK);
        }
      }
      // Se o usuário não for encontrado, retorna status 404 Not Found
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable int id) {
      // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
      for (Cliente cliente : clientes) {
        if (cliente.getId() == id) {
          // Se o usuário for encontrado, remove-o da lista
          clientes.remove(cliente);
          // Retorna status 204 No Content
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
      }
      // Se o usuário não for encontrado, retorna status 404 Not Found
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}