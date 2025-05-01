package com.example.exercicio.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo Nome é obrigatorio")
    private String nome;

    @NotBlank( message = "Este campo não deve ficar em branco")
    private String telefone;

    @NotBlank(message = "Este campo é obrigatorio")
    @Email(message = "Deve ser um Email valido")
    private String email;

    @NotBlank(message = "Senha é obrigatoria")
    @Size(min = 4, message = "A senha não pode ter menos que 4 caracteres é")
    private String senha;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String telefone, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O campo Nome é obrigatorio") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O campo Nome é obrigatorio") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Este campo não deve ficar em branco") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "Este campo não deve ficar em branco") String telefone) {
        this.telefone = telefone;
    }

    public @NotBlank(message = "Este campo é obrigatorio") @Email(message = "Deve ser um Email valido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Este campo é obrigatorio") @Email(message = "Deve ser um Email valido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Senha é obrigatoria") @Size(min = 4, message = "A senha não pode ter menos que 4 caracteres é") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "Senha é obrigatoria") @Size(min = 4, message = "A senha não pode ter menos que 4 caracteres é") String senha) {
        this.senha = senha;
    }
}
