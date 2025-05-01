package com.example.exercicio.Service;

import com.example.exercicio.Model.Cliente;
import com.example.exercicio.Repository.ClienteRepository;
import jakarta.validation.Valid;
import org.hibernate.mapping.UnionSubclass;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;


@Service
@Validated
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarClientes(){
        return clienteRepository.findAll();
    }

    public Cliente salvar(@Valid Cliente cliente){
        if(clienteRepository.findByEmail(cliente.getEmail()).isPresent()){
            throw new RuntimeException("Email já cadastrado");
        }
        return clienteRepository.save(cliente);
    }

    public Cliente  atualizar(@Valid Cliente cliente){
        Cliente clienteAtualizar = clienteRepository.findByEmail(cliente.getEmail()).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));

        clienteAtualizar.setNome(cliente.getNome());
        clienteAtualizar.setTelefone(cliente.getTelefone());
        clienteAtualizar.setEmail(cliente.getEmail());
        clienteAtualizar.setSenha(cliente.getSenha());
        return clienteRepository.save(clienteAtualizar);
    }

    public void excluir(String email){
        Cliente usuario = clienteRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));

        clienteRepository.deleteById(usuario.getId());
    }

}