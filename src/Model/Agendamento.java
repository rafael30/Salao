/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Tadeu
 */
@Entity
@Table(name = "agendamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Agendamento.findAll", query = "SELECT a FROM Agendamento a"),
    @NamedQuery(name = "Agendamento.findByCodagendamento", query = "SELECT a FROM Agendamento a WHERE a.codagendamento = :codagendamento"),
    @NamedQuery(name = "Agendamento.findByDataAgendamento", query = "SELECT a FROM Agendamento a WHERE a.dataAgendamento = :dataAgendamento"),
    @NamedQuery(name = "Agendamento.findByCodpessoa", query = "SELECT a FROM Agendamento a WHERE a.codpessoa = :codpessoa")})
public class Agendamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODAGENDAMENTO")
    private Integer codagendamento;
    @Basic(optional = false)
    @Column(name = "DATA_AGENDAMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAgendamento;
    @Basic(optional = false)
    @Column(name = "CODPESSOA")
    private int codpessoa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codagendamento")
    private List<Servico> servicoList;
    @JoinColumn(name = "Column", referencedColumnName = "CODPESSOA")
    @ManyToOne(optional = false)
    private Pessoa column;

    public Agendamento() {
    }

    public Agendamento(Integer codagendamento) {
        this.codagendamento = codagendamento;
    }

    public Agendamento(Integer codagendamento, Date dataAgendamento, int codpessoa) {
        this.codagendamento = codagendamento;
        this.dataAgendamento = dataAgendamento;
        this.codpessoa = codpessoa;
    }

    public Integer getCodagendamento() {
        return codagendamento;
    }

    public void setCodagendamento(Integer codagendamento) {
        this.codagendamento = codagendamento;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public int getCodpessoa() {
        return codpessoa;
    }

    public void setCodpessoa(int codpessoa) {
        this.codpessoa = codpessoa;
    }

    @XmlTransient
    public List<Servico> getServicoList() {
        return servicoList;
    }

    public void setServicoList(List<Servico> servicoList) {
        this.servicoList = servicoList;
    }

    public Pessoa getColumn() {
        return column;
    }

    public void setColumn(Pessoa column) {
        this.column = column;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codagendamento != null ? codagendamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Agendamento)) {
            return false;
        }
        Agendamento other = (Agendamento) object;
        if ((this.codagendamento == null && other.codagendamento != null) || (this.codagendamento != null && !this.codagendamento.equals(other.codagendamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Agendamento[ codagendamento=" + codagendamento + " ]";
    }
    
}
