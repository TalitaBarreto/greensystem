package com.greensystem.greensystem.models.service;

import com.greensystem.greensystem.models.entity.Cliente;
import com.greensystem.greensystem.models.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Verifica se o login e a senha estão corretos
    public boolean autenticarUsuario(String login, String senha) {
        Cliente cliente = clienteRepository.findByLogin(login);
        if (cliente != null) {
            // Compara a senha fornecida com a senha criptografada armazenada no banco
            return passwordEncoder.matches(senha, cliente.getSenha());
        }
        return false;
    }
}
