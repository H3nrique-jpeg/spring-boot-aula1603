package com.example.aula2303;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listar() {return produtoService.listaTodos();}

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.findById(id);
        return produto.orElse(null);
    }
    
    @PostMapping
    public ResponseEntity<Produto> createCustumer(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {   
        Optional<Produto> existeProduto = this.produtoService.findById(id);
        if(existeProduto.isPresent()){
            this.produtoService.deleteById(existeProduto.get());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

