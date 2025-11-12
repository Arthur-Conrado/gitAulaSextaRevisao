package com.javaspringatt.atividadebancodedados.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaspringatt.atividadebancodedados.models.AttBancoModel;
import com.javaspringatt.atividadebancodedados.service.AttBancoService;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/produtos")
public class AttBancoController {
    @Autowired
    private AttBancoService attBancoService;

@GetMapping
public ResponseEntity<List<AttBancoModel>> listarTodos(){
    List<AttBancoModel> produtos = attBancoService.listarTodos();
    return ResponseEntity.ok(produtos);
}

@GetMapping("/{id}")
public ResponseEntity<AttBancoModel> buscarPorId(@PathVariable int id){
    AttBancoModel produto = attBancoService.buscarPorId(id);
    if(produto!= null){
        return ResponseEntity.ok(produto);
    }
    return ResponseEntity.notFound().build();
    
}


@PostMapping
public ResponseEntity<AttBancoModel> adcionarProduto(@RequestBody AttBancoModel produto){
    AttBancoModel produtoSalvo = attBancoService.adcionarProduto(produto);
    return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);

}

@PutMapping("/{id}")
public ResponseEntity<AttBancoModel> atualizarProduto(@PathVariable int id,  @RequestBody AttBancoModel produto){
    AttBancoModel produtoAtualizado = attBancoService.atualizarProduto(id,produto);
    if(produtoAtualizado != null){
        return ResponseEntity.ok(produtoAtualizado);
    }
    return ResponseEntity.notFound().build();
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deletarProduto(@PathVariable int id){
    AttBancoModel produto =attBancoService.buscarPorId(id);
    if(produto!= null ){
        attBancoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
}

    @GetMapping("/Total")
        public ResponseEntity<Double> calcularTotal(){
            double total = attBancoService.calcularValorToral();
            return ResponseEntity.ok(total);
        }




}
