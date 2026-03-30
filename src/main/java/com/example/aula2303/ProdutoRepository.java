package com.example.aula2303;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<Produto> findByNomeContainingIgnoringCase(String nome);
    List<Produto> findByPrecoLessThan(Double preco);
    void deleteById(Long id);
}
