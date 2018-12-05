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
@Table(name = "compra", catalog = "turmacgrupo2", schema = "")
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByIdCompra", query = "SELECT c FROM Compra c WHERE c.idCompra = :idCompra"),
    @NamedQuery(name = "Compra.findByDataCompra", query = "SELECT c FROM Compra c WHERE c.dataCompra = :dataCompra"),
    @NamedQuery(name = "Compra.findByValorCompra", query = "SELECT c FROM Compra c WHERE c.valorCompra = :valorCompra"),
    @NamedQuery(name = "Compra.findByFornecedoridFornecedor", query = "SELECT c FROM Compra c WHERE c.fornecedoridFornecedor = :fornecedoridFornecedor"),
    @NamedQuery(name = "Compra.findByFuncionarioidFuncionario", query = "SELECT c FROM Compra c WHERE c.funcionarioidFuncionario = :funcionarioidFuncionario")})
public class Compra implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Compra")
    private Integer idCompra;
    @Column(name = "data_compra")
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_compra")
    private Double valorCompra;
    @Basic(optional = false)
    @Column(name = "Fornecedor_id_Fornecedor")
    private int fornecedoridFornecedor;
    @Basic(optional = false)
    @Column(name = "Funcionario_id_Funcionario")
    private int funcionarioidFuncionario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compra")
    private List<DetCompra> detCompraList;

    public Compra() {
    }

    public Compra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Compra(Integer idCompra, int fornecedoridFornecedor, int funcionarioidFuncionario) {
        this.idCompra = idCompra;
        this.fornecedoridFornecedor = fornecedoridFornecedor;
        this.funcionarioidFuncionario = funcionarioidFuncionario;
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        Integer oldIdCompra = this.idCompra;
        this.idCompra = idCompra;
        changeSupport.firePropertyChange("idCompra", oldIdCompra, idCompra);
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        Date oldDataCompra = this.dataCompra;
        this.dataCompra = dataCompra;
        changeSupport.firePropertyChange("dataCompra", oldDataCompra, dataCompra);
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        Double oldValorCompra = this.valorCompra;
        this.valorCompra = valorCompra;
        changeSupport.firePropertyChange("valorCompra", oldValorCompra, valorCompra);
    }

    public int getFornecedoridFornecedor() {
        return fornecedoridFornecedor;
    }

    public void setFornecedoridFornecedor(int fornecedoridFornecedor) {
        int oldFornecedoridFornecedor = this.fornecedoridFornecedor;
        this.fornecedoridFornecedor = fornecedoridFornecedor;
        changeSupport.firePropertyChange("fornecedoridFornecedor", oldFornecedoridFornecedor, fornecedoridFornecedor);
    }

    public int getFuncionarioidFuncionario() {
        return funcionarioidFuncionario;
    }

    public void setFuncionarioidFuncionario(int funcionarioidFuncionario) {
        int oldFuncionarioidFuncionario = this.funcionarioidFuncionario;
        this.funcionarioidFuncionario = funcionarioidFuncionario;
        changeSupport.firePropertyChange("funcionarioidFuncionario", oldFuncionarioidFuncionario, funcionarioidFuncionario);
    }

    public List<DetCompra> getDetCompraList() {
        return detCompraList;
    }

    public void setDetCompraList(List<DetCompra> detCompraList) {
        this.detCompraList = detCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCompra != null ? idCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.idCompra == null && other.idCompra != null) || (this.idCompra != null && !this.idCompra.equals(other.idCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turmacgrupo2.Compra[ idCompra=" + idCompra + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
