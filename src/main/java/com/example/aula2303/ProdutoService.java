package com.example.aula2303;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listaTodos()
    {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id){
        return repository.findById(id).orElseThrow(
            () -> new RuntimeException("Produto não encontrado"+ id));
    }

    public Produto salvar(Produto produto)
    {
        if (produto.getPreco() <= 0)
            throw new IllegalArgumentException("Preco invalido");
        return repository.save(produto);
    }
    public void deletar(Long id){
        buscarPorId(id);
        repository.deleteById(id);
    }

    public Optional<Produto> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    public ResponseEntity<Produto> save(Produto produto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    public void deleteById(Produto produto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
