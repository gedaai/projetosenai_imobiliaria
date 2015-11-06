
package br.com.imobiliaria.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "IMOVEL")
@XmlRootElement
public class Imovel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "tipo", nullable = false, length = 10)
    private Long tipo;
    @Column(name = "valor", nullable = false, length = 10)
    private Double valor;
    @Column(name = "descricao", nullable = false, length = 400)
    private String descricao;
    @Column(name = "uf", nullable = false, length = 100)
    private String uf;
    @Column(name = "cidade", nullable = false, length = 100)
    private String cidade;
    @Column(name = "bairro", nullable = false, length = 100)
    private String bairro;
    @OneToMany(fetch=FetchType.EAGER,mappedBy="imovel",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Imagem> imagens = new ArrayList<Imagem>();;

    public Imovel() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long tipo) {
        this.tipo = tipo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public List<Imagem> getImagens() {
        return imagens;
    }

    public void setImagens(List<Imagem> imagens) {
        this.imagens = imagens;
    }
    
}
