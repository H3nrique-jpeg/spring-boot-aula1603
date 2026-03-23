package com.example.aula2303;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoRepository;

    @GetMapping
    public List<Produto> listar() {return produtoRepository.listaTodos();}

    @GetMapping("/{id}")
    public Produto buscar(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElse(null);
    }
    
    @PostMapping
    public ResponseEntity<Produto> createCustumer(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
    
}
