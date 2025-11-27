package com.ecomerce.service;

import java.lang.module.ModuleDescriptor.Builder;

import org.springframework.stereotype.Service;

import com.ecomerce.dtos.ProdutoDTO;
import com.ecomerce.ecomercefullstack.model.Categoria;
import com.ecomerce.ecomercefullstack.model.Produto;
import com.ecomerce.ecomercefullstack.repository.CategoriaRepository;
import com.ecomerce.ecomercefullstack.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
    }

    public Produto cadatrarProduto(ProdutoDTO dto){
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                        .orElseThrow(() -> new RuntimeException("Categoria não Encontrada"));

        Produto produto = Produto.builder()
                        .nome(dto.getNome())
                        .descricao(dto.getDescricao())
                        .preco(dto.getPreco())
                        .categoria(categoria)
                        .build();

        return produtoRepository.save(produto);
    }


    
}
