package br.com.imobiliaria.model;

import java.sql.Blob;

public class Imagem {
    
    private Long id;
    private Long idimovel;
    private Blob imagem;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdimovel() {
        return idimovel;
    }

    public void setIdimovel(Long idimovel) {
        this.idimovel = idimovel;
    }

    public Blob getImagem() {
        return imagem;
    }

    public void setImagem(Blob imagem) {
        this.imagem = imagem;
    }
    
}
