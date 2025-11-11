package com.javaspringatt.atividadebancodedados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttBancoService {

    @Autowired
    private AttBancoRepository AttBancoRepository;
    public List<AttBancoModel> listarTodos(){
        return AttBancoRepository.findAll();
    }
    public AttBancoModel bucasPorId(int id){
        Optional <AttBancoModel> produto = AttBancoRepository.findById(id);
        return produto.orElse(null);
    }
    public AttBancoModel adcionarProduto(AttBancoModel produto){
        return AttBancoRepository.save(produto);

    }

}
