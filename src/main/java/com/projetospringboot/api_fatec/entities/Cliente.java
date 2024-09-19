package com.projetospringboot.api_fatec.entities;

public class Cliente {
  private int id;
  private String nome;

  public Cliente() {}

  public Cliente(int id, String nome) {
    this.id = id;
    this.nome = nome
  }

  public getId() {
    return this.id;
  }

  public getNome() {
    return this.nome;
  }

  public setId(int id) {
    this.id = id;
  }

  public setNome(String nome) {
    this.nome = nome;
  }

}