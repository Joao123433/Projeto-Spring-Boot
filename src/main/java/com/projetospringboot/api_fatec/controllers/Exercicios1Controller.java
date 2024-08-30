package com.projetospringboot.api_fatec.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exercicios1")
public class Exercicios1Controller {
    
    @GetMapping()
    public String HelloWorld() {
        return "Hello";
    }

    @GetMapping("/hello1")
    public String HelloWorld1() {
        return "Hello1";
    }

    //@PathVariable = anotacao para definir que a variavel nome que é do tipo String será recebida pelo
    //parametro {nome}
    @PostMapping("/reverter-nome")
    String reverterNome(@RequestBody String nome) {
        return new StringBuilder(nome).reverse().toString();
    }

    ///api/exercicios1/2/par-ou-impar => @GetMapping("/{numero}/par-ou-impar")
    ///api/exercicios1/par-ou-impar/2 => @GetMapping("/par-ou-impar/{numero}")
    @GetMapping("/par-ou-impar/{numero}")
    String verificarParOuImpar(@PathVariable Integer numero) {
        if (numero % 2 == 0) {
            return "Par";
        } else {
            return "Ímpar";
        }
    }

    @GetMapping("/contar-letras/{texto}")
    String contarLetras(@PathVariable String texto) {
        // return "A palavra " + texto + "contem " + Integer.toString(count) + "letras";
        return "A palavra \"" + texto + "\" contém " + texto.length() + " letras.";
    }

    @GetMapping("/idade-com-parametro-tipo-integer/{idade}")
    String showIdade(@PathVariable Integer idade) {
        if(idade < 12) {
            return "Criança";
        } else if(idade <= 18) {
            return "Adolecente";
        } else if(idade <= 60) {
            return "Adulto";
        } else if(idade > 60) {
            return "Idoso";
        } else {
            return "Idade Invalida";
        }
    }

    public void teste01() {
        var usuario = new User("Joao Guilherme", 22);
    }

    public class User {
        private String nome;
        private Integer idade;

        public User() {
        }

        public User(String nome, Integer idade) {
            this.nome = nome;
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Integer getIdade() {
            return idade;
        }

        public void setIdade(Integer idade) {
            this.idade = idade;
        }
    }

    @PostMapping("/create-user")
    public String createUser(@RequestBody User user) {
        return "Ola " + user.getNome() + " você tem " + user.getIdade() + " anos;";
    }
}