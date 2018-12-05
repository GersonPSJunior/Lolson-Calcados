/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmacgrupo2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Baiano
 */
@Entity
@Table(name = "venda", catalog = "turmacgrupo2", schema = "")
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findByIdVenda", query = "SELECT v FROM Venda v WHERE v.idVenda = :idVenda"),
    @NamedQuery(name = "Venda.findByDataVenda", query = "SELECT v FROM Venda v WHERE v.dataVenda = :dataVenda"),
    @NamedQuery(name = "Venda.findByValorVenda", query = "SELECT v FROM Venda v WHERE v.valorVenda = :valorVenda"),
    @NamedQuery(name = "Venda.findByDesconto", query = "SELECT v FROM Venda v WHERE v.desconto = :desconto"),
    @NamedQuery(name = "Venda.findByNumParcelas", query = "SELECT v FROM Venda v WHERE v.numParcelas = :numParcelas"),
    @NamedQuery(name = "Venda.findByClienteidCliente", query = "SELECT v FROM Venda v WHERE v.clienteidCliente = :clienteidCliente"),
    @NamedQuery(name = "Venda.findByFuncionarioidFuncionario", query = "SELECT v FROM Venda v WHERE v.funcionarioidFuncionario = :funcionarioidFuncionario")})
public class Venda implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Venda")
    private Integer idVenda;
    @Column(name = "data_venda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_venda")
    private Double valorVenda;
    @Column(name = "desconto")
    private Double desconto;
    @Column(name = "num_parcelas")
    private Double numParcelas;
    @Basic(optional = false)
    @Column(name = "Cliente_id_Cliente")
    private int clienteidCliente;
    @Basic(optional = false)
    @Column(name = "Funcionario_id_Funcionario")
    private int funcionarioidFuncionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda")
    private List<DetVenda> detVendaList;

    public Venda() {
    }

    public Venda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Venda(Integer idVenda, int clienteidCliente, int funcionarioidFuncionario) {
        this.idVenda = idVenda;
        this.clienteidCliente = clienteidCliente;
        this.funcionarioidFuncionario = funcionarioidFuncionario;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        Integer oldIdVenda = this.idVenda;
        this.idVenda = idVenda;
        changeSupport.firePropertyChange("idVenda", oldIdVenda, idVenda);
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        Date oldDataVenda = this.dataVenda;
        this.dataVenda = dataVenda;
        changeSupport.firePropertyChange("dataVenda", oldDataVenda, dataVenda);
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        Double oldValorVenda = this.valorVenda;
        this.valorVenda = valorVenda;
        changeSupport.firePropertyChange("valorVenda", oldValorVenda, valorVenda);
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        Double oldDesconto = this.desconto;
        this.desconto = desconto;
        changeSupport.firePropertyChange("desconto", oldDesconto, desconto);
    }

    public Double getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(Double numParcelas) {
        Double oldNumParcelas = this.numParcelas;
        this.numParcelas = numParcelas;
        changeSupport.firePropertyChange("numParcelas", oldNumParcelas, numParcelas);
    }

    public int getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(int clienteidCliente) {
        int oldClienteidCliente = this.clienteidCliente;
        this.clienteidCliente = clienteidCliente;
        changeSupport.firePropertyChange("clienteidCliente", oldClienteidCliente, clienteidCliente);
    }

    public int getFuncionarioidFuncionario() {
        return funcionarioidFuncionario;
    }

    public void setFuncionarioidFuncionario(int funcionarioidFuncionario) {
        int oldFuncionarioidFuncionario = this.funcionarioidFuncionario;
        this.funcionarioidFuncionario = funcionarioidFuncionario;
        changeSupport.firePropertyChange("funcionarioidFuncionario", oldFuncionarioidFuncionario, funcionarioidFuncionario);
    }

    public List<DetVenda> getDetVendaList() {
        return detVendaList;
    }

    public void setDetVendaList(List<DetVenda> detVendaList) {
        this.detVendaList = detVendaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenda != null ? idVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.idVenda == null && other.idVenda != null) || (this.idVenda != null && !this.idVenda.equals(other.idVenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turmacgrupo.Venda[ idVenda=" + idVenda + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
