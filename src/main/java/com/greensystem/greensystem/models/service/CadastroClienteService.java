package com.greensystem.greensystem.models.service;

import com.greensystem.greensystem.models.entity.Cliente;
import com.greensystem.greensystem.models.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Método para salvar um novo cliente
    public void salvarCliente(Cliente cliente) {
        // Criptografa a senha antes de salvar
        String senhaCriptografada = passwordEncoder.encode(cliente.getSenha());
        cliente.setSenha(senhaCriptografada); // Atualiza a senha com o hash
        clienteRepository.save(cliente);  // Salva o cliente no banco
    }
}


