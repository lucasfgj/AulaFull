package com.example.aulaFullStack.controller;

import com.example.aulaFullStack.model.Usuario;
import com.example.aulaFullStack.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*") // Aceita conexão de aplicações externas
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> listarTodos(){
        return usuarioService.listarUsuario();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Usuario usuario){
        usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", "Usuario Cadastrado com Sucesso"));
    }


    @DeleteMapping("/{email}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable String email){
        usuarioService.excluir(email);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", "Usuario deletado com Sucesso"));
    }
}
