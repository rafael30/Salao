
package Model;

import java.io.Serializable;
import java.math.BigDecimal;
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


@Entity
@Table(name = "servico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servico.findAll", query = "SELECT s FROM Servico s"),
    @NamedQuery(name = "Servico.findByCodservico", query = "SELECT s FROM Servico s WHERE s.codservico = :codservico"),
    @NamedQuery(name = "Servico.findByDescricao", query = "SELECT s FROM Servico s WHERE s.descricao = :descricao"),
    @NamedQuery(name = "Servico.findByValor", query = "SELECT s FROM Servico s WHERE s.valor = :valor")})
public class Servico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODSERVICO")
    private Integer codservico;
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VALOR")
    private BigDecimal valor;
    @JoinColumn(name = "CODAGENDAMENTO", referencedColumnName = "CODAGENDAMENTO")
    @ManyToOne(optional = false)
    private Agendamento codagendamento;

    public Servico() {
    }

    public Servico(Integer codservico) {
        this.codservico = codservico;
    }

    public Servico(Integer codservico, String descricao, BigDecimal valor) {
        this.codservico = codservico;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Integer getCodservico() {
        return codservico;
    }

    public void setCodservico(Integer codservico) {
        this.codservico = codservico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Agendamento getCodagendamento() {
        return codagendamento;
    }

    public void setCodagendamento(Agendamento codagendamento) {
        this.codagendamento = codagendamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codservico != null ? codservico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servico)) {
            return false;
        }
        Servico other = (Servico) object;
        if ((this.codservico == null && other.codservico != null) || (this.codservico != null && !this.codservico.equals(other.codservico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Servico[ codservico=" + codservico + " ]";
    }
    
}
