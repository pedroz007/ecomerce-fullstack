package com.ecomerce.dtos;

import lombok.Data;

@Data
public class ProdutoDTO {
    private String nome;
    private String descricao;
    private double preco;
    private Long categoriaId;
    
}
