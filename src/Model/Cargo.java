
package Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByCodcargo", query = "SELECT c FROM Cargo c WHERE c.codcargo = :codcargo"),
    @NamedQuery(name = "Cargo.findByDescricao", query = "SELECT c FROM Cargo c WHERE c.descricao = :descricao")})
public class Cargo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODCARGO")
    private Integer codcargo;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(mappedBy = "codcargo")
    private List<Pessoa> pessoaList;

    public Cargo() {
    }

    public Cargo(Integer codcargo) {
        this.codcargo = codcargo;
    }

    public Cargo(Integer codcargo, String descricao) {
        this.codcargo = codcargo;
        this.descricao = descricao;
    }

    public Integer getCodcargo() {
        return codcargo;
    }

    public void setCodcargo(Integer codcargo) {
        this.codcargo = codcargo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public List<Pessoa> getPessoaList() {
        return pessoaList;
    }

    public void setPessoaList(List<Pessoa> pessoaList) {
        this.pessoaList = pessoaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codcargo != null ? codcargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.codcargo == null && other.codcargo != null) || (this.codcargo != null && !this.codcargo.equals(other.codcargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Cargo[ codcargo=" + codcargo + " ]";
    }
    
}
