/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Tadeu
 */
@Entity
@Table(name = "endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.findByCodendereco", query = "SELECT e FROM Endereco e WHERE e.codendereco = :codendereco"),
    @NamedQuery(name = "Endereco.findByLogradouro", query = "SELECT e FROM Endereco e WHERE e.logradouro = :logradouro"),
    @NamedQuery(name = "Endereco.findByNumero", query = "SELECT e FROM Endereco e WHERE e.numero = :numero"),
    @NamedQuery(name = "Endereco.findByComplemento", query = "SELECT e FROM Endereco e WHERE e.complemento = :complemento"),
    @NamedQuery(name = "Endereco.findByBairro", query = "SELECT e FROM Endereco e WHERE e.bairro = :bairro")})
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODENDERECO")
    private Integer codendereco;
    @Basic(optional = false)
    @Column(name = "LOGRADOURO")
    private String logradouro;
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private int numero;
    @Column(name = "COMPLEMENTO")
    private String complemento;
    @Basic(optional = false)
    @Column(name = "BAIRRO")
    private String bairro;
    @JoinColumn(name = "CODCIDADE", referencedColumnName = "CODCIDADE")
    @ManyToOne(optional = false)
    private Cidade codcidade;
    @JoinColumn(name = "CODPESSOA", referencedColumnName = "CODPESSOA")
    @ManyToOne(optional = false)
    private Pessoa codpessoa;

    public Endereco() {
    }

    public Endereco(Integer codendereco) {
        this.codendereco = codendereco;
    }

    public Endereco(Integer codendereco, String logradouro, int numero, String bairro) {
        this.codendereco = codendereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
    }

    public Integer getCodendereco() {
        return codendereco;
    }

    public void setCodendereco(Integer codendereco) {
        this.codendereco = codendereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCodcidade() {
        return codcidade;
    }

    public void setCodcidade(Cidade codcidade) {
        this.codcidade = codcidade;
    }

    public Pessoa getCodpessoa() {
        return codpessoa;
    }

    public void setCodpessoa(Pessoa codpessoa) {
        this.codpessoa = codpessoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codendereco != null ? codendereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.codendereco == null && other.codendereco != null) || (this.codendereco != null && !this.codendereco.equals(other.codendereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Endereco[ codendereco=" + codendereco + " ]";
    }
    
}
