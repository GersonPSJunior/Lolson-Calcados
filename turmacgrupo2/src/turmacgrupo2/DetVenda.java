/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turmacgrupo2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Baiano
 */
@Entity
@Table(name = "det_venda", catalog = "turmacgrupo2", schema = "")
@NamedQueries({
    @NamedQuery(name = "DetVenda.findAll", query = "SELECT d FROM DetVenda d"),
    @NamedQuery(name = "DetVenda.findByProdutoidProduto", query = "SELECT d FROM DetVenda d WHERE d.detVendaPK.produtoidProduto = :produtoidProduto"),
    @NamedQuery(name = "DetVenda.findByVendaidVenda", query = "SELECT d FROM DetVenda d WHERE d.detVendaPK.vendaidVenda = :vendaidVenda"),
    @NamedQuery(name = "DetVenda.findByQtdeVenda", query = "SELECT d FROM DetVenda d WHERE d.qtdeVenda = :qtdeVenda"),
    @NamedQuery(name = "DetVenda.findByValorUnitario", query = "SELECT d FROM DetVenda d WHERE d.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "DetVenda.findByValorTotal", query = "SELECT d FROM DetVenda d WHERE d.valorTotal = :valorTotal")})
public class DetVenda implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetVendaPK detVendaPK;
    @Column(name = "qtde_venda")
    private Integer qtdeVenda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valor_unitario")
    private Double valorUnitario;
    @Column(name = "valor_total")
    private Double valorTotal;
    @JoinColumn(name = "Venda_id_Venda", referencedColumnName = "id_Venda", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venda venda;
    @Transient
    private String descricaoProduto;
    public DetVenda() {
    }

    public DetVenda(DetVendaPK detVendaPK) {
        this.detVendaPK = detVendaPK;
    }

    public DetVenda(int produtoidProduto, int vendaidVenda) {
        this.detVendaPK = new DetVendaPK(produtoidProduto, vendaidVenda);
    }

    public DetVendaPK getDetVendaPK() {
        return detVendaPK;
    }

    public void setDetVendaPK(DetVendaPK detVendaPK) {
        this.detVendaPK = detVendaPK;
    }

    public Integer getQtdeVenda() {
        return qtdeVenda;
    }

    public void setQtdeVenda(Integer qtdeVenda) {
        Integer oldQtdeVenda = this.qtdeVenda;
        this.qtdeVenda = qtdeVenda;
        changeSupport.firePropertyChange("qtdeVenda", oldQtdeVenda, qtdeVenda);
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        Double oldValorUnitario = this.valorUnitario;
        this.valorUnitario = valorUnitario;
        changeSupport.firePropertyChange("valorUnitario", oldValorUnitario, valorUnitario);
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        Double oldValorTotal = this.valorTotal;
        this.valorTotal = valorTotal;
        changeSupport.firePropertyChange("valorTotal", oldValorTotal, valorTotal);
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        Venda oldVenda = this.venda;
        this.venda = venda;
        changeSupport.firePropertyChange("venda", oldVenda, venda);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detVendaPK != null ? detVendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetVenda)) {
            return false;
        }
        DetVenda other = (DetVenda) object;
        if ((this.detVendaPK == null && other.detVendaPK != null) || (this.detVendaPK != null && !this.detVendaPK.equals(other.detVendaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "turmacgrupo2.DetVenda[ detVendaPK=" + detVendaPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    /**
     * @return the descricaoProduto
     */
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    /**
     * @param descricaoProduto the descricaoProduto to set
     */
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    
    
    
}
