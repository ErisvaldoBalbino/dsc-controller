package com.br.edu.ifrn.controller;

import com.br.edu.ifrn.models.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();
    private AtomicLong idGenerator = new AtomicLong();

    private Optional<Produto> findProdutoById(Long id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    @GetMapping("/produtos")
    public List<Produto> getProdutos() {
        return produtos;
    }

    @GetMapping("/produtos/{id}")
    public ResponseEntity<Produto> getProduto(@PathVariable Long id) {
        Optional<Produto> produtoOptional = findProdutoById(id);

        return produtoOptional
                .map(produto -> ResponseEntity.ok().body(produto))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/produtos")
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {
        produto.setId(idGenerator.incrementAndGet());
        produtos.add(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping("/produtos/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        Optional<Produto> produtoOptional = findProdutoById(id);

        if (produtoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Produto produtoExistente = produtoOptional.get();
        produtoExistente.setNome(produtoAtualizado.getNome());
        produtoExistente.setPreco(produtoAtualizado.getPreco());

        return ResponseEntity.ok(produtoExistente);
    }

    @DeleteMapping("/produtos/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        Optional<Produto> produtoOptional = findProdutoById(id);

        if (produtoOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        produtos.remove(produtoOptional.get());

        return ResponseEntity.noContent().build();
    }
}