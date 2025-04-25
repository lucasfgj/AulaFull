package com.example.aulaFullStack.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O email é obrigatorio")
    @Email(message = "Deve ser um Email valido")
    private String email;

    @NotBlank(message = "A senha é obrigatoria")
    @Size(min = 3, message = "A senha deve ter no minimo 3 caracteres")
    private String senha;

    public Usuario() {
    }

    public Usuario(Long id, String email, String senha) {
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "O email é obrigatorio") @Email(message = "Deve ser um Email valido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O email é obrigatorio") @Email(message = "Deve ser um Email valido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "A senha é obrigatoria") @Size(min = 3, message = "A senha deve ter no minimo 3 caracteres") String getSenha() {
        return senha;
    }

    public void setSenha(@NotBlank(message = "A senha é obrigatoria") @Size(min = 3, message = "A senha deve ter no minimo 3 caracteres") String senha) {
        this.senha = senha;
    }
}
