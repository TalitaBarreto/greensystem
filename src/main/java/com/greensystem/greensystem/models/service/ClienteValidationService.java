package com.greensystem.greensystem.models.service;

import com.greensystem.greensystem.models.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteValidationService {

    @Autowired
    private ClienteRepository clienteRepository;

    // Método para verificar se o login já está em uso
    public boolean isLoginJaExistente(String login) {
        return clienteRepository.findByLogin(login) != null;
    }

    // Método para verificar se o CNPJ já está cadastrado
    public boolean isCnpjJaExistente(String cnpj) {
        return clienteRepository.findByCnpj(cnpj) != null;
    }

    // Método para verificar se as senhas são iguais
    public boolean verificarSenhasIguais(String senha, String senhaConfirmacao) {
        return senha.equals(senhaConfirmacao);
    }
}
