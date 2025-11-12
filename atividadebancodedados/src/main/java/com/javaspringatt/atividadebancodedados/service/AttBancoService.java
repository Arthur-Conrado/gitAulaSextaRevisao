package com.javaspringatt.atividadebancodedados.service;

import java.util.Optional;
import com.javaspringatt.atividadebancodedados.models.AttBancoModel;
import com.javaspringatt.atividadebancodedados.repository.AttBancoRepository;
import com.javaspringatt.atividadebancodedados.service.AttBancoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttBancoService {

    @Autowired
    private AttBancoRepository attBancoRepository;
    public List<AttBancoModel> listarTodos(){
        return attBancoRepository.findAll();
    }
    public AttBancoModel buscarPorId(int id){
        Optional <AttBancoModel> produto = attBancoRepository.findById(id);
        return produto.orElse(null);
    }
    public AttBancoModel adcionarProduto(AttBancoModel produto){
        return attBancoRepository.save(produto);
    }
    public AttBancoModel atualizarProduto(int id, AttBancoModel produtoAtualizado){
        Optional <AttBancoModel> produtoExistente = attBancoRepository.findById(id);
        if(produtoExistente.isPresent()){
            AttBancoModel produto = produtoExistente.get();
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            return attBancoRepository.save(produto);
        }
        return null;
    }
    public void deletarProduto(int id){
        attBancoRepository.deleteById(id);
        
    }

    public double calcularValorToral(){
        List<AttBancoModel> produtos = attBancoRepository.findAll();
        double total = 0;
        for(AttBancoModel b : produtos){
            total += b.getPreco();
        }
        return total;
    }

}
