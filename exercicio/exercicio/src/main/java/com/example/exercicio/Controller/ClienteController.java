package com.example.exercicio.Controller;

import com.example.exercicio.Model.Cliente;
import com.example.exercicio.Service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<Cliente> listarTodos(){
        return clienteService.listarClientes();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Cliente cliente){
        clienteService.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", "Usuario Cadastrado com Sucesso"));
    }


    @DeleteMapping("/{email}")
    public ResponseEntity<Map<String, Object>> excluir(@PathVariable String email){
        clienteService.excluir(email);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", "Usuario deletado com Sucesso"));
    }
}

