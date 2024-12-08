package com.greensystem.greensystem.models.service;

import com.greensystem.greensystem.models.entity.Armazenamento;
import com.greensystem.greensystem.models.entity.Cliente;
//import com.greensystem.greensystem.models.entity.FontesNaturais;
import com.greensystem.greensystem.models.repository.ArmazenamentoRepository;
import com.greensystem.greensystem.models.repository.ClienteRepository;
//import com.greensystem.greensystem.models.repository.FontesNaturaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.Optional;

@Service
public class CadastroRecursosService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ArmazenamentoRepository armazenamentoRepository;

    //@Autowired
    //private FontesNaturaisRepository fontesNaturaisRepository;

    // Método para cadastrar recurso de Água
    public String cadastrarRecursoAgua(String cnpj, Double gastos, Double coleta) {
        Cliente cliente = clienteRepository.findByCnpj(cnpj);
        if (cliente != null) {
            Armazenamento armazenamento = new Armazenamento();
            armazenamento.setCliente(cliente);
            armazenamento.setGastos(gastos);
            armazenamento.setColeta(coleta);
            armazenamentoRepository.save(armazenamento);
            return "Cadastro de Água realizado com sucesso!";
        }
        return "Cliente não encontrado com o CNPJ informado.";
    }

    // Método para cadastrar recurso de Energia
    public String cadastrarRecursoEnergia(String cnpj, Double gastos, Double coleta) {
        Cliente cliente = clienteRepository.findByCnpj(cnpj);
        if (cliente != null) {
            Armazenamento armazenamento = new Armazenamento();
            armazenamento.setCliente(cliente);
            armazenamento.setGastos(gastos);
            armazenamento.setColeta(coleta);
            armazenamentoRepository.save(armazenamento);
            return "Cadastro de Energia realizado com sucesso!";
        }
        return "Cliente não encontrado com o CNPJ informado.";
    }

    // Método para cadastrar Fonte Natural (caso seja relevante para o seu sistema)
    /*public String cadastrarFonteNatural(String cnpj, Integer codRecurso) {
        Cliente cliente = clienteRepository.findByCnpj(cnpj);
        Optional<FontesNaturais> fonte = fontesNaturaisRepository.findById(codRecurso);
        if (cliente != null && fonte.isPresent()) {
            FontesNaturais fontesNaturais = fonte.get();
            fontesNaturais.setCliente(cliente);  // Agora pode definir o cliente
            fontesNaturaisRepository.save(fontesNaturais);
            return "Cadastro de Fonte Natural realizado com sucesso!";
        }
        return cliente == null ? "Cliente não encontrado com o CNPJ informado." : "Código de recurso inválido.";
    }*/
}
